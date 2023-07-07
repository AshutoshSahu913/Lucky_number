package com.example.luckynumber;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Start_page extends AppCompatActivity {
    Animation rotateAnimation, alphaAnim, scaleAnim, translateAnim, img1Anim, img2Anim, img3Anim;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    ImageView img9;
    ImageView img10;
    ImageView img11;
    ImageView img12;
    Button startBtn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        Objects.requireNonNull(getSupportActionBar()).hide();
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        scaleAnim = AnimationUtils.loadAnimation(this, R.anim.scale);
        alphaAnim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        translateAnim = AnimationUtils.loadAnimation(this, R.anim.translate);
        img1Anim = AnimationUtils.loadAnimation(this, R.anim.img1_anim);
        img2Anim = AnimationUtils.loadAnimation(this, R.anim.img2_anim);
        img3Anim = AnimationUtils.loadAnimation(this, R.anim.img3_anim);
        startBtn = findViewById(R.id.startBtn);
        img1 = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView2);
        img3 = findViewById(R.id.imageView3);
        img4 = findViewById(R.id.imageView4);
        img5 = findViewById(R.id.imageView5);
        img6 = findViewById(R.id.imageView6);
        img7 = findViewById(R.id.imageView7);
        img8 = findViewById(R.id.imageView8);
        img9 = findViewById(R.id.imageView9);
        img10 = findViewById(R.id.imageView10);
        img11 = findViewById(R.id.imageView11);
        img12 = findViewById(R.id.imageView12);

        img1.setAnimation(img1Anim);
        img2.setAnimation(img2Anim);
        img3.setAnimation(img3Anim);
        img4.setAnimation(img1Anim);
        img5.setAnimation(img2Anim);
        img6.setAnimation(img3Anim);

        img7.setAnimation(alphaAnim);
        img8.setAnimation(alphaAnim);
        img9.setAnimation(alphaAnim);
        img10.setAnimation(alphaAnim);
        img11.setAnimation(alphaAnim);
        img12.setAnimation(alphaAnim);

        startBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Start_page.this, Input_page.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
            overridePendingTransition(R.anim.left_side_in,R.anim.right_side_out);
        });
    }
}