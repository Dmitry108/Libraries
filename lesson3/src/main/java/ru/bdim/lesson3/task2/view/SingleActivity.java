package ru.bdim.lesson3.task2.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.bdim.lesson3.R;
import ru.bdim.lesson3.task2.presenter.SinglePresenter;

public class SingleActivity extends MvpAppCompatActivity implements SingleView {

    @InjectPresenter
    SinglePresenter presenter;

    @BindView(R.id.btn_t2_load)
    Button btn;
    @BindView(R.id.tvw_t2_result)
    TextView tvw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        ButterKnife.bind(this);
        btn.setOnClickListener(v -> presenter.getPicture());
    }
    @Override
    public void loadPicture(String str) {
        tvw.setText(str);
    }
}