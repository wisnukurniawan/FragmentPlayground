package com.wisnu.kurniawan.fragmentplayground.features.root.first

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.wisnu.kurniawan.fragmentplayground.R
import com.wisnu.kurniawan.fragmentplayground.databinding.FirstFragment3Binding

class First3Fragment : Fragment(R.layout.first_fragment_3) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FirstFragment3Binding.bind(view)

        binding.buttonFirstFragment3GoBack.setOnClickListener {
            NavHostFragment.findNavController(requireParentFragment()).popBackStack()
        }

        (requireActivity() as OnBackPressedDispatcherOwner).onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            NavHostFragment.findNavController(requireParentFragment()).popBackStack()
        }
    }
}
