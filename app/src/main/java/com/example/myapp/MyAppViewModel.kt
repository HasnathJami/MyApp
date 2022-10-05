package com.example.myapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MyAppViewModel(application: Application) : AndroidViewModel(application) {

    private val reactiveList: MutableLiveData<List<String>> = MutableLiveData<List<String>>()
    private var list:ArrayList<String> = ArrayList()

    init {
        list.add("Hasnath Jami Chowdhury")
        list.add("Sayem")
        reactiveList.value=list
    }

    private lateinit var name: String

    private fun setName(name: String) {
        this.name = name;
    }

    public fun getName(): String = name


    public fun getList(): ArrayList<String> {
        return list;
    }

    public fun getReactiveList(): LiveData<List<String>> {
        return reactiveList;
    }


}