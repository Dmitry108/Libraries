package ru.bdim.lesson5room.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.bdim.lesson5room.R;
import ru.bdim.lesson5room.module.Person;
import ru.bdim.lesson5room.presenter.RoomPresenter;

public class RoomActivity extends MvpAppCompatActivity implements RoomView {

    @BindViews({R.id.edt_id, R.id.edt_name, R.id.edt_surname, R.id.edt_age})
    List<EditText> edtPerson;

    @InjectPresenter
    RoomPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_previous, R.id.btn_next,
              R.id.btn_find_all, R.id.btn_insert, R.id.btn_update, R.id.btn_delete,
              R.id.btn_find, R.id.btn_add, R.id.btn_insert_all})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_previous:
                presenter.previous();
                break;
            case R.id.btn_next:
                presenter.next();
                break;
            case R.id.btn_find:
                presenter.findByNameOrSurname(edtPerson.get(1).getText().toString(),
                        edtPerson.get(2).getText().toString());
                break;
            case R.id.btn_find_all:
                presenter.findAll();
                break;
            case R.id.btn_insert:
                presenter.insert(getEditData());
                break;
            case R.id.btn_update:
                presenter.update(getEditData());
                break;
            case R.id.btn_delete:
                presenter.delete(getEditData());
                break;
            case R.id.btn_add:
                presenter.addToListForInsert(getEditData());
                break;
            case R.id.btn_insert_all:
                presenter.insertAll();
        }
    }
    private List<String> getEditData(){
        List<String> data = new ArrayList<>();
        for (EditText et: edtPerson){
            data.add(et.getText().toString());
        }
        return data;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPerson(Person person) {
        edtPerson.get(0).setText(String.valueOf(person.getId()));
        edtPerson.get(1).setText(person.getName());
        edtPerson.get(2).setText(person.getSurname());
        edtPerson.get(3).setText(String.valueOf(person.getAge()));
    }
}