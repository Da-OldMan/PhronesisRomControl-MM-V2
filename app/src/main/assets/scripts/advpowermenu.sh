#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system

cp -p /system/etc/phronesis/frameworks/advpowermenu/system/framework/services.jar /system/framework/services.jar

pkill zygote