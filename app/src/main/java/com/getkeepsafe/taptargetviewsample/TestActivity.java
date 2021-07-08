package com.getkeepsafe.taptargetviewsample;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

/**
 * @author Valdrin Maloku
 * @since 08/07/2021.
 */

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        findViewById(R.id.main_container).post(new Runnable() {
            @Override
            public void run() {
                TapTargetView.showFor(TestActivity.this,
                        TapTarget.forBounds(
                                getBounds(findViewById(R.id.text_view)),
                                "Title",
                                "Description")
                                .showRoundedRect(true)
                );
            }
        });
    }

    private Rect getBounds(View view) {
        final Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
