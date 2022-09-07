SUMMARY = "Gateway Application"
DESCRIPTION = "Application handling cloud, node and database thread to communicate IOT Device to cloud server"
LICENSE = "CLOSED"


SRC_URI = "file://setup.py \
           file://gatewayapp/main.py \
           file://gatewayapp/configHandler.py \
           file://gatewayapp/node.py \
           file://gatewayapp/cloud.py \
           file://gatewayapp/__init__.py \
           file://app.service \
           file://gatewayMain.sh \
           file://gateway.conf \
           file://network.conf \
           "

inherit allarch systemd setuptools3

S = "${WORKDIR}"

do_compile(){
}

do_install_append(){
        
	install -d ${D}${sbindir}/app
        install -d ${D}${sysconfdir}/gateway/certUploads
        install -d ${D}${sysconfdir}/gateway/network
        install -d ${D}${sysconfdir}/gateway/config
	install -m 755 ${S}/gatewayMain.sh ${D}/${sbindir}/app
        install -m 777 ${S}/gateway.conf ${D}/${sysconfdir}/gateway/config
        install -m 777 ${S}/network.conf ${D}/${sysconfdir}/gateway/network
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${S}/app.service ${D}${systemd_unitdir}/system


}

SYSTEMD_SERVICE_${PN} = "app.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"
RDEPENDS_${PN} += "bash"

