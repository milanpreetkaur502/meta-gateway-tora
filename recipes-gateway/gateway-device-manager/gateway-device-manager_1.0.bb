
SUMMARY = "Gateway Device Manager"
DESCRIPTION = "Device manager flask HTTP web server deployed on Apache2 to configure gateway device"
HOMEPAGE = "https://github.com/ScratchnestMPU/Gateway-Device-Manager.git"
LICENSE = "CLOSED"


SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/milanpreetkaur502/Gateway-Device-Manager.git;protocol=https;user=milanpreetkaur502+deploy-token-1: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;branch=master"

inherit allarch

S = "${WORKDIR}/git"

do_compile(){
}

do_install_append(){
	install -d ${D}${datadir}/apache2/default-site/htdocs/gdm
	cp -r ${S}/* ${D}${datadir}/apache2/default-site/htdocs/gdm

}


FILES_${PN} += "${datadir}/*"
