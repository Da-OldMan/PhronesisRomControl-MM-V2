#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system

cp -p -a -R  /system/etc/phronesis/liboemcrypto.so /system/vendor/lib/
chmod 644 /system/vendor/lib/liboemcrypto.so

sleep 3

reboot