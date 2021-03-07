package com.wisnu.kurniawan.fragmentplayground.app

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentLifecycleLogger : FragmentManager.FragmentLifecycleCallbacks() {

    override fun onFragmentAttached(fragmentManager: FragmentManager, fragment: Fragment, context: Context) {
        Log.d("wisnukrn", "${fragment.className()} onAttached()")
    }

    override fun onFragmentCreated(fragmentManager: FragmentManager, fragment: Fragment, savedInstanceState: Bundle?) {
        Log.d("wisnukrn", "${fragment.className()} onCreated(savedInstanceState: $savedInstanceState)")
    }

    override fun onFragmentViewCreated(fragmentManager: FragmentManager, fragment: Fragment, view: View, savedInstanceState: Bundle?) {
        Log.d("wisnukrn", "${fragment.className()} onViewCreated")
    }

    override fun onFragmentStarted(fragmentManager: FragmentManager, fragment: Fragment) {
        Log.d("wisnukrn", "${fragment.className()} onStarted()")
    }

    override fun onFragmentResumed(fragmentManager: FragmentManager, fragment: Fragment) {
        Log.d("wisnukrn", "${fragment.className()} onResumed()")
    }

    override fun onFragmentPaused(fragmentManager: FragmentManager, fragment: Fragment) {
        Log.d("wisnukrn", "${fragment.className()} onPaused()")
    }

    override fun onFragmentStopped(fragmentManager: FragmentManager, fragment: Fragment) {
        Log.d("wisnukrn", "${fragment.className()} onStopped()")
    }

    override fun onFragmentViewDestroyed(fragmentManager: FragmentManager, fragment: Fragment) {
        Log.d("wisnukrn", "${fragment.className()} onViewDestroyed()")
    }

    override fun onFragmentDestroyed(fragmentManager: FragmentManager, fragment: Fragment) {
        Log.d("wisnukrn", "${fragment.className()} onDestroyed()")
    }

    override fun onFragmentDetached(fragmentManager: FragmentManager, fragment: Fragment) {
        Log.d("wisnukrn", "${fragment.className()} onDetached()")
    }

    override fun onFragmentSaveInstanceState(fragmentManager: FragmentManager, fragment: Fragment, outState: Bundle) {
        Log.d("wisnukrn", "${fragment.className()} onSaveInstanceState")
    }

    private fun Fragment?.className() = this?.javaClass?.canonicalName.orEmpty()

}
