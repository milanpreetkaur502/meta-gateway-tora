SUMMARY = "Python interface to Bluetooth LE on Linux"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=59e0d45ea684dda215889aa1b5acd001"
HOMEPAGE = "https://github.com/IanHarvey/bluepy"

SRCREV = "${AUTOREV}"

SRC_URI = " \
    git://github.com/IanHarvey/bluepy.git;protocol=https;branch=master \
"

S = "${WORKDIR}/git"

# use python2
#inherit setuptools python-dir

# use python3
inherit setuptools3 python3-dir

DEPENDS += " \
    ${PYTHON_PN} \
    glib-2.0 \
"

RDEPENDS_${PN} = " \
    bluez5 \
"

TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN} = " \
    ${bindir} \
    ${PYTHON_SITEPACKAGES_DIR} \
"
