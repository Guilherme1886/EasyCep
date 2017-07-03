package android.examples.retrofitcep.rest.request_geolocation

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Guilherme on 02/07/2017.
 */
class Bounds {

    @SerializedName("northeast")
    @Expose
    var northeast: Northeast? = null
    @SerializedName("southwest")
    @Expose
    var southwest: Southwest? = null
}