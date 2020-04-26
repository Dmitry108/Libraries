package ru.bdim.lesson4.task2.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.bdim.lesson4.R;
import ru.bdim.lesson4.task2.model.PhotoLoader;
import ru.bdim.lesson4.task2.presenter.RetrofitPresenter;

public class RetrofitActivity extends MvpAppCompatActivity implements RetrofitView {

    @InjectPresenter
    RetrofitPresenter presenter;

    @BindView(R.id.btn_load_photo)
    Button btnLoad;
    @BindView(R.id.img_photo)
    ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        ButterKnife.bind(this);
        btnLoad.setOnClickListener(v -> presenter.loadPhoto());
    }

    @Override
    public void setPhoto(String url){
        PhotoLoader.setPhoto(this, url, imgPhoto);
    }
}
