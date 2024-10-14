package com.practicum.myapplicationfragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Главная активити, к которой будут привязаны наши фрагменты
class MainActivity : AppCompatActivity(R.layout.activity_main),
    SongNameProvider  {

    override fun getSongName(): String = "Jungle - Casio"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            // Отображаем родительский фрагмент, в который дальше добавим ViewPager с фрагментами.
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, FragmentA.newInstance(getSongName()))
                .commit()
        }
    }
}