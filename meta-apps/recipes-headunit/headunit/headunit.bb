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
qtconnectivity \
qtmultimedia \
qtgraphicaleffects \
qtwebengine \
qtvirtualkeyboard \   
"

DEPENDS = " cmake-native \
openssl \
${QT_BASE} \
${QT_PKGS} \
"

RDEPENDS:${PN} = " openssl \
${QT_BASE} \
${QT_PKGS} \
"

SRC_URI = "git://github.com/AhmedAdelWafdy7/ECU-HEAD.git;protocol=https;branch=master \
file://    
"

SRCREV = "49487c4369d70f9ae383dab4b7a1f5b2b51f0d29"

S = "${WORKDIR}/git"

inherit cmake_qt5

EXTRA_OECMAKE += " -DBUILD_EXE=1 \
-DBUILD_LIB=1 \ 
-DBUILD_CONF=1 \
-DBUILD_APP=1 \
"

do_install:append() {
    install -d ${D}${sysconfdir}/ssl/certs
    install -m 0755 ${WORKDIR}/youtube.pem ${D}${sysconfdir}/ssl/certs/
}

FILES:${PN} += " \ 
${bindir}/app-hu \
${libdir}/qml/User \
"