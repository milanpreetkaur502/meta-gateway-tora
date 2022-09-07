#!/bin/sh
sleep 1
mmcli -m 0 -e
sleep 2

cat <<EOF >/etc/qmi-network.conf
APN=$APN
APN_USER=
APN_PASS=
PROXY=yes
EOF
ifconfig wwan0 down
qmi-network /dev/cdc-wdm0 stop
qmi-network /dev/cdc-wdm0 start
udhcpc -q -f -i wwan0 -n
cat <<EOF >/etc/resolv.conf
nameserver 8.8.8.8
nameserver 8.8.4.4
EOF
