package com.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Handles custom edit menu "Reverse string" item.
 * https://medium.com/androiddevelopers/custom-text-selection-actions-with-action-process-text-191f792d2999
 */
public class ReverseTextActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse_text);
        CharSequence text = getIntent().getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);
        this.<TextView>findViewById(R.id.reverse_text).setText(reverse(text));
    }

    private CharSequence reverse(CharSequence text) {
        StringBuilder sb = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; --i) {
            sb.append(text.charAt(i));
        }

        return sb.toString();
    }
}
