#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system

cp -p /system/etc/phronesis/frameworks/stockframework/system/framework/framework-res.apk /system/framework/framework-res.apk

pkill zygote