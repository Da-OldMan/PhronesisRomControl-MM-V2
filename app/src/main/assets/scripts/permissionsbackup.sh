#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /data

mkdir -p /sdcard/backups/permissions

cp -rf /data/system/users/0/runtime-permissions.xml /sdcard/backups/permissions
