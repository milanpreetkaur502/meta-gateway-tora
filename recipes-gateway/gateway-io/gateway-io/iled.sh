#!/bin/bash
led=OFF
echo 117 > /sys/class/gpio/export
echo "out" > /sys/class/gpio/gpio117/direction
echo 0 > /sys/class/gpio/gpio117/value
while true
do
	St=$(connmanctl state | grep State | awk '{print $3}')
	if [[ $St == online && $led == OFF ]]
	then
		echo 1 > /sys/class/gpio/gpio117/value
		led=ON
 	elif [[ $St != online && $led == ON ]]
	then
		echo 0 > /sys/class/gpio/gpio117/value
		led=OFF
	fi
	sleep 3
done

