SUMMARY = "BLE"
DESCRIPTION = "BLE"
LICENSE = "CLOSED"


SRC_URI = "file://glib_gateway_arm \
           file://gt-collector.service"
        
INSANE_SKIP_${PN} += "file-rdeps"

inherit systemd

S = "${WORKDIR}"

do_compile(){
}

do_install_append(){
        
	install -d ${D}${sbindir}/ble
	install -m 777 ${S}/glib_gateway_arm ${D}/${sbindir}/ble
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/gt-collector.service ${D}${systemd_unitdir}/system


}

FILES_${PN} += " \
    ${systemd_unitdir}/system/* \
    ${libdir}/* "

SYSTEMD_SERVICE_${PN} = "gt-collector.service "
SYSTEMD_AUTO_ENABLE_${PN} = "enable"


