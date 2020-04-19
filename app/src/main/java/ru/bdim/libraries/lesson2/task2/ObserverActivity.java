package ru.bdim.libraries.lesson2.task2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import ru.bdim.libraries.R;


public class ObserverActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);

        final Spam spam = new Spam();

        Button btnSubscribe = findViewById(R.id.btn_subscribe);
        Button btnUnsubscribe = findViewById(R.id.btn_unsubscribe);
        Button btnSendSpam = findViewById(R.id.btn_spam);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_subscribe:
                        spam.subscribe(new Bob(spam.getCount() + 1));
                        break;
                    case R.id.btn_unsubscribe:
                        spam.unsubscribe(spam.getCount() - 1);
                        break;
                    case R.id.btn_spam:
                        spam.notifyObserves();
                        break;
                }
            }
        };
        btnSubscribe.setOnClickListener(listener);
        btnUnsubscribe.setOnClickListener(listener);
        btnSendSpam.setOnClickListener(listener);
    }
}
