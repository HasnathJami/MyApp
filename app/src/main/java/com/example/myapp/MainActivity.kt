package com.example.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewModel: MyAppViewModel
    private lateinit var name: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.lifecycleOwner = this
        mViewModel = ViewModelProvider(this).get(MyAppViewModel::class.java)
        // mBinding.tvName.text = mViewModel.getList()[0]

        subscribeUi()

    }

    private fun populateUi(list: List<String>) {
        mBinding.tvName.text = list[0]
    }

    private fun subscribeUi() {
        subscribeUiToReactiveList(mViewModel.getReactiveList())
    }

    private fun subscribeUiToReactiveList(liveData: LiveData<List<String>>) {
        liveData.observe(this, Observer {
            populateUi(it)
        })
    }
}