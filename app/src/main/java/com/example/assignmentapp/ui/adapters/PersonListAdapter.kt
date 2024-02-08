package com.example.assignmentapp.ui.adapters
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentapp.databinding.ItemPersonBinding
import com.example.assignmentapp.model.Employee
import com.example.assignmentapp.model.Person

class PersonListAdapter( private val context: Context) :
    RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {
    private lateinit var personList: List<Employee>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modal = personList[position]
        holder.bind(modal)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    inner class ViewHolder(private val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(modal: Employee) {
            binding.apply {
                binding.nameTextView.text = modal.name
                    binding.ageTextView.text = modal.age.toString()
                binding.cityTextView.text = modal.city

            }
        }
    }
    fun setData(newDataList: List<Employee>) {
        personList = newDataList
        notifyDataSetChanged()
    }
}
