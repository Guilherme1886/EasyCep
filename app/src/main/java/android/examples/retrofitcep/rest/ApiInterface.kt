package android.examples.retrofitcep.rest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Guilherme on 23/10/2016.
 */

interface ApiInterface {

    @GET("/ws/{cep}/json/")
    fun getCep(@Path("cep") cep: String): Call<DataCEP>


}
