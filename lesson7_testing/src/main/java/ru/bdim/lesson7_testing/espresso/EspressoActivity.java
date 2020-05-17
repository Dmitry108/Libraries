package ru.bdim.lesson7_testing.espresso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.bdim.lesson7_testing.R;

public class EspressoActivity extends AppCompatActivity {

    @BindView(R.id.text)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.bbb)
    public void onClick(){
        textView.setText("TextView");
    }
}
