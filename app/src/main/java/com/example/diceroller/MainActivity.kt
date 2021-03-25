package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    val imagesList = listOf<Int>(R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var animation:Animation = AnimationUtils.loadAnimation(
                this, R.anim.dice_rotate);

        var dice1Image = findViewById<ImageView>(R.id.dice1)
        var dice2Image = findViewById<ImageView>(R.id.dice2)

        findViewById<Button>(R.id.clickMe).setOnClickListener {
            dice1Image.startAnimation(animation)
            dice2Image.startAnimation(animation)
            Thread(Runnable {
                Thread.sleep(500)
                dice1Image.setImageResource(imagesList.random())
                dice1Image.startAnimation(animation)
                dice2Image.setImageResource(imagesList.random())
                dice2Image.startAnimation(animation)
            }).start()
        }


    }
}