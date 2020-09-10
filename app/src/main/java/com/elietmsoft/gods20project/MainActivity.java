package com.elietmsoft.gods20project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.StatusBarManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.elietmsoft.gods20project.adapters.ViewPagerAdapter;
import com.elietmsoft.gods20project.fragments.LearningFragment;
import com.elietmsoft.gods20project.fragments.SkillFragment;
import com.google.android.material.tabs.TabLayout;
import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customStatusBar();
        init();
        setupViewAdapter();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSubmit();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        StatusBarUtil.setTransparent(MainActivity.this);
    }

    void init(){
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        submit = (Button)findViewById(R.id.tool_submit);
    }
    void goToSubmit(){
        Intent submitIntent = new Intent(MainActivity.this,SubmissionActivity.class);
        startActivity(submitIntent);
    }
    void setupViewAdapter(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.add(new LearningFragment(),"Learning Learders");
        adapter.add(new SkillFragment(),"Skill IQ Learders");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    void customStatusBar(){
        StatusBarUtil.setTransparent(MainActivity.this);
    }
}