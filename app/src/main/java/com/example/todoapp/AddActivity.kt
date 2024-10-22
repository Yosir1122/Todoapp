package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp.adapter.SpinnerAdapter
import com.example.todoapp.databinding.ActivityAddBinding
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.models.MySpinner
import com.example.todoapp.models.MyTodo
import com.example.todoapp.utils.MySharedPreference

class AddActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddBinding.inflate(layoutInflater) }
    private lateinit var spinnerAdapter: SpinnerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            val spinerList = arrayListOf(
                MySpinner("Urget", R.drawable.red_flag),
                MySpinner("Hight", R.drawable.yellow_flag),
                MySpinner("Normal", R.drawable.blue_flag),
                MySpinner("Low", R.drawable.gray_flag)
            )
            spinnerAdapter = SpinnerAdapter(spinerList)
            mySpinner.adapter = spinnerAdapter
            save.setOnClickListener {
                if (edtName.text.isNotBlank() && description.text.isNotBlank() && data.text.isNotBlank() && dedline.text.isNotBlank()) {
                    val todo = MyTodo(
                        edtName.text.toString(),
                        description.text.toString(),
                        mySpinner.selectedItem as MySpinner,
                        "open",
                        data.text.toString(),
                        dedline.text.toString()
                    )
                    MySharedPreference.init(this@AddActivity)
                    val list = MySharedPreference.list
                    list.add(todo)
                    MySharedPreference.list = list
                    Toast.makeText(this@AddActivity, "saqlandi", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this@AddActivity, "Malumot tolig kiriting", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}