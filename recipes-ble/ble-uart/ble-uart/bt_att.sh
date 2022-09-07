#!/bin/sh

#UART BT attach

dev_id=colibri-uartb
if [[ -n $dev_id ]]; then
  echo "BT found"
  d="/dev/"$dev_id
  btattach -B $d -S 1000000 -P h4
else
  echo "No device"
fi
