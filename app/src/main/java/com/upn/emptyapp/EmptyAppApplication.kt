package com.upn.emptyapp

import android.app.Application
import com.google.firebase.FirebaseApp

class EmptyAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}
