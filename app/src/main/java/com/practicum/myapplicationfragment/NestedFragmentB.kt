package com.practicum.myapplicationfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.practicum.myapplicationfragment.databinding.FragmentBNestedBinding

// Второй вложенный фрагмент
class NestedFragmentB : BindingFragment<FragmentBNestedBinding>() {

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBNestedBinding {
        return FragmentBNestedBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Установка названия песни и передача данных Activity
        binding.songText.text = (requireActivity() as SongNameProvider).getSongName()
            .plus(other = " | B")

        // Заставляем наш ViewPager переключиться на следующую страницу
        binding.button.setOnClickListener {
            (parentFragment as? SelectPage)?.navigateTo(page = 0)
        }
    }
}