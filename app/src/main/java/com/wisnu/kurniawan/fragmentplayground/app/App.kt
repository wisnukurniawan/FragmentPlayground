package com.wisnu.kurniawan.fragmentplayground.app

import android.app.Application

class App : Application() {
    override fun onCreate() {
        ActivityLifecycleLogger.bind(this)
        super.onCreate()
    }
}
