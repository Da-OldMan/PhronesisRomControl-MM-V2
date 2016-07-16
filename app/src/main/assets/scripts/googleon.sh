#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system

mv /system/priv-app/GmsCore/GmsCore.apk.bak /system/priv-app/GmsCore/GmsCore.apk
mv /system/priv-app/GoogleBackupTransport/GoogleBackupTransport.apk.bak /system/priv-app/GoogleBackupTransport/GoogleBackupTransport.apk
mv /system/priv-app/GoogleFeedback/GoogleFeedback.apk.bak /system/priv-app/GoogleFeedback/GoogleFeedback.apk
mv /system/priv-app/GoogleLoginService/GoogleLoginService.apk.bak /system/priv-app/GoogleLoginService/GoogleLoginService.apk
mv /system/priv-app/GoogleOneTimeInitializer/GoogleOneTimeInitializer.apk.bak /system/priv-app/GoogleOneTimeInitializer/GoogleOneTimeInitializer.apk
mv /system/priv-app/GooglePartnerSetup/GooglePartnerSetup.apk.bak /system/priv-app/GooglePartnerSetup/GooglePartnerSetup.apk
mv /system/priv-app/GoogleServicesFramework/GoogleServicesFramework.apk.bak /system/priv-app/GoogleServicesFramework/GoogleServicesFramework.apk
mv /system/priv-app/Phonesky/Phonesky.apk.bak /system/priv-app/Phonesky/Phonesky.apk
mv /system/priv-app/Velvet/Velvet.apk.bak /system/priv-app/Velvet/Velvet.apk
mv /system/framework/com.google.android.maps.jar.bak /system/framework/com.google.android.maps.jar
mv /system/framework/com.google.android.media.effects.jar.bak /system/framework/com.google.android.media.effects.jar
mv /system/app/Gmail2/Gmail2.apk.bak /system/app/Gmail2/Gmail2.apk
mv /system/app/GoogleCalendarSyncAdapter/GoogleCalendarSyncAdapter.apk.bak /system/app/GoogleCalendarSyncAdapter/GoogleCalendarSyncAdapter.apk
mv /system/app/GoogleContactsSyncAdapter/GoogleContactsSyncAdapter.apk.bak /system/app/GoogleContactsSyncAdapter/GoogleContactsSyncAdapter.apk
mv /system/app/GoogleTTS/GoogleTTS.apk.bak /system/app/GoogleTTS/GoogleTTS.apk

sleep 2

reboot

