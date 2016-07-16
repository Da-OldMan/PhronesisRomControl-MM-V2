#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system

wm density 450 

sleep 3

pkill zygote