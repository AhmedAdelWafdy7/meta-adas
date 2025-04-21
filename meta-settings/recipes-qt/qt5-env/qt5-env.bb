SUMMARY = "Add Qt5 bin dir to PATH"

LICENSE = "CLOSED"
SRC_URI = "file://qt5-env.sh"

PR = "r1"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0755 qt5-env.sh ${D}${sysconfdir}/profile.d
}

FILES_${PN} = "${sysconfdir}"

