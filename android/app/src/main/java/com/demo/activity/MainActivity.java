package com.demo.activity;

import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationManagerCompat;
import android.widget.Toast;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;

/**
 * The main activity, which hosts the React Native view registered in {@code index.js}.
 */
public final class MainActivity extends ReactActivity {

    private static final String CUSTOM_DEV_OPTION_MESSAGE = "Hello from custom dev option!";

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     * Because this class overrides {@link #createReactActivityDelegate()}, we don't really need
     * to override this.
     */
    @Override
    protected String getMainComponentName() {
        return "ActivityDemoComponent";
    }

    /**
     * We override to provide launch options that we can read in JavaScript (see buildType).
     */
    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegate(this, getMainComponentName()) {
            @Override
            protected Bundle getLaunchOptions() {
                Bundle launchOptions = new Bundle();
                launchOptions.putString("buildType", BuildConfig.BUILD_TYPE);
                return launchOptions;
            }
        };
    }

    /**
     * Demonstrates how to add a custom option to the dev menu.
     * https://stackoverflow.com/a/44882371/3968276
     * This only works from the debug build with dev options enabled.
     */
    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApplication application = (MainApplication) getApplication();
        ReactNativeHost reactNativeHost = application.getReactNativeHost();
        ReactInstanceManager reactInstanceManager = reactNativeHost.getReactInstanceManager();
        DevSupportManager devSupportManager = reactInstanceManager.getDevSupportManager();
        devSupportManager.addCustomDevOption("Custom dev option", new DevOptionHandler() {
            @Override
            public void onOptionSelected() {
                if (NotificationManagerCompat.from(MainActivity.this).areNotificationsEnabled()) {
                    Toast.makeText(MainActivity.this, CUSTOM_DEV_OPTION_MESSAGE, Toast.LENGTH_LONG).show();
                } else {
                    AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
                    dialog.setTitle("Dev option");
                    dialog.setMessage(CUSTOM_DEV_OPTION_MESSAGE);
                    dialog.show();
                }
            }
        });
    }
}
