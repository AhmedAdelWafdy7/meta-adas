# Update meta-sdv/recipes-support/minizip/minizip_1.2.13.bb
DESCRIPTION = "Minizip is a simple zip/unzip library"
HOMEPAGE = "https://github.com/madler/zlib"
SECTION = "libs"
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://COPYING;md5=7cfe5e49c8a0a1b1b1a0b0b0b0b0b0b0"

SRC_URI = "https://github.com/madler/zlib/archive/refs/tags/v${PV}.tar.gz"
SRC_URI[md5sum] = "9c7d356c5acaa563555490676ca14d23"
SRC_URI[sha256sum] = "1525952a0a567581792613a9723333d7f8cc20b87a81f920fb8bc7e3f2251428"

S = "${WORKDIR}/zlib-${PV}/contrib/minizip"

inherit autotools

DEPENDS = "zlib"

# Remove problematic configure options
EXTRA_OECONF:remove = "--disable-bzip2 --disable-lzma"

# Package configuration
PACKAGECONFIG ??= ""
PACKAGECONFIG[bzip2] = ",,bzip2"
PACKAGECONFIG[lzma] = ",,xz"

# Disable parallel make as it can cause build failures
PARALLEL_MAKE = ""

BBCLASSEXTEND = "native nativesdk"
