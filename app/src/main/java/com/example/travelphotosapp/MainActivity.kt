package com.example.travelphotosapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var currentImage = 0
    private lateinit var image : ImageView
    var places= arrayOf("Tansen ka makbara","Tansen Ghar","Gwalior fort","Jai Vilas Palace","Saas Bahu Mandir")


    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next= findViewById<ImageButton>(R.id.btnnext)
        val prev= findViewById<ImageButton>(R.id.btnprev)
        val placeName= findViewById<TextView>(R.id.TVname)

        next.setOnClickListener {

            val idCurrentImageString= "pic$currentImage" //String ID
            val idCurrentImageInt= this.resources.getIdentifier(idCurrentImageString,"id", packageName)  // convert String ID into intiger address
            image= findViewById(idCurrentImageInt) // Store current image's integer address in image var
            image.alpha= 0f // Make current image invisible

            currentImage= (5+currentImage+1)%5 //That make a loop of 0 to 4
//            Now we make current+1 image visible
            val idImageToShowString= "pic$currentImage"
            val idImageToShowInt= this.resources.getIdentifier(idImageToShowString,"id", packageName)
            image= findViewById(idImageToShowInt)
            image.alpha= 1f

            placeName.text= places[currentImage]


        }

        prev.setOnClickListener{
//            I want to see the prev Image
            val idCurrentImageString= "pic$currentImage" //String ID
            val idCurrentImageInt= this.resources.getIdentifier(idCurrentImageString,"id", packageName)  // convert String ID into intiger address
            image= findViewById(idCurrentImageInt) // Store current image's integer address in image var
            image.alpha= 0f // Make current image invisible

            currentImage= (5+currentImage-1)%5 //That make a loop of 0 to 4
//            Now we make current+1 image visible
            val idImageToShowString= "pic$currentImage"
            val idImageToShowInt= this.resources.getIdentifier(idImageToShowString,"id", packageName)
            image= findViewById(idImageToShowInt)
            image.alpha= 1f
            placeName.text= places[currentImage]

        }

        }
    }
