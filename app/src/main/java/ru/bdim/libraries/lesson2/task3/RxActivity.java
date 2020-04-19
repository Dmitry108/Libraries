package ru.bdim.libraries.lesson2.task3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.bdim.libraries.R;

public class RxActivity extends AppCompatActivity {
    private static final String TAG = "...";
    private Observable<String> observable;
    private Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);

        Button btnSubscribe = findViewById(R.id.btn_rx_subscribe);
        Button btnUnsubscribe = findViewById(R.id.btn_rx_unsubscribe);

        btnSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        Log.d(TAG, "подписка: ");
                        RxActivity.this.disposable = disposable;
                    }
                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "новое событие, поток - " + Thread.currentThread().getName() + ": " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "ошибка: " + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "события завешены!");
                    }
                });
                Log.d(TAG, "подписка закончена! поток - " + Thread.currentThread().getName());
            }
        });

        btnUnsubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disposable.dispose();
            }
        });

        observable = getSpam();

    }

    public Observable<String> getSpam() {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    for (int i = 0; i < 10; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        String spam = "spam №" + i;
                        Log.d(TAG, "поток - " + Thread.currentThread().getName() + ": " + spam);
                        emitter.onNext(spam);
                    }
                    emitter.onComplete();

                } catch (InterruptedException e) {
                    Log.d(TAG, "спам не приходит");
                }
            }
        }).subscribeOn(Schedulers.io());
            return observable;
        }
}
