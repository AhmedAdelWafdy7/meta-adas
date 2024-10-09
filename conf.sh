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
