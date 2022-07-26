package com.udacity.shoestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.ActivityLoginBinding
import com.udacity.shoestore.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)

        binding.buttonLogin.setOnClickListener { view: View ->
            //read value from EditText to a String variable
            val email: String = binding.editTextTextEmailAddress.text.toString()
            val password: String = binding.editTextTextPassword.text.toString()
                //check if the EditText have values or not
            if(email.trim().isNotEmpty()&&password.trim().isNotEmpty()) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }else{
                    Toast.makeText(applicationContext, "Please enter your email and password! ", Toast.LENGTH_SHORT).show()
                }

        }
        binding.buttonCreate.setOnClickListener { view: View ->
            //read value from EditText to a String variable
            val email: String = binding.editTextTextEmailAddress.text.toString()
            val password: String = binding.editTextTextPassword.text.toString()

            //check if the EditText have values or not
            if(email.trim().isNotEmpty()&&password.trim().isNotEmpty()) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(applicationContext, "Please enter your email and password! ", Toast.LENGTH_SHORT).show()
            }
        }

    }
}