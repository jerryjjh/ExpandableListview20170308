package com.bawei.jiajianhai.expandablelistview20170308.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by my on 2017/3/9.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }


}
