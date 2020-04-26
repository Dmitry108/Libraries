package ru.bdim.lesson4.task2.presenter;

import android.util.Log;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.bdim.lesson4.task2.model.HubRequest;
import ru.bdim.lesson4.task2.model.Model;
import ru.bdim.lesson4.task2.view.RetrofitView;

@InjectViewState
public class RetrofitPresenter extends MvpPresenter<RetrofitView> {

    private Model model;
    private static final String TAG = ".1..";

    public RetrofitPresenter(){
        model = new Model();
    }
    public void loadPhoto() {
        Disposable d = model.getAvatarUrl()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((hubRequest) -> getViewState().setPhoto(hubRequest.getAvatarUri()),
                           (e) -> Log.d(TAG, e.toString()));
    }
}
