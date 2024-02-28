package com.example.simonsays

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


class MainActivity : AppCompatActivity() {
    private lateinit var soundPool: SoundPool
    private var sound1 = 0
    private var sound2 = 0
    private var sound3 = 0
    private var sound4 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        soundPool = SoundPool.Builder()
            .setMaxStreams(4)
            .setAudioAttributes(
                AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build())
            .build()

        sound1 = soundPool.load(this, R.raw.cow, 1)
        sound2 = soundPool.load(this, R.raw.red, 1)
        sound3 = soundPool.load(this, R.raw.pumpkin, 1)
        sound4 = soundPool.load(this, R.raw.pipe, 1)
    }

    fun onImageButtonClicked(view: View) {
        when (view.id) {
            R.id.imageButton1 -> playSound(sound1)
            R.id.imageButton2 -> playSound(sound2)
            R.id.imageButton3 -> playSound(sound3)
            R.id.imageButton4 -> playSound(sound4)
        }
    }

    private fun playSound(soundId: Int) {
        soundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f)
    }
}