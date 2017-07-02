package android.examples.retrofitcep.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.examples.retrofitcep.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.activity_main.*

class MapaActivity : AppCompatActivity(), OnMapReadyCallback {

    private var mMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)


        setSupportActionBar(my_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        







        configMap()
    }

    override fun onMapReady(p0: GoogleMap?) {

        mMap = p0

        val lat = 2.1481691
        val lng = -2.0922524

        val local_user = LatLng(lat, lng)
        mMap?.moveCamera(CameraUpdateFactory.newLatLng(local_user))


        mMap?.uiSettings?.isZoomControlsEnabled = true
        mMap?.uiSettings?.isCompassEnabled = true
        mMap?.isMyLocationEnabled = true

    }

    fun configMap() {

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


    }
}
