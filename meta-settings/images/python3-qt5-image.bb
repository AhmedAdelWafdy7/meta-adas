SUMMARY = "A PyQt5 development image"

require qt5-basic-image.bb

TSLIB = " \
    tslib \
"

PYTHON_TOOLS += " \
	python3-paho-mqtt \
	python-mpd2 \
"

QT_TOOLS += " \
    python3-pyqt5 \
	raspi2fb \
	qt5-env \
"

export IMAGE_BASENAME = "python3-qt5-image"
