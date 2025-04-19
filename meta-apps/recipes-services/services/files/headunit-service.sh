#!/bin/bash

export YOUTUBE_API_KEY=AIzaSyA-eizylBNGDZSTK3FMWt7XgeEubKCkh6o
# EGLFS Configuration
export QT_QPA_PLATFORM=eglfs
export QT_QPA_EGLFS_INTEGRATION=eglfs_kms
export QT_QPA_EGLFS_KMS_CONFIG=/etc/qt5/eglfs_kms.json
export QT_QPA_EGLFS_FORCE888=1
export QT_QPA_EGLFS_HIDECURSOR=1
export QT_QPA_EGLFS_NO_LIBINPUT=1

# OpenGL Configuration
export LIBGL_DEBUG=verbose
export LIBGL_DRIVERS_PATH=/usr/lib/dri
export MESA_GL_VERSION_OVERRIDE=3.3
export MESA_GLSL_VERSION_OVERRIDE=330

# Qt Configuration
export QT_IM_MODULE=qtvirtualkeyboard
export QT_QUICK_CONTROLS_STYLE=Material
export QT_QUICK_CONTROLS_1_STYLE=Material
export QML_IMPORT_PATH=/usr/lib/qt5/qml
export QT_PLUGIN_PATH=/usr/lib/qt5/plugins
export QT_QPA_PLATFORM_PLUGIN_PATH=/usr/lib/qt5/plugins/platforms

# Geoservice Configuration
export QT_LOCATION_PLUGINS=/usr/lib/qt5/plugins/geoservices
export QT_POSITIONING_BACKEND=geoclue2

/usr/bin/HeadUnit --no-sandbox -platform eglfs -fullscreen &
