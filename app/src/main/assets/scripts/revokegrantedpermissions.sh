#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /data

rm -rf /data/system/users/0/runtime-permissions.xml