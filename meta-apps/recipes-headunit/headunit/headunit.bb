DESCRIPTION = "headunit"
SECTION = "apps"
LICENSE = "CLOSED"

QT_BASE = "qtbase"

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
    qtlocation \
    qtwebchannel \
"

DEPENDS += " \
    cmake-native \
    ${QT_BASE} \
    ${QT_PKGS} \
    mesa \
    libx11 \
    libxcb \
    libpng \
    jpeg \
    ffmpeg \
    libvpx \
    libwebp \
    freetype \
    fontconfig \
    harfbuzz \
    cairo \
    librsvg \
    openjpeg \
    x264 \
    udev \
    dbus \
    libxml2 \
    libxslt \
    glib-2.0 \
    pango \
    gdk-pixbuf \
    systemd \
    expat \
    zlib \
    double-conversion \
    zstd \
    snappy \
    re2 \
    libevent \
    alsa-lib \
    openssl \
    gnutls \
    icu \
    nss \
    krb5 \
"

RDEPENDS:${PN} += " \
    ${QT_BASE} \
    ${QT_PKGS} \
    mesa \
    libx11 \
    libxcb \
    libpng \
    jpeg \
    ffmpeg \
    libvpx \
    libwebp \
    freetype \
    fontconfig \
    harfbuzz \
    cairo \
    librsvg \
    openjpeg \
    x264 \
    udev \
    dbus \
    libxml2 \
    libxslt \
    glib-2.0 \
    pango \
    gdk-pixbuf \
    systemd \
    expat \
    zlib \
    double-conversion \
    zstd \
    snappy \
    re2 \
    libevent \
    alsa-lib \
    openssl \
    gnutls \
    icu \
    nss \
    krb5 \
"

SRC_URI = "git://github.com/AhmedAdelWafdy7/ECU-HEAD.git;protocol=https;branch=adas"

SRCREV = "e24176d2379d6142a60b1fabdbedc9ba80f9a5e1"

S = "${WORKDIR}/git"

# Add debug symbols and ensure proper build configuration
EXTRA_OECMAKE += " \
    -DCMAKE_BUILD_TYPE=Debug \
    -DBUILD_EXE=1 \
    -DBUILD_LIB=1 \
    -DBUILD_CONF=1 \
    -DBUILD_APP=1 \
    -DQT_QPA_PLATFORM=eglfs \
    -DQT_QPA_EGLFS_INTEGRATION=eglfs_kms \
    -DQT_QPA_EGLFS_KMS_CONFIG=/etc/qt5/eglfs_kms.json \
    -DQT_QPA_EGLFS_FORCE888=1 \
    -DQT_QPA_EGLFS_HIDECURSOR=1 \
    -DQT_QPA_EGLFS_NO_LIBINPUT=1 \
    -DQT_QUICK_CONTROLS_STYLE=Material \
    -DQT_QUICK_CONTROLS_1_STYLE=Material \
"

# Add environment variables for Qt configuration
do_install:append() {
    install -d ${D}${sysconfdir}/qt5
    echo '{
        "device": "/dev/dri/card0",
        "hwcursor": true,
        "pbuffers": true,
        "outputs": [
            {
                "name": "HDMI1",
                "mode": "preferred"
            }
        ]
    }' > ${D}${sysconfdir}/qt5/eglfs_kms.json
}

# Ensure proper file installation
FILES:${PN} += " \
    ${bindir}/HeadUnit \
    ${libdir}/qml/User \
    ${sysconfdir}/qt5/eglfs_kms.json \
"

inherit cmake_qt5
