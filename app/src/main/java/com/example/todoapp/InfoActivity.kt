package com.example.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.databinding.ActivityInfoBinding
import com.example.todoapp.models.MyTodo
import com.example.todoapp.utils.MySharedPreference

class InfoActivity : AppCompatActivity() {
    private val binding by lazy { ActivityInfoBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var openList = ArrayList<MyTodo>()
        var developmentList = ArrayList<MyTodo>()
        var uploadingList = ArrayList<MyTodo>()
        var rejectedList = ArrayList<MyTodo>()
        var closedList = ArrayList<MyTodo>()

        MySharedPreference.init(this)
        var sharedList = MySharedPreference.list
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
        val groupPosition = intent.getIntExtra("groupPosition", -1)
        val childPosition = intent.getIntExtra("childPosition", -1)
        binding.apply {
            when (groupPosition) {
                0 ->{
                    tvTitle.text = openList[childPosition].name
                    tvCreate.text = openList[childPosition].name
                    tvDescription.text = openList[childPosition].description
                    tvdedline.text = openList[childPosition].dedline
                    tvSpinner.text = openList[childPosition].degree.name
                    imgSpinner.setImageResource(openList[childPosition].degree.flag)
                    radioOpen.isChecked = true
                }
                1 ->{
                    tvTitle.text = developmentList[childPosition].name
                    tvCreate.text = developmentList[childPosition].name
                    tvDescription.text = developmentList[childPosition].description
                    tvdedline.text = developmentList[childPosition].dedline
                    tvSpinner.text = developmentList[childPosition].degree.name
                    imgSpinner.setImageResource(developmentList[childPosition].degree.flag)
                    radioDevelopment.isChecked = true
                }
                2 ->{
                    tvTitle.text = uploadingList[childPosition].name
                    tvCreate.text = uploadingList[childPosition].name
                    tvDescription.text = uploadingList[childPosition].description
                    tvdedline.text = uploadingList[childPosition].dedline
                    tvSpinner.text = uploadingList[childPosition].degree.name
                    imgSpinner.setImageResource(uploadingList[childPosition].degree.flag)
                    radioUploading.isChecked = true
                }
                3 ->{
                    tvTitle.text = rejectedList[childPosition].name
                    tvCreate.text = rejectedList[childPosition].name
                    tvDescription.text = rejectedList[childPosition].description
                    tvdedline.text = rejectedList[childPosition].dedline
                    tvSpinner.text = rejectedList[childPosition].degree.name
                    imgSpinner.setImageResource(rejectedList[childPosition].degree.flag)
                    radioReject.isChecked = true
                }
                4 ->{
                    tvTitle.text = closedList[childPosition].name
                    tvCreate.text = closedList[childPosition].name
                    tvDescription.text = closedList[childPosition].description
                    tvdedline.text = closedList[childPosition].dedline
                    tvSpinner.text = closedList[childPosition].degree.name
                    imgSpinner.setImageResource(closedList[childPosition].degree.flag)
                    radioClosed.isChecked = true
                }
            }
            btnOk.setOnClickListener {
                for (i in sharedList.indices){
                    when(groupPosition){
                        0-> {
                            if (radioOpen.isChecked) {
                                finish()
                            } else if (radioDevelopment.isChecked && sharedList[i] == openList[childPosition]) {
                                sharedList[i].checkedList = "development"
                                MySharedPreference.list = sharedList
                                finish()
                            } else if (radioUploading.isChecked && sharedList[i] == openList[childPosition]) {
                                sharedList[i].checkedList = "uploading"
                                MySharedPreference.list = sharedList
                                finish()
                            } else if (radioReject.isChecked && sharedList[i] == openList[childPosition]) {
                                sharedList[i].checkedList = "rejected"
                                MySharedPreference.list = sharedList
                                finish()
                            } else if (radioClosed.isChecked && sharedList[i] == openList[childPosition]) {
                                sharedList[i].checkedList = "closed"
                                MySharedPreference.list = sharedList
                                finish()
                            }
                        }
                        1->{
                            if (radioOpen.isChecked && sharedList[i]==developmentList[childPosition]) {
                                sharedList[i].checkedList = "open"
                                MySharedPreference.list = sharedList
                                finish()
                            }else if (radioDevelopment.isChecked) {
                                finish()
                            } else if (radioUploading.isChecked && sharedList[i] == developmentList[childPosition]) {
                                sharedList[i].checkedList = "uploading"
                                MySharedPreference.list = sharedList
                                finish()
                            } else if (radioReject.isChecked && sharedList[i] == developmentList[childPosition]) {
                                sharedList[i].checkedList = "rejected"
                                MySharedPreference.list = sharedList
                                finish()
                            } else if (radioClosed.isChecked && sharedList[i] == developmentList[childPosition]) {
                                sharedList[i].checkedList = "closed"
                                MySharedPreference.list = sharedList
                                finish()
                            }
                        }
                        2-> {
                            if (radioOpen.isChecked && sharedList[i] == uploadingList[childPosition]) {
                                sharedList[i].checkedList = "open"
                                MySharedPreference.list = sharedList
                                finish()
                            } else if (radioDevelopment.isChecked && sharedList[i]==uploadingList[childPosition]) {
                                sharedList[i].checkedList="development"
                                MySharedPreference.list=sharedList
                                finish()
                            } else if (radioUploading.isChecked) {
                                finish()
                            } else if (radioReject.isChecked && sharedList[i] == uploadingList[childPosition]) {
                                sharedList[i].checkedList = "rejected"
                                MySharedPreference.list = sharedList
                                finish()
                            } else if (radioClosed.isChecked && sharedList[i] == uploadingList[childPosition]) {
                                sharedList[i].checkedList = "closed"
                                MySharedPreference.list = sharedList
                                finish()
                            }
                        }
                        3-> {
                            if (radioOpen.isChecked && sharedList[i] == rejectedList[childPosition]) {
                                sharedList[i].checkedList = "open"
                                MySharedPreference.list = sharedList
                                finish()
                            } else if (radioDevelopment.isChecked && sharedList[i]==rejectedList[childPosition]) {
                                sharedList[i].checkedList="development"
                                MySharedPreference.list=sharedList
                                finish()
                            } else if (radioUploading.isChecked && sharedList[i] == rejectedList[childPosition]) {
                                sharedList[i].checkedList = "uploading"
                                MySharedPreference.list = sharedList
                                finish()
                            } else if (radioReject.isChecked) {
                                finish()
                            } else if (radioClosed.isChecked && sharedList[i] == rejectedList[childPosition]) {
                                sharedList[i].checkedList = "closed"
                                MySharedPreference.list = sharedList
                                finish()
                            }
                        }
                        4-> {
                            if (radioOpen.isChecked && sharedList[i] == closedList[childPosition]) {
                                sharedList[i].checkedList = "open"
                                MySharedPreference.list = sharedList
                                finish()
                            } else if (radioDevelopment.isChecked && sharedList[i]==closedList[childPosition]) {
                                sharedList[i].checkedList="development"
                                MySharedPreference.list=sharedList
                                finish()
                            } else if (radioUploading.isChecked && sharedList[i] == closedList[childPosition]) {
                                sharedList[i].checkedList = "uploading"
                                MySharedPreference.list = sharedList
                                finish()
                            }  else if (radioReject.isChecked && sharedList[i] == closedList[childPosition]) {
                                sharedList[i].checkedList = "rejected"
                                MySharedPreference.list = sharedList
                                finish()
                            } else if (radioClosed.isChecked) {
                                finish()
                            }
                        }
                    }
                }
            }
        }
    }
}