package com.example.projectwerk.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.projectwerk.data.local.SfeerAndFields
import com.example.projectwerk.data.local.SfeerFieldsEntity
import com.example.projectwerk.databinding.ListItemSfeerBinding
import com.example.projectwerk.models.Sfeer

class SfeerAdapter(private var sfeerClickListener: SfeerClickListener) : ListAdapter<SfeerAndFields, SfeerViewHolder>(
        SfeerDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SfeerViewHolder {
        return SfeerViewHolder(

                ListItemSfeerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(view: SfeerViewHolder, position: Int) {
        val sfeer = getItem(position)
        view.bindData(sfeer)
        view.itemView.setOnClickListener {
            sfeerClickListener.onSfeerClicked(sfeer)
        }
    }

}


private class SfeerDiffCallback : DiffUtil.ItemCallback<SfeerAndFields>() {
    override fun areItemsTheSame(oldItem: SfeerAndFields, newItem: SfeerAndFields): Boolean {
        return oldItem.fields?.sfeerid === newItem.fields?.sfeerid
    // return oldItem.fields?.sfeerid==newItem.fields?.sfeerid
    }

    override fun areContentsTheSame(oldItem: SfeerAndFields, newItem: SfeerAndFields): Boolean {
        return oldItem.equals(newItem)
      //  return oldItem.fields?.sfeerid==newItem.fields?.sfeerid
    }

}

class SfeerViewHolder(val binding: ListItemSfeerBinding) :
        RecyclerView.ViewHolder(binding.root) {
    fun bindData(sfeer: SfeerAndFields) {
        binding.sfeer = sfeer
    }

}


interface SfeerClickListener{
    fun onSfeerClicked(sfeer: SfeerAndFields)

}