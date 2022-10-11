package com.mobidal.designpart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val username = intent.getStringExtra(EXTRA_USERNAME)

        tv_welcome.text = "Welcome $username"
    }

    fun categoryClicked(view: View) {
        when(view.id) {
            R.id.ll_1 ->
                Toast.makeText(this, "You have chosen the Electronic category of shopping"
                    , Toast.LENGTH_LONG)
                    .show()
            R.id.ll_2 ->
                Toast.makeText(this, "You have chosen the Clothing category of shopping"
                    , Toast.LENGTH_LONG)
                    .show()
            R.id.ll_3 ->
                Toast.makeText(this, "You have chosen the Beauty category of shopping"
                    , Toast.LENGTH_LONG)
                    .show()
            R.id.ll_4 ->
                Toast.makeText(this, "You have chosen the Food category of shopping"
                    , Toast.LENGTH_LONG)
                    .show()
        }
    }
}