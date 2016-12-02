package com.example.project_jay;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class AniActivity extends AppCompatActivity {
    FrameLayout mFrame;
    ImageView mJay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        mFrame = (FrameLayout)findViewById(R.id.activity_ani);
        mJay = (ImageView) findViewById(R.id.jay);
    }

    protected void onResume() {
        super.onResume();

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        startJayTweenAnimation();
    }
    private void startJayTweenAnimation() {
        Animation jay_anim = AnimationUtils.loadAnimation(this, R.anim.jay);
        mJay.startAnimation(jay_anim);
        jay_anim.setAnimationListener(animationListener);
    }

    Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    };
}
