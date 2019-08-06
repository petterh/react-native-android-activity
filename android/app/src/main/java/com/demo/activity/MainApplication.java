package com.demo.activity;

import android.app.Application;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

/**
 * Base class for maintaining global application state -- in this case, the {@link ReactNativeHost}.
 */
public final class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.USE_DEVELOPER_SUPPORT;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.asList(
                    new ActivityStarterReactPackage(),
                    new MainReactPackage()
            );
        }
    };

    /**
     * Get the {@link ReactNativeHost} for this app.
     */
    @Override
    @NonNull
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     *
     * <p>This implementation loads the React Native JNI libraries.</p>
     */
    @Override
    @CallSuper
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, false);
    }
}
