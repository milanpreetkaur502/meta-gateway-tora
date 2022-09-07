SUMMARY = "Gateway Job Application"
DESCRIPTION = "Job parser python script to handle AWS jobs"
LICENSE = "CLOSED"


SRC_URI = "file://mainjob.py \
           file://job.service \
           "

inherit allarch systemd

S = "${WORKDIR}"

do_compile(){
}

do_install_append(){
        
	install -d ${D}${sbindir}/job
	install -m 777 ${S}/mainjob.py ${D}/${sbindir}/job
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/job.service ${D}${systemd_unitdir}/system


}

SYSTEMD_SERVICE_${PN} = "job.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"


