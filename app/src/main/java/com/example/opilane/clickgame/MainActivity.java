package com.example.opilane.clickgame;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView time1, click1;
    Button Click, start;
// Timer that will start counting from 30 secs
    CountDownTimer timer;
    int time = 30;
// By default you will start whit 0 clicks
    int clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Will find the location
        time1 = (TextView) findViewById(R.id.time1);
        click1 = (TextView) findViewById(R.id.click1);
        Click = (Button) findViewById(R.id.Click);
        start = (Button) findViewById(R.id.start);

// When game starts, Click button is disabled and start button is enabled.
        start.setEnabled(true);
        Click.setEnabled(false);
// Timer that will start from 30,000 (30 secs) until 1,000 (1 sec)
        timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time--;
                time1.setText("Time: " + time + " seconds left");


            }
// When user has pressed the button then it will start the game
            @Override
            public void onFinish() {
                start.setEnabled(true);
                Click.setEnabled(false);

            }
        };
// Takes how many clicks you will do whit 30 secs.
        Click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicks++;
                click1.setText("Clicks: " + clicks);

            }
        });
// Starts the countdown
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
                // Start button is now disabled
                start.setEnabled(false);
                // Click button is now enabled
                Click.setEnabled(true);
                clicks = 0;
                time = 30;
                time1.setText("Time: " + time);
                Click.setText("Clicks: " +  clicks);

            }
        });
    }
}
