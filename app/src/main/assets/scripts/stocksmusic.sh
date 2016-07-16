#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system

cp -p /system/etc/phronesis/music/stock/system/priv-app/SMusic/SMusic.apk /system/priv-app/SMusic/SMusic.apk

pkill zygote