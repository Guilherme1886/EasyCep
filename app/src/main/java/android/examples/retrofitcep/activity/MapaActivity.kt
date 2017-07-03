package android.examples.retrofitcep.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.examples.retrofitcep.R
import android.examples.retrofitcep.rest.request_geolocation.ResultsAndStatus
import android.examples.retrofitcep.rest.request_via_cep.DataCEP
import android.examples.retrofitcep.utils.Utils
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapaActivity : AppCompatActivity(), OnMapReadyCallback {

    private var mMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)

        configToolbar()
        configMap()

        val address = intent.getStringExtra("address")

        if (address.isNotEmpty()) {
            getJsonMap()

        }


    }

    private fun configToolbar() {
        setSupportActionBar(my_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()

        return super.onSupportNavigateUp()
    }

    override fun onMapReady(p0: GoogleMap?) {

        mMap = p0

        val lat = -16.7574074
        val lng = -49.2561044

        val local_user = LatLng(lat, lng)
        mMap?.moveCamera(CameraUpdateFactory.newLatLng(local_user))
        mMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(lat, lng), 15.0f))


        mMap?.uiSettings?.isZoomControlsEnabled = true
        mMap?.uiSettings?.isCompassEnabled = true
        mMap?.isMyLocationEnabled = true

    }

    fun configMap() {

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


    }

    private fun getJsonMap() {

        val callMap = Utils.apiService?.getMap("")

        object : Thread() {
            override fun run() {
                callMap?.enqueue(object : Callback<ResultsAndStatus> {
                    override fun onResponse(call: Call<ResultsAndStatus>?, response: Response<ResultsAndStatus>?) {

                        val r = response?.body()

                        if (response?.isSuccessful as Boolean) {


                        }


                    }

                    override fun onFailure(call: Call<ResultsAndStatus>?, t: Throwable?) {

                    }

                })
            }
        }.start()


    }
}
