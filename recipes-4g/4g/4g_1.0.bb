SUMMARY = "4G"
DESCRIPTION = "4G"
LICENSE = "CLOSED"


SRC_URI = "file://4g.sh \
           file://gt-4g.service \
           "

inherit allarch systemd

S = "${WORKDIR}"

do_compile(){
}

do_install_append(){
        
	install -d ${D}${sbindir}/4g
	install -m 777 ${S}/4g.sh ${D}/${sbindir}/4g
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/gt-4g.service ${D}${systemd_unitdir}/system


}

SYSTEMD_SERVICE_${PN} = "gt-4g.service "
SYSTEMD_AUTO_ENABLE_${PN} = "enable"


