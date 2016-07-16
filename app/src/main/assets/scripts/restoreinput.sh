#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /data

cp -rf /sdcard/backups/keyboard/com.sec.android.inputmethod /data/data/

pkill zygote