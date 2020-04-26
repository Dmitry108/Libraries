package ru.bdim.lesson4.task2.model;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiHub {

    String PATH = "users/{user-name}";

    @GET(PATH)
    Single<HubRequest> getHub(@Path("user-name") String name);
}
