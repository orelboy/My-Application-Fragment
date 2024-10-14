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

//    private var _binding: FragmentBNestedBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentBNestedBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBNestedBinding {
        return FragmentBNestedBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.songText.text = (requireActivity() as SongNameProvider).getSongName()
            .plus(other = " | B")
        /**
         * Тут также при нажатии на кнопку заменяем фрагмент из "fragment_child_container" на
         * другой.
         */
        binding.button.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_child_container, NestedFragmentA())
            }
        }
    }
}