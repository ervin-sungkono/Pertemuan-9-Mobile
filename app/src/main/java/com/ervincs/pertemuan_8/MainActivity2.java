package com.ervincs.pertemuan_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity {
    TextView text1, countText;
    Button onClickButton, touchButton, snackbarButton, addButton, substractButton;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text1 = findViewById(R.id.tv_text);
        onClickButton = findViewById(R.id.onclick_btn);
        touchButton = findViewById(R.id.touch_btn);
        snackbarButton = findViewById(R.id.snackbar);
        countText = findViewById(R.id.tv_counttext);
        addButton = findViewById(R.id.add_btn);
        substractButton = findViewById(R.id.substract_btn);

        onClickButton.setOnClickListener(v -> {
            text1.setText("Clicked!");
        });

        onClickButton.setOnLongClickListener(v -> {
            text1.setTextColor(getColor(R.color.purple_500));
            return false;
        });

        touchButton.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(MainActivity2.this, "Button is touched.", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        snackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.coordinator_layout), "Snackbar test", Snackbar.LENGTH_SHORT).show();
            }
        });

        addButton.setOnClickListener(v -> {
            count++;
            update();
        });

        substractButton.setOnClickListener(v -> {
            count--;
            update();
        });
    }
    public void update(){
        countText.setText("Count: " + Integer.toString(count));
    }
}