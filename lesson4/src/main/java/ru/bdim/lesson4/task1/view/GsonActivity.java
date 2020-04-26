package ru.bdim.lesson4.task1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

import ru.bdim.lesson4.R;
import ru.bdim.lesson4.task1.presenter.GsonPresenter;

public class GsonActivity extends AppCompatActivity {

    private GsonPresenter presenter = new GsonPresenter();

    @BindView(R.id.btn_gson)
    Button btnGson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        ButterKnife.bind(this);
        btnGson.setOnClickListener(v -> presenter.getAndParseJson());
    }
}
