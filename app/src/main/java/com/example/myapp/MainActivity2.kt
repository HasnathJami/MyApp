package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMain2Binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main2)

        binding.btnGoBack.setOnClickListener(View.OnClickListener {
            var intent = Intent()
            intent.putExtra("result", "Android Engineer")
            setResult(RESULT_OK, intent)
            finish()
        })

    }

}