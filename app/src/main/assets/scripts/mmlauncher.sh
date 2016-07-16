#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system

cp -p /system/etc/phronesis/touchwiz/mm/system/priv-app/TouchWizHome_ZERO/TouchWizHome_ZERO.apk /system/priv-app/TouchWizHome_ZERO/TouchWizHome_ZERO.apk

pkill com.sec.android.app.launcher
