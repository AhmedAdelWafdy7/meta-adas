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
qtcore \
qtqml \
qt3d \
qt3d-render \
qt3d-input \
qt3d-core \
qt3d-quick \
qt3d-quick-private \    
"

DEPENDS = " \
${QT_BASE} \
${QT_PKGS} \
"

RDEPENDS:${PN} = " \
${QT_BASE} \
${QT_PKGS} \
"

SRC_URI = "git://github.com/AhmedAdelWafdy7/ECU-HEAD.git;protocol=https;branch=master"

SRCREV = "49487c4369d70f9ae383dab4b7a1f5b2b51f0d29"

S = "${WORKDIR}/git"

inherit qmake5
