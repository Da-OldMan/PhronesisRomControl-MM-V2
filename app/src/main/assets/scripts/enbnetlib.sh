#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system

rm -rf  /system/vendor/lib/liboemcrypto.so

sleep 3

reboot

