package ru.bdim.lesson3.task1.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindAnim;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import ru.bdim.lesson3.R;
import ru.bdim.lesson3.task1.presenter.LambdaPresenter;

public class LambdaActivity extends AppCompatActivity {

    private LambdaPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lambda);

        presenter = new LambdaPresenter();
        ButterKnife.bind(this);
        }

    @OnClick({R.id.btn_t1_subscribe, R.id.btn_t1_unsubscribe})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_t1_subscribe:
                presenter.newSubscribe();
                break;
            case R.id.btn_t1_unsubscribe:
                presenter.unsubscribeLast();
                break;
        }
    }
}