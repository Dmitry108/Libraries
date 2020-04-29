package ru.bdim.lesson5room.module;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Single<Long> insert(Person person);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Single<List<Long>> insertAll(List<Person> person);

    @Query("SELECT * FROM persons")
    Single<List<Person>> findAll();

    @Query("SELECT * FROM persons WHERE name LIKE :name OR surname LIKE :surname")
    Single<List<Person>> find(String name, String surname);

    @Delete
    Single<Integer> delete(Person person);

    @Update
    Single<Integer> update(Person person);

}
