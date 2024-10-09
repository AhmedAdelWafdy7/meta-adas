# meta-adas

This layer is for **ADAS** integration in OpenEmbedded/Yocto. <br/>
This repository pertains to the **Head Unit OS** component of the Autonomous Driving System within the Software Defined Vehicle.

# Dependencies

This layer depends on:

- URI: [https://github.com/yoctoproject/poky](https://github.com/yoctoproject/poky)
    - branch : kirkstone
    - commit : e139e9d0ce343ba77a09601a976c92acd562c9df
- URI: [git://git.openembedded.org/meta-openembedded](https://git.openembedded.org/meta-openembedded//)
    - branch : kirkstone
    - commit : 0560b848996a0feb410a8cd8ca07c60fe2f3b5bc
- URI: [https://github.com/agherzan/meta-raspberrypi](https://github.com/agherzan/meta-raspberrypi.git)
    - branch : kirkstone
    - commit : d7544f35756d87834e8b4bf3e3e733c771d380ae
- URI: [https://github.com/meta-qt5/meta-qt5](https://github.com/meta-qt5/meta-qt5.git)
    - branch : kirkstone
    - commit : 644ebf220245bdc06e7696ccc90acc97a0dd2566

# Quick Start

1. Clone all layers that have dependencies
2. Add layer in bblayers.conf 
3. Run the "conf.sh" (Change local.conf)

# References

- [Yocto Project](https://docs.yoctoproject.org/4.0.12/migration-guides/migration-4.0.html)
- [Meta-raspberrypi](https://meta-raspberrypi.readthedocs.io/en/latest/index.html)
- [Meta-Openembedded](https://layers.openembedded.org/layerindex/branch/master/layers/)
