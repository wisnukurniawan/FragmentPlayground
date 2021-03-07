package com.wisnu.kurniawan.fragmentplayground.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity

class ActivityLifecycleLogger : Application.ActivityLifecycleCallbacks {

    private val fragmentLifecycleLogger = FragmentLifecycleLogger()

    override fun onActivityPaused(activity: Activity) {
        Log.d("wisnukrn", "${activity.className()} onPause()")
    }

    override fun onActivityResumed(activity: Activity) {
        Log.d("wisnukrn", "${activity.className()} onResume()")
    }

    override fun onActivityStarted(activity: Activity) {
        Log.d("wisnukrn", "${activity.className()} onStart()")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Log.d("wisnukrn", "${activity.className()} onDestroy()")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Log.d("wisnukrn", "${activity.className()} onSaveInstanceState")
    }

    override fun onActivityStopped(activity: Activity) {
        Log.d("wisnukrn", "${activity.className()} onStop()")
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.d("wisnukrn", "${activity.className()} onActivityCreated")

        registerFragmentLifecycleLogger(activity)
    }

    private fun registerFragmentLifecycleLogger(activity: Activity?) {
        if (activity is FragmentActivity) {
            activity
                .supportFragmentManager
                .registerFragmentLifecycleCallbacks(fragmentLifecycleLogger, true)
        }
    }

    private fun Activity?.className() = this?.javaClass?.canonicalName.orEmpty()

    companion object {
        fun bind(application: Application) {
            application.registerActivityLifecycleCallbacks((ActivityLifecycleLogger()))
        }
    }
}
