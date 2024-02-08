package com.example.assignmentapp.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmentapp.R
import com.example.assignmentapp.databinding.SignupActivityBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity:AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= SignupActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signUpButton.setOnClickListener {
            val userName=binding.userName.text.toString()
            val password=binding.password.text.toString()
            val passwordPattern = Regex("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?]).{7,}\$")
            if(userName.length>=10 && passwordPattern.matches(password))
            {

            firebaseAuth.createUserWithEmailAndPassword(userName,password).addOnCompleteListener{
                if (it.isSuccessful) {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Snackbar.make(
                        binding.root,
                        "enter valid email",
                        Snackbar.LENGTH_LONG
                    ).show()
                    binding.userName.text.clear()

                }
            }
            }
            else{
                binding.userName.text.clear()
                binding.password.text.clear()
                Snackbar.make(
                    binding.root,
                    getString(R.string.password_validation_error),
                    Snackbar.LENGTH_LONG
                ).show()

            }
        }
        binding.signInTextview.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
    }
    override fun onStart() {
        super.onStart()

        if (firebaseAuth.currentUser != null) {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }

}

