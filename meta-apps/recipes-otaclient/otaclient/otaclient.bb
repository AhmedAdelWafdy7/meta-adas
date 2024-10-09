DESCRIPTION = "OTA_Client"
SECTION = "apps"
LICENSE = "CLOSED"

DEPENDS = " \
mosquitto \
curl \
openssl \
nlohmann-json \
"

RDEPENDS:${PN} = " \
mosquitto \
curl \
openssl \
nlohmann-json \
"

SRC_URI = "file://info_client.cpp"

SRCREV = "6085cdf92dd3babfbede0f2f815bc5f5b576348e"

S = "${WORKDIR}"

INSANE_SKIP:${PN} += "ldflags"

do_compile() {
         ${CXX} info_client.cpp -o info_client -lmosquitto -lcurl -lssl -lcrypto -Wno-deprecated-declarations
}

do_install() {
         install -d ${D}${bindir}
         install -m 0755 info_client ${D}${bindir}
}
