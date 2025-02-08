#ENABLE I2C
ENABLE_I2C = "1"

do_deploy:append() {
    echo "# ENABLE U-BOOT" >> $CONFIG
    echo "ENABLE_UART = 1" >> $CONFIG
    echo "RPI_USE_U_BOOT = 1" >> $CONFIG
    
    echo "# REMOVE SPLASH SCREEN" >> $CONFIG
    echo "DISABLE_SPLASH = 1" >> $CONFIG
    
    echo "# REMOVE BOOT DELAY" >>$CONFIG
    echo "BOOT_DELAY = 0" >> $CONFIG
    echo "BOOT_DELAY_MS = 0" >> $CONFIG
    
    echo "# Enable Overclocked" >> $CONFIG
    echo "ARM_FREQ = 2100" >> $CONFIG
    echo "GPU_FREQ = 750" >> $CONFIG
    echo "OVER_VOLTAGE = 6" >> $CONFIG
    echo "FORCE_TURBO = 1" >> $CONFIG

    echo "# CAN" >> $CONFIG
    echo "dtoverlay=seeed-can-fd-hat-v2" >> $CONFIG
    
    echo "# HDMI" >> $CONFIG
    echo "hdmi_force_hotplug=1" >> $CONFIG
    echo "config_hdmi_boost=10" >> $CONFIG
    echo "hdmi_group=2" >> $CONFIG
    echo "hdmi_mode=87" >> $CONFIG 
    echo "hdmi_cvt 1024 1280 60 6 0 0 0" >> $CONFIG
    
    echo "# Audio" >> $CONFIG
    echo "dtparam=audio=on" >> $CONFIG
    echo "dtoverlay=vc4-kms-v3d,noaudio" >> $CONFIG

    echo "# pi_camera" >> $CONFIG
    echo "start_x=1" >> $CONFIG
    echo "gpu_mem=256" >> $CONFIG
}