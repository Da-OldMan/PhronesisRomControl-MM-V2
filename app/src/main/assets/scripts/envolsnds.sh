#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system

cp -p /system/etc/phronesis/TW_Volume_control.ogg /system/media/audio/ui/TW_Volume_control.ogg

pkill -TERM -f com.android.systemui
