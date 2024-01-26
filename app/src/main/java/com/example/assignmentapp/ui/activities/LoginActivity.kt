package com.example.assignmentapp.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmentapp.databinding.LoginActivityBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = LoginActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.sumbitButton.setOnClickListener {
            val userName = binding.userName.text.toString()
            val password = binding.password.text.toString()

            if (userName.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, DashboardActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        binding.password.text.clear()
                        Snackbar.make(binding.root,"Invalid password",Snackbar.LENGTH_LONG).show()

                    }
                }
            } else {
                Snackbar.make(binding.root,"Empty Fields Are not Allowed !!",Snackbar.LENGTH_LONG).show()
            }

        }
        binding.signUpActivity.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true);
    }


}