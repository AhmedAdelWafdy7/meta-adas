# Update meta-sdv/recipes-multimedia/x265/x265_3.5.bb
DESCRIPTION = "x265 is a H.265/HEVC video encoder"
HOMEPAGE = "http://x265.org/"
SECTION = "multimedia"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

# Use the official release tarball instead of git
SRC_URI = "https://bitbucket.org/multicoreware/x265/downloads/x265_${PV}.tar.gz"
SRC_URI[sha256sum] = "5ca3403c08de4716719575ec56c686b1eb55b078c0fe50a064dcf1ac5af8a209"

S = "${WORKDIR}/x265_${PV}/source"

inherit cmake

EXTRA_OECMAKE = " \
    -DENABLE_SHARED=ON \
    -DENABLE_PIC=ON \
    -DENABLE_CLI=ON \
    -DENABLE_HDR10_PLUS=ON \
    -DENABLE_LIBNUMA=OFF \
    -DENABLE_TESTS=OFF \
"

# x265 requires a C++11 compiler
CXXFLAGS += "-std=c++11"

# Disable parallel make as it can cause build failures
PARALLEL_MAKE = ""

BBCLASSEXTEND = "native nativesdk"
