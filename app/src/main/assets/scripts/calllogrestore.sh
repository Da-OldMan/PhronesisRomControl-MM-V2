#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /data

cp -rf /sdcard/backups/calllog/databases /data/data/com.android.providers.contacts/