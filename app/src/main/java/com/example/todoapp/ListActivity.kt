package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.Toast
import com.example.todoapp.adapter.ExpandAdapter
import com.example.todoapp.databinding.ActivityListBinding
import com.example.todoapp.models.MyTodo
import com.example.todoapp.utils.MySharedPreference

class ListActivity : AppCompatActivity() {
    private val binding by lazy { ActivityListBinding.inflate(layoutInflater) }
    private lateinit var expandAdapter: ExpandAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        onResume()
    }

    override fun onResume() {
        super.onResume()
        val openList = ArrayList<MyTodo>()
        val developmentList = ArrayList<MyTodo>()
        val uploadingList = ArrayList<MyTodo>()
        val rejectedList = ArrayList<MyTodo>()
        val closedList = ArrayList<MyTodo>()
        try {
            MySharedPreference.init(this)
            val sharedList = MySharedPreference.list
            for (i in sharedList) {
                if (i.checkedList == "open") {
                    openList.add(i)
                }
                if (i.checkedList == "development") {
                    developmentList.add(i)
                }
                if (i.checkedList == "uploading") {
                    uploadingList.add(i)
                }
                if (i.checkedList == "rejected") {
                    rejectedList.add(i)
                }
                if (i.checkedList == "closed") {
                    closedList.add(i)
                }
            }
            val expandList = arrayListOf("Open", "Development", "Uploading", "Rejected", "Closed")
            val map = HashMap<String, ArrayList<MyTodo>>()

            map[expandList[0]] = openList
            map[expandList[1]] = developmentList
            map[expandList[2]] = uploadingList
            map[expandList[3]] = rejectedList
            map[expandList[4]] = closedList
            expandAdapter = ExpandAdapter(expandList, map)
            binding.myExpand.setAdapter(expandAdapter)
        } catch (e: Exception) {
            Toast.makeText(this, "Hato!!", Toast.LENGTH_SHORT).show()
        }
        binding.myExpand.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            val intent = Intent(this, InfoActivity::class.java)
            intent.putExtra("groupPosition", groupPosition)
            intent.putExtra("childPosition", childPosition)
            startActivity(intent)
            true
        }
    }
}