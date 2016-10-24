package android.examples.retrofitcep.rest;

import android.examples.retrofitcep.model.Cep;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Guilherme on 23/10/2016.
 */

public interface ApiInterface {

    public static final String URL = "https://viacep.com.br";

    @GET("/ws/{cep}/json/")
    public void getCep(@Path("cep") String cep, Callback<Cep> response);


}
