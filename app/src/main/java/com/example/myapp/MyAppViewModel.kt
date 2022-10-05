package com.example.myapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class MyAppViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var name: String

    private fun setName(name: String) {
        this.name = name;
    }

    private fun getName(): String = name


}