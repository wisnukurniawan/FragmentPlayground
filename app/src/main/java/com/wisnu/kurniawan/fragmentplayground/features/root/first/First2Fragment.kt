package com.wisnu.kurniawan.fragmentplayground.features.root.first

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.wisnu.kurniawan.fragmentplayground.R
import com.wisnu.kurniawan.fragmentplayground.databinding.FirstFragment2Binding

class First2Fragment : Fragment(R.layout.first_fragment_2) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FirstFragment2Binding.bind(view)

        binding.buttonFirstFragment2GoBack.setOnClickListener {
            NavHostFragment.findNavController(requireParentFragment()).popBackStack()
        }

        binding.buttonFirstFragment2GoNext.setOnClickListener {
            NavHostFragment.findNavController(requireParentFragment()).navigate(R.id.first2_to_first3)
        }

        (requireActivity() as OnBackPressedDispatcherOwner).onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            NavHostFragment.findNavController(requireParentFragment()).popBackStack()
        }
    }
}
