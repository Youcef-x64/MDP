package com.mobidal.w1d5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobidal.w1d5.adapter.FoodAdapter
import com.mobidal.w1d5.module.Food
import kotlinx.android.synthetic.main.activity_foods.*

class FoodsActivity : AppCompatActivity(), FoodAdapter.OnFoodClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foods)

        val adapter = FoodAdapter(this, getList(), this)

        val layoutManager = GridLayoutManager(this, 2,
            GridLayoutManager.VERTICAL, false)

        rv_food.layoutManager = layoutManager
        rv_food.adapter = adapter
    }

    private fun getList(): List<Food> {
        val list = ArrayList<Food>()

        list.add(Food(R.drawable.coffee_pot,
            resources.getString(R.string.item_1_name),
            resources.getString(R.string.item_1_recipe)))
        list.add(Food(R.drawable.espresso,
            resources.getString(R.string.item_2_name),
            resources.getString(R.string.item_2_recipe)))
        list.add(Food(R.drawable.french_fries,
            resources.getString(R.string.item_3_name),
            resources.getString(R.string.item_3_recipe)))
        list.add(Food(R.drawable.honey,
            resources.getString(R.string.item_4_name),
            resources.getString(R.string.item_4_recipe)))
        list.add(Food(R.drawable.strawberry_ice_cream,
            resources.getString(R.string.item_5_name),
            resources.getString(R.string.item_5_recipe)))
        list.add(Food(R.drawable.sugar_cubes,
            resources.getString(R.string.item_6_name),
            resources.getString(R.string.item_6_recipe)))

        return list
    }

    override fun onFoodClicked(food: Food) {
        val intent = Intent(this, FoodActivity::class.java)

        intent.putExtra(FoodActivity.EXTRA_FOOD, food)

        startActivity(intent)
    }
}