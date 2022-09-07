SUMMARY = "Internet status LED"
DESCRIPTION = "Monitor internet connection and controls led"
LICENSE = "CLOSED"


SRC_URI = "file://iled.sh \
           file://iled.service \
           "

inherit allarch systemd

S = "${WORKDIR}"

do_compile(){
}

do_install_append(){
        
	install -d ${D}${sbindir}/led
	install -m 755 ${S}/iled.sh ${D}/${sbindir}/led
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${S}/iled.service ${D}${systemd_unitdir}/system


}

SYSTEMD_SERVICE_${PN} = "iled.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"
RDEPENDS_${PN} += "bash"

