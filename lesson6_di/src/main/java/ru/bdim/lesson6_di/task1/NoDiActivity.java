package ru.bdim.lesson6_di.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.bdim.lesson6_di.R;

public class NoDiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        Green green = new Green();
        Red red = new Red();
        White white = new White();
    }
}
