#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /data

mkdir -p /sdcard/backups/keyboard

cp -rf data/data/com.sec.android.inputmethod /sdcard/backups/keyboard

rm -rf /sdcard/backups/keyboard/com.sec.android.inputmethod/app_SwiftKey/*_*