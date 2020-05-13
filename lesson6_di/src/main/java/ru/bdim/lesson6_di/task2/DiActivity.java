package ru.bdim.lesson6_di.task2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.bdim.lesson6_di.R;

public class DiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        Green green = new Green();
        Red red = new Red(green);
        White white = new White(green);
    }
}
