package com.aetherized.view.pondpediaview.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aetherized.view.pondpediaview.R
import com.aetherized.view.pondpediaview.data.local.entity.PondEntity
import com.aetherized.view.pondpediaview.ui.authenticated.home.pond.details.PondDetailsFragment
import com.aetherized.view.pondpediaview.utils.helper.Constants
import com.aetherized.view.pondpediaview.utils.helper.PondsDiffCallback
import com.bumptech.glide.Glide

class PondAdapter(private var ponds: ArrayList<PondEntity>) :
    RecyclerView.Adapter<PondAdapter.ViewHolder>() {


    fun addPonds(ponds: List<PondEntity>) {
        val diffCallback = PondsDiffCallback(this.ponds, ponds)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.ponds.clear()
        this.ponds.addAll(ponds)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.grid_layout_list_item, viewGroup, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val pond = ponds[position]

        viewHolder.bind(pond)
    }

    override fun getItemCount(): Int = ponds.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val pondImage: ImageView = itemView.findViewById(R.id.pond_image)
        private val pondName: TextView = itemView.findViewById(R.id.pond_name)
        private val pondFish: TextView = itemView.findViewById(R.id.pond_fish)

        fun bind(pond: PondEntity) {
            Glide.with(itemView).load(R.drawable.floating_island_11563055345).into(pondImage)
            pondName.text = pond.pondName
            pondFish.text = pond.pondFish.name
            itemView.setOnClickListener {
                val bundle = Bundle().apply {
                    putParcelable(Constants.PARCELABLE_KEY, pond)
                }

                val pondDetailsFragment = PondDetailsFragment().apply {
                    arguments = bundle
                }

                val transaction =
                    (itemView.context as AppCompatActivity).supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, pondDetailsFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
    }
}