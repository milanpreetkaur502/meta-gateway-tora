SUMMARY = "Gateway Control scripts"
DESCRIPTION = "Scripts to control gateway service"
LICENSE = "CLOSED"


SRC_URI = "file://restart_app.sh \
           file://restart_wifi.sh \
           file://restart_job.sh \
           "

inherit allarch

S = "${WORKDIR}"

do_compile(){
}

do_install_append(){
        
	install -d ${D}${sbindir}/control_scripts
        install -m 755 ${S}/restart_app.sh ${D}/${sbindir}/control_scripts
	install -m 755 ${S}/restart_job.sh ${D}/${sbindir}/control_scripts
	install -m 755 ${S}/restart_wifi.sh ${D}/${sbindir}/control_scripts        

}
RDEPENDS_${PN} += "bash"


