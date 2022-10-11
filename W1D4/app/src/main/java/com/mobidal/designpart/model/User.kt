package com.mobidal.designpart.model

import java.io.Serializable

data class User(var firstName: String, var lastName: String,
                var username: String, var password: String): Serializable {

    fun isValid(username: String, password: String) =
        this.username == username && this.password == password

}