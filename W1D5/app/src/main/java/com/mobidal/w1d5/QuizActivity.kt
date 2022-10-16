package com.mobidal.w1d5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_quiz.*
import java.text.SimpleDateFormat
import java.util.*

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var result = 0

        b_submit.setOnClickListener {
            // reset result variable
            result = 0
            val sdf = SimpleDateFormat("yyyy.MM.dd HH:mm:ss")
            val date: String = sdf.format(Date())
            // check first question
            val answer1 = rg.checkedRadioButtonId
            if (answer1 == R.id.rb_choose_1) result += 50

            // check second question
            if (cb_choose_1.isChecked) result += 25
            if (cb_choose_2.isChecked) result += 25
            if (cb_choose_3.isChecked) result -= 25

            val alertBuilder = AlertDialog.Builder(this@QuizActivity)

            alertBuilder.setTitle("Score")
            alertBuilder.setMessage("Your score is: $result/100, date and time: $date")
            alertBuilder.setIcon(R.drawable.ic_done)

            alertBuilder.setPositiveButton("Ok") { dialogInterface, which ->
                dialogInterface.dismiss()
            }

            val dialog = alertBuilder.create()
            dialog.show()
        }

        b_reset.setOnClickListener {
            // reset question one
            rg.clearCheck()

            // reset question two
            cb_choose_1.isChecked = false
            cb_choose_2.isChecked = false
            cb_choose_3.isChecked = false
        }
    }
}