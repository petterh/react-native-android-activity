package com.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Toast;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeArray;

/**
 * Activity to start from React Native JavaScript, triggered via
 * {@link ActivityStarterModule#navigateToExample()}.
 */
public class ExampleActivity extends Activity {

    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        findViewById(R.id.go_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        findViewById(R.id.trigger_alert_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventEmitterModule.emitEvent("Hello from " + ExampleActivity.class.getSimpleName());
            }
        });

        findViewById(R.id.set_extra_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainApplication application = (MainApplication) ExampleActivity.this.getApplication();
                ReactNativeHost reactNativeHost = application.getReactNativeHost();
                ReactInstanceManager reactInstanceManager = reactNativeHost.getReactInstanceManager();
                ReactContext reactContext = reactInstanceManager.getCurrentReactContext();

                if (reactContext != null) {
                    CatalystInstance catalystInstance = reactContext.getCatalystInstance();
                    WritableNativeArray params = new WritableNativeArray();
                    params.pushString("Set Extra Message was called!");

                    // AFAIK, this approach to communicate from Java to JavaScript is officially undocumented.
                    // Use at own risk; prefer events.
                    // Note: Here we call 'setMessage', which does not show UI. That means it is okay
                    // to call it from an activity that doesn't forward lifecycle events to React Native.
                    catalystInstance.callFunction("JavaScriptVisibleToJava", "setMessage", params);
                    Toast.makeText(ExampleActivity.this, "Extra message was changed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
