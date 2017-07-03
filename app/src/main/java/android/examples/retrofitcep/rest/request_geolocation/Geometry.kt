package android.examples.retrofitcep.rest.request_geolocation

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Guilherme on 02/07/2017.
 */
class Geometry {

    @SerializedName("bounds")
    @Expose
    var bounds: Bounds? = null
    @SerializedName("location")
    @Expose
    var location: Location? = null
    @SerializedName("location_type")
    @Expose
    var locationType: String? = null
    @SerializedName("viewport")
    @Expose
    var viewport: Viewport? = null
}