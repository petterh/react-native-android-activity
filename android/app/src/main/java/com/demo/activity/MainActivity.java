package com.demo.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;

/**
 * The main activity, which hosts the React Native view registered in {@code index.android.js}.
 */
public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "ActivityDemoComponent";
    }

    /**
     * Demonstrates how to add a custom option to the dev menu.
     * https://stackoverflow.com/a/44882371/3968276
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApplication application = (MainApplication) getApplication();
        ReactNativeHost reactNativeHost = application.getReactNativeHost();
        ReactInstanceManager reactInstanceManager = reactNativeHost.getReactInstanceManager();
        DevSupportManager devSupportManager = reactInstanceManager.getDevSupportManager();
        devSupportManager.addCustomDevOption("Custom dev option", new DevOptionHandler() {
            @Override
            public void onOptionSelected() {
                Toast.makeText(MainActivity.this, "Hello from custom dev option", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
