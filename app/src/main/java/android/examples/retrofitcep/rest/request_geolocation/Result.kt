package android.examples.retrofitcep.rest.request_geolocation

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Guilherme on 02/07/2017.
 */
class Result {

    @SerializedName("address_components")
    @Expose
    var addressComponents: List<AddressComponent>? = null
    @SerializedName("formatted_address")
    @Expose
    var formattedAddress: String? = null
    @SerializedName("geometry")
    @Expose
    var geometry: Geometry? = null
    @SerializedName("partial_match")
    @Expose
    var partialMatch: Boolean? = null
    @SerializedName("place_id")
    @Expose
    var placeId: String? = null
    @SerializedName("types")
    @Expose
    var types: List<String>? = null
}