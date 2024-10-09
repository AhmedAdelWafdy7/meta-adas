LICENSE = "CLOSED"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = " \
headunit.service \
mqtt.service \
"

SRC_URI += " \
file://headunit.service \
file://headunit-service.sh \
file://mqtt.service \
file://mqtt-service.sh \
"

RDEPENDS:${PN} = " \
bash \
"

do_install:append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/headunit.service ${D}/${systemd_unitdir}/system 
  install -m 0644 ${WORKDIR}/mqtt.service ${D}/${systemd_unitdir}/system

  install -d ${D}${bindir}
  install -m 0755 ${WORKDIR}/headunit-service.sh ${D}${bindir}
  install -m 0755 ${WORKDIR}/mqtt-service.sh ${D}${bindir}
}
