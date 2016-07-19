#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system

cp -p /system/etc/phronesis/keymap/Generic.kl-recent /system/usr/keylayout/Generic.kl