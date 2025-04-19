DESCRIPTION = "Efficient binary-decimal and decimal-binary conversion routines for IEEE doubles"
HOMEPAGE = "https://github.com/google/double-conversion"
SECTION = "libs"
LICENSE = "CLOSED"
SRC_URI = "https://github.com/google/double-conversion/archive/refs/tags/v${PV}.tar.gz"
SRC_URI[sha256sum] = "04ec44461850abbf33824da84978043b22554896b552c5fd11a9c5ae4b4d296e"

inherit cmake

EXTRA_OECMAKE = " \
    -DBUILD_SHARED_LIBS=ON \
    -DBUILD_TESTING=OFF \
"

# Disable parallel make as it can cause build failures
PARALLEL_MAKE = ""

BBCLASSEXTEND = "native nativesdk"
