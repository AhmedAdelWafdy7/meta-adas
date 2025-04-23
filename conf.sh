#!/bin/bash

CONF="../build/conf/local.conf"

sed -i "s|MACHINE ??= \"qemux86-64\"|MACHINE ??= \"raspberrypi4-64\"|" $CONF
sed -i "51s|#||g" $CONF
sed -i "67s|#||g" $CONF
sed -i "79s|#||g" $CONF

echo -e "\n# To get sdimg" >> $CONF
echo "IMAGE_FSTYPES = \"ext4.xz rpi-sdimg\"" >> $CONF
echo -e "SDIMG_ROOTFS_TYPE = \"ext4.xz\"\n" >> $CONF

echo "# Set number of cores" >> $CONF
echo "BB_NUMBER_THREADS = \"12\"" >> $CONF
echo -e "PARALLEL_MAKE = \"-j 12\"\n" >> $CONF

echo "# Enable systemd" >> $CONF
echo -e "INIT_MANAGER = \"systemd\"\n" >> $CONF

echo "#Load I2C" >> $CONF
echo -e "KERNEL_MODULE_AUTOLOAD += \"i2c-dev i2c-bcm2708\"\n" >> $CONF

echo "#Enable CAN" >> $CONF
echo -e "KERNEL_DEVICETREE:append = \" \\ 
    overlays/mcp251xfd.dtbo \\
\"\n" >> $CONF

echo "#Enable Wayland" >> $CONF
echo -e "DISTRO_FEATURES:append = \"wayland\"" >> $CONF
echo -e "CORE_IMAGE_EXTRA_INSTALL = \"wayland\"" >> $CONF
echo -e "PACKAGECONFIG:remove:pn-qtwayland = \"xcomposite-glx\"" >> $CONF

echo "#Enable Camera" >> $CONF
echo -e "VIDEO_CAMERA = \"1\"" >> $CONF

echo "# IP Compliance about WiFi/BT pacakge" >> $CONF
echo -e "LICENSE_FLAGS_ACCEPTED += \"synaptics-killswitch\"\n" >> $CONF

# Add WiFi support
echo "# Enable WiFi support" >> $CONF
echo "DISTRO_FEATURES:append = \" wifi\"" >> $CONF
echo "MACHINE_FEATURES:append = \" wifi bluetooth\"" >> $CONF
echo "CORE_IMAGE_EXTRA_INSTALL:append = \" linux-firmware-rpidistro-bcm43455 wireless-regdb wpa-supplicant iw\"" >> $CONF

# Define environment variables
export NAMESPACE="sdv-system"
export OTA_VERSION="1.0.0"
export ECU_CORE_VERSION="1.0.0"

# Create the namespace if it doesn't exist
kubectl create namespace $NAMESPACE --dry-run=client -o yaml | kubectl apply -f -

# Apply RBAC configurations
kubectl apply -f Secure-OTA-Application/kubernetes/config/rbac.yaml -n $NAMESPACE

# Apply ConfigMaps
kubectl apply -f Secure-OTA-Application/kubernetes/config/ota-configmap.yaml -n $NAMESPACE

# Create persistent volume claims
kubectl apply -f Secure-OTA-Application/kubernetes/storage/storage-claims.yaml -n $NAMESPACE

# Deploy OTA components
kubectl apply -f Secure-OTA-Application/kubernetes/deployments/server-deployment.yaml -n $NAMESPACE
kubectl apply -f Secure-OTA-Application/kubernetes/deployments/app-deployment.yaml -n $NAMESPACE
kubectl apply -f Secure-OTA-Application/kubernetes/deployments/ota-manager-deployment.yaml -n $NAMESPACE
kubectl apply -f Secure-OTA-Application/kubernetes/services/ota-services.yaml -n $NAMESPACE

# Deploy ECU-CORE components
kubectl apply -f ECU-CORE/kubernetes/deployments/ros-master-deployment.yaml -n $NAMESPACE
kubectl apply -f ECU-CORE/kubernetes/deployments/sensor-node-deployment.yaml -n $NAMESPACE
kubectl apply -f ECU-CORE/kubernetes/deployments/control-node-deployment.yaml -n $NAMESPACE
kubectl apply -f ECU-CORE/kubernetes/services/ros-services.yaml -n $NAMESPACE

echo "SDV system deployment complete!"