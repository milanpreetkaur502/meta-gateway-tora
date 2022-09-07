#!/bin/sh

function blink () {
	for I in {1..10}; do
		echo 1 > /sys/class/gpio/gpio24/value
		sleep 0.5
		echo 0 > /sys/class/gpio/gpio24/value
		sleep 0.5
	done
}

NET_STATUS="false"

# set pin stuff
echo 24 > /sys/class/gpio/export
echo "out" > /sys/class/gpio/gpio24/direction
echo 0 > /sys/class/gpio/gpio24/value

wget --spider google.com -T 20 -q
TMP=$?
if [ ${TMP} = 0 ]; then
	NET_STATUS="true"
	echo NET CONNECTED
fi

while true; do
	echo  STATUS - ${NET_STATUS}
	if [ $NET_STATUS = "true" ]; then
		echo NET CONNECTED
		echo 1 > /sys/class/gpio/gpio24/value
		echo "connected" > /tmp/netstatus
		sleep 60
	else
		echo NET DISCONNECTED
		echo "disconnected" > /tmp/netstatus
		blink
	fi

	wget --spider google.com -T 10 -q
	TMP=$?
	if [ ${TMP} = 0 ]; then
        	NET_STATUS="true"
	else
		NET_STATUS="false"
	fi
done
