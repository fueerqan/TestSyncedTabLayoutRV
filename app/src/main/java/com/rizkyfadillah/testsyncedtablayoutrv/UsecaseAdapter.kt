package com.rizkyfadillah.testsyncedtablayoutrv

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.item_usecase.view.*

/**
 * Created by Rizky on 23/08/18.
 */

class UsecaseAdapter(val datas: List<Visitable>) : RecyclerView.Adapter<UsecaseAdapter.UsecaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsecaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return UsecaseViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        if (datas.get(position) is UsecaseViewModel) {
            return R.layout.item_usecase
        }
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(usecaseViewHolder: UsecaseViewHolder, position: Int) {
        usecaseViewHolder.bind(datas.get(position), datas.size)
    }

    class UsecaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(element: Visitable, size: Int) {
            if (adapterPosition == size-1) {
                val layout = itemView
                val params = layout.layoutParams
                params.height = ViewGroup.LayoutParams.MATCH_PARENT
                layout.layoutParams = params
            }

            val data = element as UsecaseViewModel
            itemView.title.text = data.name
            itemView.recyclerview_category.layoutManager = NonScrollabelGridLayoutManager(itemView.context, 4)
            itemView.recyclerview_category.adapter = CategoryAdapter(data.categories)
            (itemView.recyclerview_category.adapter as CategoryAdapter).notifyDataSetChanged()
        }

    }

}