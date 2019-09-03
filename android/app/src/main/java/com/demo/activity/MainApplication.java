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

    private static final String JS_BUNDLE_NAME = "index.bundle";
    private static final String JS_MAIN_MODULE_NAME = "index";

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.USE_DEVELOPER_SUPPORT;
        }

        /**
         * Returns the name of the main module. Determines the URL used to fetch the JS bundle
         * from the packager server. It is only used when dev support is enabled.
         */
        @NonNull
        @Override
        protected String getJSMainModuleName() {
            return JS_MAIN_MODULE_NAME;
        }

        /**
         * Returns the name of the bundle in assets.
         */
        @NonNull
        @Override
        protected String getBundleAssetName() {
            return JS_BUNDLE_NAME;
        }

        /**
         * <p>
         *     Returns a list of {@link ReactPackage}s used by the app.
         * </p>
         * <p>
         *     This method is called by the React Native framework.
         *     It is not normally called by the application itself.
         * </p>
         */
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
