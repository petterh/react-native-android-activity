package com.demo.activity;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;

/**
 * The main activity, which hosts the React Native view registered in {@code index.android.js}.
 */
public final class MainActivity extends ReactActivity {

    private static final String CUSTOM_DEV_OPTION_MESSAGE = "Hello from custom dev option!";

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    @Nullable
    protected String getMainComponentName() {
        return "ActivityDemoComponent";
    }

    /**
     * Demonstrates how to add a custom option to the dev menu.
     * https://stackoverflow.com/a/44882371/3968276
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
