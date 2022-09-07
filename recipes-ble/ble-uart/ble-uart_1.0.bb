
DESCRIPTION = "BLE device HCI attact over uart"
SECTION = "BLE"

LICENSE = "CLOSED"

SRC_URI = "file://bt_att.sh \
           file://bt_pow.sh \
           file://btuart.service"
	  
	   
inherit allarch systemd



S = "${WORKDIR}"

do_install_append() {
  
  install -d ${D}${sbindir}/ble
  install -m 0755 ${WORKDIR}/bt_att.sh ${D}/${sbindir}/ble
  install -m 0755 ${WORKDIR}/bt_pow.sh ${D}/${sbindir}/ble
  

  install -d ${D}${systemd_unitdir}/system
  install -m 0644 ${S}/btuart.service ${D}/${systemd_unitdir}/system
}

SYSTEMD_SERVICE_${PN} = "btuart.service"




