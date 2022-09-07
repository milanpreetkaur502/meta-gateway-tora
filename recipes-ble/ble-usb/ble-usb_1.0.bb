
DESCRIPTION = "BLE device udev rules for auto detect and systemd service to attach/deattach the device"
SECTION = "BLE"

LICENSE = "CLOSED"

SRC_URI = "file://ble.rules \
           file://bt_init.sh \
            file://mg_init.sh \
           file://ble.service"
	  
	   
inherit allarch systemd



S = "${WORKDIR}"

do_install_append() {
  install -d ${D}${sysconfdir}/udev/rules.d
  install -m 0644 ${WORKDIR}/ble.rules     ${D}${sysconfdir}/udev/rules.d
  
  install -d ${D}${sbindir}
  install -m 0755 ${WORKDIR}/bt_init.sh ${D}/${sbindir}
  install -m 0755 ${WORKDIR}/mg_init.sh ${D}/${sbindir}
  

  install -d ${D}${systemd_unitdir}/system
  install -m 0644 ${S}/ble.service ${D}/${systemd_unitdir}/system
}

SYSTEMD_SERVICE_${PN} = "ble.service"




