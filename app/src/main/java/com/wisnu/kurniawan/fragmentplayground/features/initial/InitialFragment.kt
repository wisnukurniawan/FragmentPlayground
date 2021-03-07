package com.wisnu.kurniawan.fragmentplayground.features.initial

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.wisnu.kurniawan.fragmentplayground.R
import com.wisnu.kurniawan.fragmentplayground.databinding.InitialFragmentBinding

class InitialFragment: Fragment(R.layout.initial_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = InitialFragmentBinding.bind(view)

        binding.buttonInitialGoToNext.setOnClickListener {
            findNavController().navigate(R.id.initial_to_root)
        }
    }

}
