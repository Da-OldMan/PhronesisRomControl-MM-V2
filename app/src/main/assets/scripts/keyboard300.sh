#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system
mount -o rw,remount /data

rm -fR /system/lib/libMyScript2D.so
rm -fR /system/lib/libMyScriptEngine.so
rm -fR /system/lib/libMyScriptPrediction.so
rm -fR /system/lib/libMyScriptText.so
rm -fR /system/lib/libStylusCore.so
rm -fR /system/lib/libswiftkeysdk-java.so
rm -fR /system/lib/libXt9core.so
rm -rf /data/data/com.sec.android.inputmethod
rm -rf /system/app/SamsungIMEv2_5
rm -rf /system/app/SamsungIMEv3


cp -a /system/etc/phronesis/keyboard/300/system/lib/* /system/lib/
cp -r /system/etc/phronesis/keyboard/300/system/app/* /system/app/


chmod 755 /system/app/SamsungIMEv3
chmod 644 /system/lib/libMyScript2D.so
chmod 644 /system/lib/libMyScriptEngine.so
chmod 644 /system/lib/libMyScriptPrediction.so
chmod 644 /system/lib/libMyScriptText.so
chmod 644 /system/lib/libStylusCore.so
chmod 644 /system/lib/libswiftkeysdk-java.so
chmod 644 /system/lib/libXt9core.so
chmod 644 /system/app/SamsungIMEv3/SamsungIMEv3.apk


sleep 1

pkill zygote

