SUMMARY = "Gateway wifi network detection and service restart"
DESCRIPTION = "Service to monitor changes on wifi and restart wifi service"
LICENSE = "CLOSED"


SRC_URI = "file://netwatch.service \
           file://netwatch.path \
           "

inherit allarch systemd

S = "${WORKDIR}"

do_compile(){
}

do_install_append(){
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/netwatch.service ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/netwatch.path ${D}${systemd_unitdir}/system
}

SYSTEMD_SERVICE_${PN} = "netwatch.service netwatch.path"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"
