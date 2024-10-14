package com.practicum.myapplicationfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.practicum.myapplicationfragment.databinding.FragmentABinding

// Родительский класс, в который положим вложенные классы NestedFragmentA и NestedFragmentB.
// Родительский класс, в котором будет наш ViewPager
class FragmentA : BindingFragment<FragmentABinding>() {

    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentABinding {
        return FragmentABinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Установка названия песни и передача данных через аргументы
        binding.songText.text = requireArguments().getString(SONG_NAME_KEY)
            .plus(other = " | Parent")

        // Таким образом происходит установка адаптера нашему ViewPager
        val adapter = PagerAdapter(hostFragment = this)
        binding.pager.adapter = adapter
    }

    companion object {
        private const val SONG_NAME_KEY = "SONG_NAME_KEY"

        fun newInstance(songName: String): FragmentA = FragmentA().apply {
            arguments = bundleOf(SONG_NAME_KEY to songName)
        }
    }
}