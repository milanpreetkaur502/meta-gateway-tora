SUMMARY = "Python Bleak for BLE implementation"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=bcbc2069a86cba1b5e47253679f66ed7"
HOMEPAGE = "https://bleak.readthedocs.io/en/latest/"
SRCREV = "${AUTOREV}"
#SRC_URI[sha256sum] = "aba9bb114a4502d62e3ecedd96747db5c03d1f2134edb56077b0080a7951aa31"
SRC_URI = " \
    https://github.com/hbldh/bleak;branch=develop \
"

S = "${WORKDIR}/git"

# use python2
#inherit setuptools python-dir

# use python3
inherit setuptools3 python3-dir

DEPENDS += " \
    ${PYTHON_PN} \
"

RDEPENDS_${PN} = " \
    bluez5 \
"

#TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN} = " \
    ${bindir} \
    ${PYTHON_SITEPACKAGES_DIR} \
"
