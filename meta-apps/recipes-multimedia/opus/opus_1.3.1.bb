DESCRIPTION = "Opus is a totally open, royalty-free, highly versatile audio codec"
HOMEPAGE = "http://www.opus-codec.org/"
SECTION = "multimedia"
LICENSE = "CLOSED"
SRC_URI = "https://archive.mozilla.org/pub/opus/opus-${PV}.tar.gz"
SRC_URI[md5sum] = "d7c07db796d21c9cf1861e0c2b0c0617"
SRC_URI[sha256sum] = "65b58e1e25b2a114157014736a3d9dfeaad8d41be1c8179866f144a2fb44ff9d"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-float-approx"

PACKAGECONFIG ??= ""
PACKAGECONFIG[fixed-point] = "--enable-fixed-point,,"
PACKAGECONFIG[float-approx] = "--enable-float-approx,,"
PACKAGECONFIG[custom-modes] = "--enable-custom-modes,,"
PACKAGECONFIG[check-asm] = "--enable-check-asm,,"
PACKAGECONFIG[rtcd] = "--enable-rtcd,,"
PACKAGECONFIG[doc] = "--enable-doc,,doxygen-native"

BBCLASSEXTEND = "native nativesdk"
