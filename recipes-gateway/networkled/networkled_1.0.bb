SUMMARY = "Network LED"
DESCRIPTION = "Network Led"
LICENSE = "CLOSED"


SRC_URI = "file://networkled.sh \
           file://gt-networkled.service \
           "

inherit allarch systemd

S = "${WORKDIR}"

do_compile(){
}

do_install_append(){
        
	install -d ${D}${sbindir}/networkled
	install -m 777 ${S}/networkled.sh ${D}/${sbindir}/networkled
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/gt-networkled.service ${D}${systemd_unitdir}/system


}

SYSTEMD_SERVICE_${PN} = "gt-networkled.service "
SYSTEMD_AUTO_ENABLE_${PN} = "enable"


