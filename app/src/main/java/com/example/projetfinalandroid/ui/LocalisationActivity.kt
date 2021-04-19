package com.example.projetfinalandroid.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.example.projetfinalandroid.R
import com.example.projetfinalandroid.data.LocalPreferences
import kotlinx.android.synthetic.main.activity_localisation.*
import java.util.*


class LocalisationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localisation)

        supportActionBar?.apply {
            setTitle(getString(R.string.topbar_localisation))
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        btn_localisation.setOnClickListener({
            requestPermission()
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            PERMISSION_REQUEST_LOCATION -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // Permission obtenue, Nous continuons la suite de la logique.
                    getLocation()
                } else {
                    // TODO
                    // Permission non accepté, expliqué ici via une activity ou une dialog pourquoi nous avons besoins de la permissions
                }
                return
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        if (hasPermission()) {
            val locationManager = applicationContext.getSystemService(LOCATION_SERVICE) as LocationManager?
            locationManager?.run {
                Log.d("test", "test test test")
                locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)?.run {
                    Log.d("test", "test test")
                    val distance = calculDistance(this)
                    val adresse : String = geoCode(this)
                    afficherAdresse(adresse)
                    savePosition(adresse)
                    afficherDistance(distance)
                }
            }
        }
    }

    private fun afficherDistance(distance : Double){
//        Toast.makeText(this, distance.toString() + " km", Toast.LENGTH_SHORT).show()
        text_distance.setText(distance.toString() + " km")
    }

    private fun afficherAdresse(adresse : String){
//        Toast.makeText(this, distance.toString() + " km", Toast.LENGTH_SHORT).show()
        text_adresse.setText(adresse)
    }

    private fun calculDistance(location: Location): Double {

        val p = Math.pow(10.0, 1.0) // Arrondir le nb de décimal
        val destination = Location("eseo")
        destination.latitude = 47.4937187
        destination.longitude = -0.5504861

        val distance = location.distanceTo(destination).toDouble()/1000 // Calcul de la distance en km

        val finalDistance = Math.floor((distance) *p)/p // Distance arrondie

        return finalDistance
    }

    private fun requestPermission() {

        if (!hasPermission()) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), PERMISSION_REQUEST_LOCATION)
        } else {
            getLocation()
        }
    }

    private fun savePosition(adresse : String){
        //LocalPreferences.getInstance(this).saveStringValue(adresse)
        LocalPreferences.getInstance(this).addToHistory(adresse)
    }

    private fun hasPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    private fun geoCode(location: Location): String {
        val geocoder = Geocoder(this, Locale.getDefault())
        val results = geocoder.getFromLocation(location.latitude, location.longitude, 1)

        return results[0].getAddressLine(0)
    }


    companion object {

        const val PERMISSION_REQUEST_LOCATION = 9999

        fun getStartIntent(context: Context): Intent {
            return Intent(context, LocalisationActivity::class.java)
        }
    }
}