package com.esther.mapsample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.esther.mapsample.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.esther.mapsample.databinding.ActivityMapsBinding
import com.esther.mapsample.model.Transit
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.gson.Gson

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    lateinit var jsonString: String
    lateinit var transitDialogFragment: TransitDialogFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        try {
            jsonString =  applicationContext.assets.open("transit.json")
                .bufferedReader()
                .use { it.readText() }
            val transit: Transit = Gson().fromJson(jsonString, Transit::class.java)
            Log.d("esther", "${transit}")

        } catch (e: Exception) {
            Log.d("esther", "error ${e.message}")
        }
        transitDialogFragment = TransitDialogFragment.newInstance(30)

        binding.fabDirections.setOnClickListener {
            transitDialogFragment.show(supportFragmentManager, "dialog")
        }
        transitDialogFragment.show(supportFragmentManager, "dialog")
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}