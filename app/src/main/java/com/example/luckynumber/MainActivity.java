package com.example.luckynumber;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Animation rotateAnimation,alphaAnim,scaleAnim,translateAnim,alphaSplash;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.iconImg);
        textView = findViewById(R.id.appName);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        scaleAnim=AnimationUtils.loadAnimation(this,R.anim.scale);
        alphaAnim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        alphaSplash=AnimationUtils.loadAnimation(this,R.anim.alpha_splash);
        translateAnim = AnimationUtils.loadAnimation(this, R.anim.translate);
        imageView.startAnimation(rotateAnimation);
        textView.startAnimation(alphaSplash);


        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(MainActivity.this, Start_page.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_side_in,R.anim.right_side_out);
                }
            }
        };
        thread.start();
    }
}