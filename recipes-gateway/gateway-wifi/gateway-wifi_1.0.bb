SUMMARY = "Gateway Application"
DESCRIPTION = "Wifi control and config handler for TI module over connman"
LICENSE = "CLOSED"


SRC_URI = "file://wifiControl.service \
           file://wifi_control.sh \
           "

inherit allarch systemd

S = "${WORKDIR}"

do_compile(){
}

do_install_append(){
        
	install -d ${D}${sbindir}/wifiCtrl
	install -m 755 ${S}/wifi_control.sh ${D}/${sbindir}/wifiCtrl
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${S}/wifiControl.service ${D}${systemd_unitdir}/system


}

SYSTEMD_SERVICE_${PN} = "wifiControl.service"
SYSTEMD_AUTO_ENABLE_${PN} = "disable"
RDEPENDS_${PN} += " bash"


