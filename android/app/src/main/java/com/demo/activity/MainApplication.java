package com.demo.activity;

import android.app.Application;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

public final class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.asList(
                    new ActivityStarterReactPackage(),
                    new MainReactPackage()
            );
        }
    };

    @Override
    @NonNull
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    @CallSuper
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, false);
    }
}
