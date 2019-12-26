package com.e.sisteminformasiuntar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var fm: FragmentManager
    lateinit var ft: FragmentTransaction
    lateinit var carouselView: CarouselView
    lateinit var btn_data_mahasiswa: ImageView
    lateinit var btn_map: ImageView
    lateinit var btn_portal: ImageView
    lateinit var btn_input_data: ImageView

    val sampleImages = intArrayOf(
        R.drawable.bannersatu,
        R.drawable.bannerdua,
        R.drawable.bannertiga
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_content)

        carouselView = findViewById(R.id.carouselView)
        btn_data_mahasiswa = findViewById(R.id.imageData)
        btn_map = findViewById(R.id.imageMap)
        btn_portal = findViewById(R.id.imagePortal)
        btn_input_data = findViewById(R.id.imageInputData)

        btn_input_data.setOnClickListener(this)
        btn_map.setOnClickListener(this)
        btn_portal.setOnClickListener(this)
        btn_input_data.setOnClickListener(this)

//        pengaturan carouselView
        carouselView.setPageCount(3)
        carouselView.setImageListener(imageListener)

//        fm = supportFragmentManager
//        ft = fm.beginTransaction()
////        ft.replace(R.id.container, MainActivity()).commit()
////        nav_view
////            .menu.getItem(0).isChecked = true
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.imageData -> {

            }
            R.id.imageMap -> {
//               activity?.supportFragmentManager?.beginTransaction()
//                   ?.replace(R.id.container, PetaUntar())?.commit()
//
//               //jika nav_view error tambahkan import kotlinx main.activity
//               //nav_view ke activity_main
//               activity?.nav_view
//                   ?.menu?.getItem(1)?.isChecked = true
//
               fm = supportFragmentManager
               ft = fm.beginTransaction()
               ft.replace(R.id.container, PetaUntar()).commit()
//                supportFragmentManager.beginTransaction().replace(R.id.container, PetaUntar())
//                    .commit()
            }
            R.id.imagePortal -> {

            }
            R.id.imageInputData -> {

            }
        }
    }

    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView?) {
            Glide.with(this@MainActivity).load(sampleImages[position]).into(imageView!!)
        }
    }

}
