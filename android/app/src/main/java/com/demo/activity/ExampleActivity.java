package com.demo.activity;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.View;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeArray;

/**
 * Activity to start from React Native JavaScript, triggered via
 * {@link ActivityStarterModule#navigateToExample()}.
 *
 * This activity inherits ReactActivity in order to forward life cycle events to React Native.
 * This is not a requirement -- you can start any activity from React Native. See comments in
 * the trigger alert click listener for an explanation.
 */
public class ExampleActivity extends ReactActivity {

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
                ActivityStarterModule.emitEvent("Hello from " + ExampleActivity.class.getSimpleName());
            }
        });

        findViewById(R.id.call_javascript_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainApplication application = (MainApplication) ExampleActivity.this.getApplication();
                ReactNativeHost reactNativeHost = application.getReactNativeHost();
                ReactInstanceManager reactInstanceManager = reactNativeHost.getReactInstanceManager();
                ReactContext reactContext = reactInstanceManager.getCurrentReactContext();

                if (reactContext != null) {
                    CatalystInstance catalystInstance = reactContext.getCatalystInstance();
                    WritableNativeArray params = new WritableNativeArray();
                    params.pushString("New extra message!");

                    // AFAIK, this approach is officially undocumented. Use at own risk; prefer events.
                    // The JS function invoked calls 'alert'. If this activity didn't forward life cycle events
                    // to React Native (which it does, due to inheriting ReactActivity), the alert dialog
                    // would silently fail to show.
                    catalystInstance.callFunction("JavaScriptVisibleToJava", "setMessage", params);
                }
            }
        });
    }
}
