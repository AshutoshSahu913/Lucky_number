package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;

import android.view.MenuItem;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

public class LuckyNumber extends AppCompatActivity {

    ImageView wheel,refresh;
    Animation rotateAnim,refreshAnim;
    Button shareBtn;
    TextView luckyTxt, greetingTxt;
    public static String userName;
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        wheel = findViewById(R.id.wheel);
        luckyTxt=findViewById(R.id.luckyTxt);
        refresh=findViewById(R.id.refresh);
        shareBtn=findViewById(R.id.shareBtn);
        greetingTxt = findViewById(R.id.greetingTxt);
        refreshAnim=AnimationUtils.loadAnimation(this,R.anim.refresh);
        rotateAnim= AnimationUtils.loadAnimation(this,R.anim.rotate);
        wheel.setAnimation(rotateAnim);

        //UserName
        Intent i = getIntent();
        userName = i.getStringExtra("enterName");

        //Greeting text
        greetingTxt.setText("Hello ! "+userName);
        //Random Number Generated
        int random_number = generateRandomNumber();
        luckyTxt.setText("Your Lucky Number is :\n"+random_number);

        shareBtn.setOnClickListener(v -> shareData(userName,
                random_number));

        refresh.setOnClickListener(v -> {
            refresh.setAnimation(refreshAnim);
            Intent intent1 = new Intent(LuckyNumber.this, Input_page.class);
            startActivity(intent1);
            overridePendingTransition(R.anim.left_side_in,R.anim.right_side_out);
        });


    }

    public void shareData(String userName, int random_number)
    {
        //Implicit Intents
        Intent intent1=new Intent(Intent.ACTION_SEND);
        intent1.setType("text/plain");

        //convert the int to string
        String number=String.valueOf(random_number);

        intent1.putExtra(Intent.EXTRA_SUBJECT,userName+" got lucky today!");
        intent1.putExtra(Intent.EXTRA_TEXT,"His lucky number is : "+ number);


        startActivity(Intent.createChooser(intent1,"Choose a platform"));


    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Input_page.class);
        startActivityForResult(myIntent, 0);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        return true;
    }
    public  int generateRandomNumber(){
        Random random=new Random();
        int upperLimit=1000;
//        int randomNumberGenerated=random.nextInt(upperLimit);
//        return  randomNumberGenerated;
        return random.nextInt(upperLimit);
    }
}