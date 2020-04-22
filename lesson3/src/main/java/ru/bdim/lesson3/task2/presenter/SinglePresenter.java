package ru.bdim.lesson3.task2.presenter;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.bdim.lesson3.task2.model.Model;
import ru.bdim.lesson3.task2.view.SingleView;

@InjectViewState
public class SinglePresenter extends MvpPresenter<SingleView> {

    private Model model;
    private static final String TAG = "...";

    public SinglePresenter(){
        model = new Model();
    }

    public void getPicture(){
        Disposable disposable = model.getData().observeOn(AndroidSchedulers.mainThread())
                .subscribe((str) -> {
                    Log.d(TAG, str + " " + Thread.currentThread().getName());
                    getViewState().loadPicture(str);
                });
    }
}
