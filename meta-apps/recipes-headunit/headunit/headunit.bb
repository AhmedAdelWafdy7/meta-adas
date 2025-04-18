DESCRIPTION = "headunit"
SECTION = "apps"
LICENSE = "CLOSED"

QT_BASE = " \
qtbase \
"

QT_PKGS = " \
qtdeclarative \
qtserialbus \
qtquickcontrols \
qtquickcontrols2 \
qtx11extras \
qtconnectivity \
qtmultimedia \
qtgraphicaleffects \
qtwebengine \
qtvirtualkeyboard \   
"

DEPENDS = "cmake-native \
${QT_BASE} \
${QT_PKGS} \
"

RDEPENDS:${PN} = " \
${QT_BASE} \
${QT_PKGS} \
"

SRC_URI = "git://github.com/AhmedAdelWafdy7/ECU-HEAD.git;protocol=https;branch=adas"

SRCREV = "e24176d2379d6142a60b1fabdbedc9ba80f9a5e1"

S = "${WORKDIR}/git"
EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Debug"
inherit cmake_qt5
