package android.examples.retrofitcep.rest.request_geolocation

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Guilherme on 02/07/2017.
 */
class AddressComponent {

    @SerializedName("long_name")
    @Expose
    var longName: String? = null
    @SerializedName("short_name")
    @Expose
    var shortName: String? = null
    @SerializedName("types")
    @Expose
    var types: List<String>? = null
}