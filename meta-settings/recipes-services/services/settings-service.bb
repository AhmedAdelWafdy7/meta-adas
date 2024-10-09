LICENSE = "CLOSED"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = " \
can.service \
"

SRC_URI += " \
file://can.service \
file://can-service.sh \
"

RDEPENDS:${PN} = " \
bash \
"

do_install:append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/can.service ${D}/${systemd_unitdir}/system

  install -d ${D}${bindir}
  install -m 0755 ${WORKDIR}/can-service.sh ${D}${bindir}
}
