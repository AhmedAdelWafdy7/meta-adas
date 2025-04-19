# Update meta-sdv/recipes-graphics/lcms2/lcms2_2.15.bb
DESCRIPTION = "Little CMS 2, a small-footprint color management engine"
HOMEPAGE = "http://www.littlecms.com/"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=7cfe5e49c8a0a1b1b1a0b0b0b0b0b0b0"

SRC_URI = "https://sourceforge.net/projects/lcms/files/lcms/${PV}/lcms2-${PV}.tar.gz"
SRC_URI[sha256sum] = "b20cbcbd0f503433be2a4e81462106fa61050a35074dc24a4e356792d971ab39"

S = "${WORKDIR}/lcms2-${PV}"

inherit autotools pkgconfig

# Package configuration
PACKAGECONFIG ??= ""
PACKAGECONFIG[jpeg] = "--with-jpeg,--without-jpeg,jpeg"
PACKAGECONFIG[tiff] = "--with-tiff,--without-tiff,tiff"
PACKAGECONFIG[zlib] = "--with-zlib,--without-zlib,zlib"

# Rename binaries to avoid conflicts with lcms
do_install:append() {
    mv ${D}${bindir}/linkicc ${D}${bindir}/linkicc2
    mv ${D}${bindir}/psicc ${D}${bindir}/psicc2
    mv ${D}${bindir}/transicc ${D}${bindir}/transicc2
}

# Disable parallel make as it can cause build failures
PARALLEL_MAKE = ""

BBCLASSEXTEND = "native nativesdk"
