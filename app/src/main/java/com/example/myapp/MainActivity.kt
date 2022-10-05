package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.view.View
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
        initListener()

    }

    private fun populateNameSectionUi(list: List<String>) {
        mBinding.tvName.text = list[0]
    }

    private fun subscribeUi() {
        subscribeUiToReactiveList(mViewModel.getReactiveList())
    }

    private fun subscribeUiToReactiveList(liveData: LiveData<List<String>>) {
        liveData.observe(this, Observer {
            populateNameSectionUi(it)
        })
    }

    private fun initListener() {
        mBinding.btnNext.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            //startActivity(intent)
            startActivityForResult(intent, 200)

        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 200) {
            if (resultCode == RESULT_OK) {
                val role: String? = data?.getStringExtra("result")
                mBinding.tvRole.text = role

            }
        }
    }

}