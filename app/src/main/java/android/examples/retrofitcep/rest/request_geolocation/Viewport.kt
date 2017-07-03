package android.examples.retrofitcep.rest.request_geolocation

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Guilherme on 02/07/2017.
 */
class Viewport {

    @SerializedName("northeast")
    @Expose
    var northeast: Northeast_? = null
    @SerializedName("southwest")
    @Expose
    var southwest: Southwest_? = null
}