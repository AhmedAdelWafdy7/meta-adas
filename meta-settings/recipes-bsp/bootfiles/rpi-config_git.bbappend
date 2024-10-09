#ENABLE I2C
ENABLE_I2C = "1"

do_deploy:append() {
    echo "# CAN" >> $CONFIG
    echo "dtparam=spi=on" >> $CONFIG
    echo "dtoverlay=spi1-3cs" >> $CONFIG
    echo "dtoverlay=mcp251xfd,spi0-0,interrupt=25" >> $CONFIG
    echo "dtoverlay=mcp251xfd,spi1-0,interrupt=24" >> $CONFIG
    
    echo "# HDMI" >> $CONFIG
    echo "hdmi_force_hotplug=1" >> $CONFIG
    echo "config_hdmi_boost=10" >> $CONFIG
    echo "hdmi_group=2" >> $CONFIG
    echo "hdmi_mode=87" >> $CONFIG 
    echo "hdmi_cvt 1024 600 60 6 0 0 0" >> $CONFIG
}
