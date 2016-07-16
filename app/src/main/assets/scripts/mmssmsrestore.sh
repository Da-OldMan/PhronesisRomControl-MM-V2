#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /data

cp -rf /sdcard/backups/telephony/databases /data/data/com.android.providers.telephony/
