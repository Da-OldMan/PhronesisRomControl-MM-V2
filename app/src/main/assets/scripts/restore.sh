#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /data

cp -rf /sdcard/backups/settings/accounts* /data/system/users/0
cp -rf /sdcard/backups/settings/*.xml /data/system/users/0
cp -rf /sdcard/backups/settings/registered_services /data/system/users/0

pkill zygote
