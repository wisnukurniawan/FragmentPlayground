package com.wisnu.kurniawan.fragmentplayground.features.root

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.wisnu.kurniawan.fragmentplayground.R
import com.wisnu.kurniawan.fragmentplayground.databinding.RootFragmentBinding
import com.wisnu.kurniawan.fragmentplayground.navigation.FragmentStackHostFragment
import com.wisnu.kurniawan.fragmentplayground.viewBinding

class RootFragment : Fragment(R.layout.root_fragment) {

    private val binding by viewBinding(RootFragmentBinding::bind)

    private val fragmentNavigations = listOf(
        R.navigation.navigation_root_first,
        R.navigation.navigation_root_second,
        R.navigation.navigation_root_third
    )
    private val fragments: ArrayList<Fragment> = arrayListOf()
    private var selectedIndex = 0

    private val tabs: Array<TextView>
        get() = binding.run {
            arrayOf(buttonFirstTab, buttonSecondTab, buttonThirdTab)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            val transaction = childFragmentManager.beginTransaction()

            fragmentNavigations.forEachIndexed { index, i ->
                val fragment = FragmentStackHostFragment.newInstance(i)
                fragments.add(fragment)
                transaction.add(R.id.containerBottomNavContent, fragment, "$index")
            }

            transaction.selectFragment(selectedIndex)
                .commit()
        } else {
            selectedIndex = savedInstanceState.getInt("selectedIndex", 0)

            fragments.clear()
            fragmentNavigations.forEachIndexed { index, _ ->
                val fragment = childFragmentManager.findFragmentByTag("$index") as FragmentStackHostFragment
                fragments.add(fragment)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabs.forEachIndexed { index, textView ->
            textView.setOnClickListener {
                selectFragment(index)
            }
        }

        setupTabSelectedState(selectedIndex)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("selectedIndex", selectedIndex)
    }

    private fun setupTabSelectedState(selectedIndex: Int) {
        tabs.forEachIndexed { index, textView ->
            textView.setTextColor(
                when (index) {
                    selectedIndex -> ContextCompat.getColor(requireContext(), R.color.tab_selected)
                    else -> ContextCompat.getColor(requireContext(), R.color.tab_unselected)
                }
            )
        }
    }

    private fun selectFragment(indexToSelect: Int) {
        this.selectedIndex = indexToSelect

        setupTabSelectedState(indexToSelect)

        childFragmentManager.beginTransaction()
            .selectFragment(indexToSelect)
            .commit()
    }

    private fun FragmentTransaction.selectFragment(selectedIndex: Int): FragmentTransaction {
        fragments.forEachIndexed { index, fragment ->
            if (index == selectedIndex) {
                attach(fragment)
            } else {
                detach(fragment)
            }
        }

        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)

        return this
    }

}
