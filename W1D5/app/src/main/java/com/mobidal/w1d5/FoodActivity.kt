package com.mobidal.w1d5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobidal.w1d5.module.Food
import kotlinx.android.synthetic.main.activity_food.*

class FoodActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FOOD = "extra_food"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val food = intent.getSerializableExtra(EXTRA_FOOD) as Food

        iv_picture.setImageResource(food.pictureResId)
        tv_name.text = food.name
        tv_recipe.text = food.recipe
    }
}