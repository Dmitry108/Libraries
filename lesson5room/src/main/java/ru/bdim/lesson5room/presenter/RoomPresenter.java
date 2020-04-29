package ru.bdim.lesson5room.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.bdim.lesson5room.applicatoin.RoomApp;
import ru.bdim.lesson5room.module.Person;
import ru.bdim.lesson5room.module.PersonDao;
import ru.bdim.lesson5room.view.RoomView;

@InjectViewState
public class RoomPresenter extends MvpPresenter<RoomView> {

    private PersonDao personDB;
    private static final String TAG = "...";

    private List<Person> people;
    private List<Person> listForInsert;
    private int index;

    public RoomPresenter(){
        personDB = RoomApp.getPersonDatabase().personDao();
        index = 0;
    }

    public void findByNameOrSurname(String name, String surmane) {
        find(personDB.find(name, surmane));
    }
    public void findAll() {
        find(personDB.findAll());
    }
    private void find (Single<List<Person>> single){
        Disposable d = single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    Log.d(TAG, "Найден список: " + list);
                    people = list;
                    index = 0;
                    if (list.size() > 0){
                        getViewState().showPerson(list.get(0));
                    }
                }, e -> Log.d(TAG, e.toString()));
    }

    public void previous() {
        if (people != null && index > 0){
            getViewState().showPerson(people.get(--index));
        }
    }
    public void next(){
        if (people != null && index < people.size() - 1){
            getViewState().showPerson(people.get(++index));
        }
    }

    public void delete(List<String> editData) {
        if (!editData.get(0).equals("")){
            Person person = new Person(editData);
            Disposable d = personDB.delete(person)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(id -> Log.d(TAG, "Удалена запись: " + person),
                            e -> Log.d(TAG, e.toString()));
        }
    }

    public void update(List<String> editData) {
        if (!editData.get(0).equals("")){
            Person person = new Person(editData);
            Disposable d = personDB.update(person)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(id -> Log.d(TAG, "Обновлена запись: " + person),
                            e -> Log.d(TAG, e.toString()));
        }
    }

    public void addToListForInsert(List<String> editData) {
        try {
            if (listForInsert == null){
                listForInsert = new ArrayList<>();
            }
            listForInsert.add(new Person(editData));
        } catch (Exception e){
            getViewState().showMessage("Incorrect data");
            Log.d(TAG, e.toString());
        }
    }

    public void insert(List<String> data) {
        try {
            Person person = new Person(data);
            Disposable d = personDB.insert(person)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(id -> Log.d(TAG, "Добавлена запись: " + person),
                            e -> Log.d(TAG, e.toString()));

        } catch (Exception e){
            getViewState().showMessage("Incorrect data");
            Log.d(TAG, e.toString());
        }

    }
    public void insertAll() {
        if (listForInsert != null){
            Disposable d = personDB.insertAll(listForInsert)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(list -> Log.d(TAG, "Добавлены записи с id " + list),
                            e -> Log.d(TAG, e.toString()));
        }
    }
}