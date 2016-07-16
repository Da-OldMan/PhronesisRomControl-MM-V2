#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system

wm density 420 

sleep 3

pkill zygote