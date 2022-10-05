package com.mobidal.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var mFoodNameTextView: TextView
    private lateinit var mFoodNameEditText: EditText
    private lateinit var mAddFoodButton: Button
    private lateinit var mDecideButton: Button

    private var foods: ArrayList<String> =
        arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind views
        mFoodNameTextView = findViewById(R.id.tv_food_name)
        mFoodNameEditText = findViewById(R.id.et_food_name)
        mAddFoodButton = findViewById(R.id.b_add_food)
        mDecideButton = findViewById(R.id.b_decide_food)

        mDecideButton.setOnClickListener {
            val randomIndex = foods.indices.random()
            mFoodNameTextView.text = foods[randomIndex]
        }

        mAddFoodButton.setOnClickListener {
            val foodName: String = mFoodNameEditText.text.toString()
            foods.add(foodName)

            mFoodNameEditText.setText("")
            Toast.makeText(this@MainActivity,
                "Food added successfully", Toast.LENGTH_SHORT)
                .show()
        }
    }
}