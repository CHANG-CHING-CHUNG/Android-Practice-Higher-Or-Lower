package com.john.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int ramdom;

    public void generateRamdomNumber() {
        Random rand = new Random();
        int upperbound = 21;
        ramdom = rand.nextInt(upperbound);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRamdomNumber();

    }

    public void handleGuess(View view) {
        EditText edTxtInput = (EditText) findViewById(R.id.edTxtInput);
        int inputNumber = Integer.parseInt(edTxtInput.getText().toString());
        String message;
        if (inputNumber == ramdom) {
            message = "猜對了! 你真棒! 再猜一次吧!";
            generateRamdomNumber();
        } else if (inputNumber > ramdom) {
            message = "數字太大囉~!";
        } else {
            message = "數字太小囉~!";

        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}