package com.aetherized.view.pondpediaview.utils.helper

import androidx.recyclerview.widget.DiffUtil
import com.aetherized.view.pondpediaview.data.local.entity.PondEntity

class PondsDiffCallback (private val mOldList: List<PondEntity>, private val mNewPondList: List<PondEntity>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldList.size
    }

    override fun getNewListSize(): Int {
        return mNewPondList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldList[oldItemPosition].id == mNewPondList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = mOldList[oldItemPosition]
        val newEmployee = mNewPondList[newItemPosition]
        return oldEmployee.pondName == newEmployee.pondName
    }
}