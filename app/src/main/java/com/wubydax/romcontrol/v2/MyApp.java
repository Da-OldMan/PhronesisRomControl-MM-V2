package com.wubydax.romcontrol.v2;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * Created by Anna Berkovitch on 11/06/2016.
 * Application object for context and gc uses
 */
public class MyApp extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    @Override
    public void onLowMemory() {
        Runtime.getRuntime().gc();
        super.onLowMemory();
    }
}
