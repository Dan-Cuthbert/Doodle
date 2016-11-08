package com.example.mydoodle;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

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

    public void onButtonClick(View view) {
        /*Clear functionality*/
        Toast.makeText(getApplicationContext(), "Clear Button Clicked" + ((Button)view).getText(), Toast.LENGTH_SHORT);
        dv.reset();
    }

    public void smallBrush(View view){
        dv.setBrushSize(10);
    }
    public void mediumBrush(View view){
        dv.setBrushSize(20);
    }
    public void largeBrush(View view){
        dv.setBrushSize(30);
    }

    public void singleRandGradient(View view) {
        dv.setGradient(1);
    }
    public void totalRandGradient(View view) {
        dv.setGradient(2);
    }

    /*public void open(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setMessage("Are you sure, You wanted to make decision");
        alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this,"You clicked yes button",Toast.LENGTH_LONG).show();
            }
        });
        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialogBuilder.setTitle("AlertDialog");
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }*/


    /*<Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Alert dialog"
    android:id="@+id/button"
    android:onClick="open"
    android:layout_below="@+id/seekBarRed"
    android:layout_alignParentRight="true"
    android:layout_alignParentEnd="true" />*/
}
