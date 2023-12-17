package com.example.demo_library

import android.content.Context
import android.widget.Toast

object NahidLib {

    fun showToast(context : Context, msg: String){
        Toast.makeText(context, "$msg", Toast.LENGTH_SHORT).show()

    }
}