#Append script for tdx-reference minimal
#ARV
#Toradex
#Layer meta-gateway

IMAGE_INSTALL += " \
    4g \
    ble \
    cloud \
    networkled \
    bluez5-noinst-tools \
    modemmanager \
    networkmanager \
    paho-mqtt-c \
    libqmi \
    openssl \
    nano \ 
    cjson \
    bc \
    vnstat \
    libgpiod \
    util-linux \
"
IMAGE_INSTALL_remove = " connman"
IMAGE_INSTALL_remove = " connman-client"
IMAGE_INSTALL_remove = " connman-gnome"
IMAGE_INSTALL_remove = " connman-plugin-wifi"
IMAGE_INSTALL_remove = " connman-plugin-ethernet"
IMAGE_INSTALL_remove = " connman-plugin-loopback"
PACKAGECONFIG_append_pn-networkmanager = " modemmanager ppp"

change_mod() {
        ln -nsf /usr/share/zoneinfo/Asia/Kolkata ${IMAGE_ROOTFS}/etc/localtime   
}

ROOTFS_POSTPROCESS_COMMAND += "change_mod; "
