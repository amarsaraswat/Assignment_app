package com.example.assignmentapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.assignmentapp.R
import com.example.assignmentapp.databinding.ActivityDashboardBinding
import com.example.assignmentapp.viewmodels.DashboardViewModel


class DashboardActivity : AppCompatActivity() {

    private lateinit var viewModel: DashboardViewModel
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.viewModel = viewModel

        binding.addPersonDataBtn.setOnClickListener {

            val name = binding.personName.text.toString()
            val age = binding.personAge.text.toString()
            val city = binding.personCity.text.toString()
            if (isFieldEmptyOrWhitespace(name)) {
            binding.personName.error = getString(R.string.please_enter_your_name)
        } else if (isFieldEmptyOrWhitespace(age)) {
            binding.personAge.error = getString(R.string.please_enter_your_age)
        } else if (isFieldEmptyOrWhitespace(city)) {
            binding.personCity.error = getString(R.string.please_enter_your_city)
        } else {
            viewModel.saveDataToRealmDb(name, age, city)
            clearInputFields()
        }
        }
        binding.readDataBtn.setOnClickListener {
            val i = Intent(this@DashboardActivity, PersonDataActivity::class.java)
            startActivity(i)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
    }
    private fun isFieldEmptyOrWhitespace(value: CharSequence?): Boolean {
        return TextUtils.isEmpty(value) || value?.startsWith(" ") == true
    }

    private fun clearInputFields() {
        binding.personName.setText("")
        binding.personAge.setText("")
        binding.personCity.setText("")
    }

}