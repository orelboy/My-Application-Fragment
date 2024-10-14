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

//    private var _binding: FragmentANestedBinding? = null
//    private val binding get() = _binding!!
    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentANestedBinding {
        return FragmentANestedBinding.inflate(inflater, container, false)
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentANestedBinding.inflate(inflater, container, false)
//        return binding.root
//    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Установка названия песни - передача данных Activity
        binding.songText.text = (requireActivity() as SongNameProvider).getSongName()
            .plus(other = " | A")

        /**
         * При нажатии на кнопку заменяем фрагмент, который находится внутри контейнера
         * "fragment_child_container", на новый
         */
        binding.button.setOnClickListener {
            // Тут транзакция реализована через extension функцию, а не через цепочку из методов
            parentFragmentManager.commit {
                replace(R.id.fragment_child_container, NestedFragmentB())
                addToBackStack(null)
            }
        }
    }
}