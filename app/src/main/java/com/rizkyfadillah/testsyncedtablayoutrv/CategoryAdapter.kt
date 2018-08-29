package com.rizkyfadillah.testsyncedtablayoutrv

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_category.view.*

/**
 * Created by Rizky on 23/08/18.
 */
class CategoryAdapter(val categories: List<CategoryViewModel>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_category
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(categoryViewHolder: CategoryViewHolder, position: Int) {
        categoryViewHolder.bind(categories.get(position))
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(categoryViewModel: CategoryViewModel) {
            Glide.with(itemView).load(categoryViewModel.icon).into(itemView.imageview)
            itemView.text_category_name.text = categoryViewModel.categoryName
        }

    }

}