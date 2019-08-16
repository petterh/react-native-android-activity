package com.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Handles custom edit menu "Reverse string" item.
 * https://medium.com/androiddevelopers/custom-text-selection-actions-with-action-process-text-191f792d2999
 *
 * This functionality has nothing to do with React Native per se; I added this just to verify that
 * the mechanism works as expected on a React Native {@code TextInput}.
 *
 * I'm not aware of any comparable iOS functionality -- this thing works globally. iOS has something
 * you can apply to individual{@code UITextView}s:
 * https://stackoverflow.com/questions/37870889/how-do-i-add-a-custom-action-to-the-text-selection-edit-menu-in-ios
 */
public class ReverseTextActivity extends Activity {

    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse_text);
        CharSequence text = getIntent().getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);
        this.<TextView>findViewById(R.id.reverse_text).setText(reverse(text));
    }

    @NonNull
    private CharSequence reverse(@NonNull CharSequence text) {
        StringBuilder sb = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; --i) {
            sb.append(text.charAt(i));
        }

        return sb.toString();
    }
}
