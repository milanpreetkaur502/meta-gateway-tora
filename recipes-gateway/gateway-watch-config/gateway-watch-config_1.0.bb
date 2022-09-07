SUMMARY = "Gateway configuration change detection and service restart"
DESCRIPTION = "Service to monitor changes on config file and restart app,job services"
LICENSE = "CLOSED"


SRC_URI = "file://confwatch.service \
           file://confwatch.path \
           "

inherit allarch systemd

S = "${WORKDIR}"

do_compile(){
}

do_install_append(){
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/confwatch.service ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/confwatch.path ${D}${systemd_unitdir}/system


}

SYSTEMD_SERVICE_${PN} = "confwatch.service confwatch.path"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

