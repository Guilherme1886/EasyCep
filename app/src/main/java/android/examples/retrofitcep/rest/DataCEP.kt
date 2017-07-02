package android.examples.retrofitcep.rest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Guilherme on 02/07/2017.
 */
class DataCEP {

    @SerializedName("cep")
    @Expose
    var cep: String? = null
    @SerializedName("logradouro")
    @Expose
    var logradouro: String? = null
    @SerializedName("complemento")
    @Expose
    var complemento: String? = null
    @SerializedName("bairro")
    @Expose
    var bairro: String? = null
    @SerializedName("localidade")
    @Expose
    var localidade: String? = null
    @SerializedName("uf")
    @Expose
    var uf: String? = null
    @SerializedName("unidade")
    @Expose
    var unidade: String? = null
    @SerializedName("ibge")
    @Expose
    var ibge: String? = null
    @SerializedName("gia")
    @Expose
    var gia: String? = null
}