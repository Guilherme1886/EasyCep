package android.examples.retrofitcep.rest

import android.examples.retrofitcep.rest.request_geolocation.ResultsAndStatus
import android.examples.retrofitcep.rest.request_via_cep.DataCEP
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Guilherme on 23/10/2016.
 */

interface ApiInterface {


    @GET("/ws/{cep}/json/")
    fun getCep(@Path("cep") cep: String): Call<DataCEP>

    @GET("https://maps.googleapis.com/maps/api/geocode/json?address={address}&key=AIzaSyBVoKgJq3iAr2VDvxyvX1QNVTqDFyWd-DI")
    fun getMap(@Path("address") address: String): Call<ResultsAndStatus>


}
