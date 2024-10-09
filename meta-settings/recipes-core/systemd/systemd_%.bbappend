FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG:append = " networkd resolved"

SRC_URI += " \
    file://wlan.network \
"

RDEPENDS:${PN}:append = " wpa-supplicant"

FILES:${PN} += " \
    ${sysconfdir}/systemd/network/wlan.network \
"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0755 ${WORKDIR}/wlan.network ${D}${sysconfdir}/systemd/network
}
