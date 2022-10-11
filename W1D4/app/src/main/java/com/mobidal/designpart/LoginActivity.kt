package com.mobidal.designpart

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.mobidal.designpart.model.User
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create users
        users.add(User("John", "Doe", "user1@miu.edu", "1231"))
        users.add(User("Jane", "Doe", "user2@miu.edu", "1232"))
        users.add(User("Jack", "Doe", "user3@miu.edu", "1233"))
        users.add(User("Jason", "Doe", "user4@miu.edu", "1234"))
        users.add(User("Jasmin", "Doe", "user5@miu.edu", "1235"))

        b_sign_in.setOnClickListener {
            var username = til_email.editText?.text.toString()
            var password = til_password.editText?.text.toString()

            var user = users.singleOrNull { user -> user.isValid(username, password) }

            if (user == null) {
                til_email.editText?.error = "Wrong username or password"
                til_password.editText?.error = "Wrong username or password"
            } else {
                val intent = Intent(this@LoginActivity, CategoryActivity::class.java)

                intent.putExtra(CategoryActivity.EXTRA_USERNAME, user.username)

                startActivity(intent)
            }
        }

        var resultContracts =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val user = result.data?.getSerializableExtra("user") as User

                    users.add(user)
                } else {

                }
            }

        b_create_account.setOnClickListener {
            val intent = Intent(this@LoginActivity, CreateAccountActivity::class.java)
            resultContracts.launch(intent)
        }

        tv_forget_password.setOnClickListener {
            Toast.makeText(this, "tv_forget_password"
                , Toast.LENGTH_LONG)
                .show()

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")

            val username = til_email.editText?.text.toString()

            var user = users.singleOrNull { user -> user.username == username }

            val mailTo = "mailto:" + username +
                    "?&subject=" + Uri.encode("Password").toString() +
                    "&body=" + Uri.encode("Your password: ${user?.password}")

            val uri = Uri.parse(mailTo)

            val emailIntent = Intent(Intent.ACTION_SENDTO, uri)
            
            startActivity(Intent.createChooser(emailIntent, "Email App"))
        }
    }
}