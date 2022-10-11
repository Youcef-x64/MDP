package com.mobidal.designpart

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mobidal.designpart.model.User
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        b_create_account.setOnClickListener {
            val firstName = til_first_name.editText?.text.toString()
            val lastName = til_last_name.editText?.text.toString()
            val username = til_email.editText?.text.toString()
            val password = til_password.editText?.text.toString()

            val user = User(firstName, lastName, username, password)

            Toast.makeText(this, "Account created successfully"
                , Toast.LENGTH_LONG)
                .show()

            val rintent = intent

            rintent.putExtra("user", user)

            setResult(Activity.RESULT_OK, rintent)

            finish()
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}