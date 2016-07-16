#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system

mv /system/priv-app/GmsCore/GmsCore.apk /system/priv-app/GmsCore/GmsCore.apk.bak
mv /system/priv-app/GoogleBackupTransport/GoogleBackupTransport.apk /system/priv-app/GoogleBackupTransport/GoogleBackupTransport.apk.bak
mv /system/priv-app/GoogleFeedback/GoogleFeedback.apk /system/priv-app/GoogleFeedback/GoogleFeedback.apk.bak
mv /system/priv-app/GoogleLoginService/GoogleLoginService.apk /system/priv-app/GoogleLoginService/GoogleLoginService.apk.bak
mv /system/priv-app/GoogleOneTimeInitializer/GoogleOneTimeInitializer.apk /system/priv-app/GoogleOneTimeInitializer/GoogleOneTimeInitializer.apk.bak
mv /system/priv-app/GooglePartnerSetup/GooglePartnerSetup.apk /system/priv-app/GooglePartnerSetup/GooglePartnerSetup.apk.bak
mv /system/priv-app/GoogleServicesFramework/GoogleServicesFramework.apk /system/priv-app/GoogleServicesFramework/GoogleServicesFramework.apk.bak
mv /system/priv-app/Phonesky/Phonesky.apk /system/priv-app/Phonesky/Phonesky.apk.bak
mv /system/priv-app/Velvet/Velvet.apk /system/priv-app/Velvet/Velvet.apk.bak
mv /system/framework/com.google.android.maps.jar /system/framework/com.google.android.maps.jar.bak
mv /system/framework/com.google.android.media.effects.jar /system/framework/com.google.android.media.effects.jar.bak
mv /system/app/Gmail2/Gmail2.apk /system/app/Gmail2/Gmail2.apk.bak
mv /system/app/GoogleCalendarSyncAdapter/GoogleCalendarSyncAdapter.apk /system/app/GoogleCalendarSyncAdapter/GoogleCalendarSyncAdapter.apk.bak
mv /system/app/GoogleContactsSyncAdapter/GoogleContactsSyncAdapter.apk /system/app/GoogleContactsSyncAdapter/GoogleContactsSyncAdapter.apk.bak
mv /system/app/GoogleTTS/GoogleTTS.apk /system/app/GoogleTTS/GoogleTTS.apk.bak

sleep 2

reboot

