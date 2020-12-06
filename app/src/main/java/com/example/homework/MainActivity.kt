package com.example.homework

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Notes"
        setContentView(R.layout.activity_main)
        val assetsBitmap:Bitmap? = getBitmapFromAssets("logo1.jpg")
        imageView.setImageBitmap(assetsBitmap)

        val logSampleCardView = findViewById<CardView>(R.id.cardView)
        logSampleCardView.setOnClickListener(this)

    }

    private fun getBitmapFromAssets(fileName: String): Bitmap? {
        return try {
            BitmapFactory.decodeStream(assets.open(fileName))
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
    override fun onClick(view: View) {
        val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }

}