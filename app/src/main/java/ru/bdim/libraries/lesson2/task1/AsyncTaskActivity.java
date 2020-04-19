package ru.bdim.libraries.lesson2.task1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.bdim.libraries.R;

import static android.content.ContentValues.TAG;

public class AsyncTaskActivity extends AppCompatActivity {

    private static final String TAG = "...";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynktask);

        Button button = findViewById(R.id.btn_asynktask_press);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAsyncTask();
                Log.d(TAG, "метод, вызвавший AsyncTask, завершен, поток - " + Thread.currentThread().getName());
            }
        });
    }
    private void callAsyncTask(){
        TimerAsyncTask task = new TimerAsyncTask();
        task.execute();
    }

    private static class TimerAsyncTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "Начат отсчет, поток - " + Thread.currentThread().getName());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 1; i <=5; i++){
                try {
                    Thread.sleep(1000);
                    Log.d(TAG, String.format("%d, поток - %s", i, Thread.currentThread().getName()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(TAG, "Отсчет завершен");
        }
    }
}


