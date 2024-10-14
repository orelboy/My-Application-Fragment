package com.practicum.myapplicationfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.practicum.myapplicationfragment.databinding.FragmentANestedBinding

// Первый вложенный фрагмент
class NestedFragmentA : BindingFragment<FragmentANestedBinding>()  {

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentANestedBinding {
        return FragmentANestedBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Установка названия песни и передача данных Activity
        binding.songText.text = (requireActivity() as SongNameProvider).getSongName()
            .plus(other = " | A")

        // Заставляем наш ViewPager переключиться на следующую страницу
        binding.button.setOnClickListener {
            (parentFragment as? SelectPage)?.navigateTo(page = 1)
        }
    }
}