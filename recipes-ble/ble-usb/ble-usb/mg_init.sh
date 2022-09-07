#!/bin/sh

sleep 2
btmgmt --index 0 static-addr FF:00:00:00:00:FF
btmgmt --index 0 auto-power
echo "BLE UP"
