#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /data

mkdir -p /sdcard/backups/telephony

cp -rf /data/data/com.android.providers.telephony/databases /sdcard/backups/telephony
