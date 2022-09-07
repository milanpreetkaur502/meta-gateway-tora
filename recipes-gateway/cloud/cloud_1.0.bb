SUMMARY = "Cloud"
DESCRIPTION = "CLOUD"
LICENSE = "CLOSED"


SRC_URI = "file://pub_telemtry_single_packet \
           file://gt-pubsub.service \
           "
INSANE_SKIP_${PN} += "file-rdeps"

inherit systemd

S = "${WORKDIR}"

do_compile(){
}

do_install_append(){
        
	install -d ${D}${sbindir}/cloud
	install -m 777 ${S}/pub_telemtry_single_packet ${D}/${sbindir}/cloud
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/gt-pubsub.service ${D}${systemd_unitdir}/system


}

FILES_${PN} += " \
    ${systemd_unitdir}/system/* \
"


SYSTEMD_SERVICE_${PN} = "gt-pubsub.service "
SYSTEMD_AUTO_ENABLE_${PN} = "enable"


