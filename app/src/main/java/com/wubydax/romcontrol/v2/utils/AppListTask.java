package com.wubydax.romcontrol.v2.utils;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.AsyncTask;

import com.wubydax.romcontrol.v2.MyApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class AppListTask extends AsyncTask<Void, Void, List<AppInfo>> {
    private  OnListCreatedListener mOnListCreatedListener;
    @Override
    protected List<AppInfo> doInBackground(Void... voids) {
        PackageManager packageManager = MyApp.getContext().getPackageManager();
        ArrayList<AppInfo> appList = new ArrayList<>();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolveInfoList = packageManager.queryIntentActivities(intent, 0);

        for (ResolveInfo resolveInfo : resolveInfoList) {
            AppInfo appInfo = new AppInfo();
            appInfo.mAppName = resolveInfo.activityInfo.loadLabel(packageManager).toString();
            appInfo.mIcon = resolveInfo.activityInfo.loadIcon(packageManager);
            appInfo.mPackageName = resolveInfo.activityInfo.packageName;
            Intent explicitIntent = new Intent();
            explicitIntent.setComponent(new ComponentName(appInfo.mPackageName, resolveInfo.activityInfo.name));
            appInfo.mIntent = explicitIntent;
            appList.add(appInfo);
        }
        Collections.sort(appList, new Comparator<AppInfo>() {

            @Override
            public int compare(AppInfo lhs, AppInfo rhs) {
                return String.CASE_INSENSITIVE_ORDER.compare(lhs.mAppName, rhs.mAppName);
            }

        });
        return appList;

    }

    @Override
    protected void onPostExecute(List<AppInfo> appInfo) {
        if(mOnListCreatedListener != null) {
            mOnListCreatedListener.onListCreated(appInfo);
        }
    }

    public void setOnListCreatedListener(OnListCreatedListener onListCreatedListener) {
        mOnListCreatedListener = onListCreatedListener;
    }

    public interface OnListCreatedListener {
        void onListCreated(List<AppInfo> appInfoList);
    }
}
