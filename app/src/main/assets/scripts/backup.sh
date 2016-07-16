#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /data

mkdir -p /sdcard/backups/settings

cp -rf /data/system/users/0/accounts* /sdcard/backups/settings
cp -rf /data/system/users/0/*.xml /sdcard/backups/settings
cp -rf /data/system/users/0/registered_services /sdcard/backups/settings

