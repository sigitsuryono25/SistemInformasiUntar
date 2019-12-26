package com.e.sisteminformasiuntar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class PetaUntar : Fragment(), OnMapReadyCallback, View.OnClickListener {


    lateinit var untarsatu: LatLng
    lateinit var untardua: LatLng

    lateinit var map: GoogleMap
    lateinit var mp: SupportMapFragment

    lateinit var normal: Button
    lateinit var satelit: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_peta_untar, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mp = childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mp.getMapAsync(this)

        normal = view.findViewById(R.id.button_normal)
        satelit = view.findViewById(R.id.button_satelit)

        normal.setOnClickListener(this)
        satelit.setOnClickListener(this)
    }

    override fun onMapReady(p0: GoogleMap?) {
        map = p0!!

        untarsatu = LatLng(-6.1694287, 106.7867325)
        map.addMarker((MarkerOptions().position(untarsatu).title("Universitas Tarumanagara Kampus I")))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(untarsatu, 10F))

        untardua = LatLng(-6.1696028, 106.7842287)
        map.addMarker((MarkerOptions().position(untardua).title("Universitas Tarumanagara Kampus II")))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(untardua, 10F))

        val builder = LatLngBounds.Builder()
        builder.include(untarsatu)
        builder.include(untardua)

        val bounds = builder.build()
        map.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 20))

    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.button_normal -> {
                map.mapType = GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.button_satelit -> {
                map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            }
        }
    }
}
