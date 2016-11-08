package com.example.mydoodle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private DoodleView dv;
    private SeekBar seekBar;
    private int red;
    private int blue;
    private int green;
    private int opacity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dv = (DoodleView)findViewById(R.id.doodle_view);

        red = 0;
        blue = 0;
        green = 0;
        opacity = 255;

        seekBar = (SeekBar) findViewById(R.id.seekBarRed);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                red = progressValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                dv.setColor(red, 1);
            }
        });

        seekBar = (SeekBar) findViewById(R.id.seekBarGreen);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                green = progressValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                dv.setColor(green, 2);
            }
        });

        seekBar = (SeekBar) findViewById(R.id.seekBarBlue);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                blue = progressValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                dv.setColor(blue, 3);
            }
        });

        seekBar = (SeekBar) findViewById(R.id.seekBarOpac);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                opacity = progressValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                dv.setOpacity(opacity);
            }
        });
    }

    /*Clear functionality*/
    public void onButtonClick(View view) {
        dv.reset();
    }

    /*Setting Brush Sizes*/
    public void smallBrush(View view){
        dv.setBrushSize(10);
    }
    public void mediumBrush(View view){
        dv.setBrushSize(20);
    }
    public void largeBrush(View view){
        dv.setBrushSize(30);
    }

    /*Setting Gradient*/
    public void singleRandGradient(View view) {
        dv.setGradient(1);
    }
    public void totalRandGradient(View view) {
        dv.setGradient(2);
    }

}
