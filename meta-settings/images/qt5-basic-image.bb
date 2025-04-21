SUMMARY = "A basic Qt5 qwidgets dev image"

require console-basic-image.bb

QT_DEV_TOOLS = " \
    qtbase-dev \
    qtbase-mkspecs \
    qtbase-plugins \
    qtbase-tools \
    qtcharts-dev \
    qtcharts-mkspecs \
    qtdeclarative-dev \
    qtdeclarative-mkspecs \
    qtquickcontrols2-dev \
    qtquickcontrols2-mkspecs \
    qtserialport-dev \
    qtserialport-mkspecs \
"

QT_TOOLS = " \
    qtbase \
    qtserialport \
    qtcharts \
    qtdeclarative \
    qtdeclarative-plugins \
    qtdeclarative-qmlplugins \
    qtquickcontrols2 \
    qt5-env \
"

FONTS = " \
    fontconfig \
    fontconfig-utils \
    ttf-bitstream-vera \
"

PYTHON_TOOLS = " \
"

TSLIB = " \
"

IMAGE_INSTALL += " \
    ${FONTS} \
    ${QT_DEV_TOOLS} \
    ${QT_TOOLS} \
    ${PYTHON_TOOLS} \
    ${TSLIB} \
    qtvirtualkeyboard \
    dashboard \
"

export IMAGE_BASENAME = "qt5-basic-image"
