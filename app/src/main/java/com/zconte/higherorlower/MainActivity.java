package com.zconte.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int machineNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getMachineNumber();

    }

    public void guessProcess(View view) {
        EditText guessNumber = findViewById(R.id.guessInputId);

        int clientNumber = Integer.parseInt(guessNumber.getText().toString());

        if (clientNumber == machineNumber) {
            Toast.makeText(this, "Congratulations!! You guessed my number!", Toast.LENGTH_LONG).show();
            machineNumber = getMachineNumber();
            Toast.makeText(this, "I'm thinking in a new number, can you guess it?", Toast.LENGTH_LONG).show();
        } else if (clientNumber < machineNumber) {
            Toast.makeText(this, "Wrong! Try again! My number is higher.",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong! Try again! My number is lower.",
                    Toast.LENGTH_SHORT).show();
        }

    }

    private int getMachineNumber() {
        Random random = new Random();
        return random.nextInt(20) + 1;
    }
}