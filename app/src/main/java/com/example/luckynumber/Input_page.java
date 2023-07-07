package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Input_page extends AppCompatActivity {

    ImageView helloW;
    EditText enterName;
    Button okBtn;
    Animation alphaAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_page);
        Objects.requireNonNull(getSupportActionBar()).hide();
        enterName = findViewById(R.id.enterName);
        okBtn = findViewById(R.id.okBtn);
        helloW = findViewById(R.id.helloWorld);

        alphaAnim = AnimationUtils.loadAnimation(this, R.anim.alpha_splash);
        helloW.setAnimation(alphaAnim);

        okBtn.setOnClickListener(v -> {

            String user_Name = enterName.getText().toString();
            //Explicit Intent
            Intent intent = new Intent(Input_page.this, LuckyNumber.class);
            //Passing UserName to next Activity
            intent.putExtra("enterName", user_Name);

            if (enterName.getText().toString().trim().equalsIgnoreCase("")) {
                enterName.setError("This field can not be blank");
            } else {
//                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                overridePendingTransition(R.anim.left_side_in, R.anim.right_side_out);
            }
        });
    }

}