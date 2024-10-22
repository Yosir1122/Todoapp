package com.example.todoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.todoapp.databinding.ItemChildBinding
import com.example.todoapp.databinding.ItemParentBinding
import com.example.todoapp.models.MyTodo

class ExpandAdapter(private var titleList: ArrayList<String>, private var map: HashMap<String, ArrayList<MyTodo>>) : BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return map[titleList[groupPosition]]?.size!!
    }

    override fun getGroup(groupPosition: Int): Any {
        return titleList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return map[titleList[groupPosition]]?.get(childPosition)!!
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemParen = ItemParentBinding.inflate(LayoutInflater.from(parent?.context), parent, false)

        itemParen.tvParentName.text = titleList[groupPosition]

        return itemParen.root
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemChild = ItemChildBinding.inflate(LayoutInflater.from(parent?.context), parent, false)

        itemChild.tvChildName.text = map[titleList[groupPosition]]?.get(childPosition)!!.name
        return itemChild.root
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}