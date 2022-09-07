#!/bin/sh

#USB_CDC TTY HCI ATTACH

dev_id=$(ls /dev | grep ttyACM)
if [[ -n $dev_id ]]; then
  echo "BT found"
  d="/dev/"$dev_id
  btattach -B $d -S 1000000 -P h4
else
  echo "No device"
fi
