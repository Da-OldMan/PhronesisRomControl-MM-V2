#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /data

mkdir -p /sdcard/backups/contact

cp -rf /data/data/com.android.providers.contacts/databases /sdcard/backups/contact
