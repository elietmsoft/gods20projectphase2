package com.elietmsoft.gods20project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.jaeger.library.StatusBarUtil;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        customStatusBar();
    }

    @Override
    protected void onStart() {
        super.onStart();
        StatusBarUtil.setTransparent(LaunchActivity.this);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            public void run()
            {
                Intent launchIntent = new Intent(LaunchActivity.this,MainActivity.class);
                startActivity(launchIntent);
                LaunchActivity.this.finish();
            }
        }, 5000L);
    }

    void customStatusBar(){
        StatusBarUtil.setTransparent(LaunchActivity.this);
    }
}