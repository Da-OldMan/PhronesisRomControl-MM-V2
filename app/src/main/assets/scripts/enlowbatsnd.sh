#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system

cp -p /system/etc/phronesis/LowBattery.ogg /system/media/audio/ui/LowBattery.ogg

