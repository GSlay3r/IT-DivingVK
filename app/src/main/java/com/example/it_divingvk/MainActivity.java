package com.example.it_divingvk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.it_divingvk.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int firstCounter = 0;
    private int secondCounter = 0;


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void helloDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.greeting);
        builder.setMessage(R.string.hello);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstCounter++;
                if(firstCounter % 2 == 1){
                    binding.firstButton.setBackgroundResource(R.drawable.oval_button_white);
                    binding.firstButton.setImageResource(R.drawable.videocam_off);
                }
                else{
                    binding.firstButton.setImageResource(R.drawable.videocam);
                    binding.firstButton.setBackgroundResource(R.drawable.oval_button);
                }
            }
        });

        binding.secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondCounter++;
                if(secondCounter % 2 == 1){
                    binding.secondButton.setBackgroundResource(R.drawable.oval_button_white);
                    binding.secondButton.setImageResource(R.drawable.mic_off);
                }
                else{
                    binding.secondButton.setImageResource(R.drawable.mic);
                    binding.secondButton.setBackgroundResource(R.drawable.oval_button);
                }

            }
        });

        binding.thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helloDialog();
            }
        });


        binding.fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.messaging");

                if(intent != null){
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, R.string.empty_app, Toast.LENGTH_LONG).show();
                }
            }
        });

        binding.permutationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}