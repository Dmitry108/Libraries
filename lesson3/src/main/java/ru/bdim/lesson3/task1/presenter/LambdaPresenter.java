package ru.bdim.lesson3.task1.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

import ru.bdim.lesson3.task1.model.Model;

import static ru.bdim.lesson3.task1.model.Const.TAG;

public class LambdaPresenter {

    private Model model;
    private List<Disposable> disposables;

    public LambdaPresenter(){
        model = new Model();
        disposables = new ArrayList<>();
    }

    public void newSubscribe() {
        disposables.add(model.getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((msg) -> Log.d(TAG, String.format(Locale.ROOT,
                        "%s, поток: %s", msg.toString(), Thread.currentThread().getName())),
                    (e) -> Log.d(TAG, e + ", " + Thread.currentThread().getName()),
                    () -> Log.d(TAG, "Рассылка завершена, " + Thread.currentThread().getName())));
    }

    public void unsubscribeLast() {
        int n = disposables.size();
        if (n > 0){
            disposables.get(n-1).dispose();
            disposables.remove(n-1);
        }
    }
}