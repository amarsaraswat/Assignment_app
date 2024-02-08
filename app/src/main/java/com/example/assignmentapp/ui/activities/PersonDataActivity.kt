package com.example.assignmentapp.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmentapp.R
import com.example.assignmentapp.databinding.PersonDataBinding
import com.example.assignmentapp.model.Employee
import com.example.assignmentapp.model.Person
import com.example.assignmentapp.ui.adapters.PersonListAdapter
import com.example.assignmentapp.viewmodels.PersonDataViewModel


class PersonDataActivity:AppCompatActivity() {


    private lateinit var viewModel: PersonDataViewModel
    private var personListAdapter: PersonListAdapter? = null
    private  var dataList:List<Employee> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[PersonDataViewModel::class.java]
        val binding= PersonDataBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        binding.viewModel=viewModel
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        dataList=viewModel.getAllUsers()
        binding.noDataFound.visibility = if (dataList.isEmpty()) View.VISIBLE else View.GONE
        personListAdapter= PersonListAdapter(this)
        binding.recyclerView.adapter=personListAdapter
        personListAdapter!!.setData(dataList)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.name -> {
                dataList = dataList.sortedBy { it.name!!.lowercase() }
               }
            R.id.age -> {
                dataList = dataList.sortedBy { it.age }
                }
            R.id.city -> {
                dataList = dataList.sortedBy { it.city!!.lowercase()}
            }
        }
        personListAdapter!!.setData(dataList)
        return super.onOptionsItemSelected(item)
    }
}

