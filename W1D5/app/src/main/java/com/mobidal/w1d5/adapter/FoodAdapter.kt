package com.mobidal.w1d5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobidal.w1d5.R
import com.mobidal.w1d5.module.Food
import kotlinx.android.synthetic.main.item_food.view.*

class FoodAdapter(private val mContext: Context, private var mList: List<Food>,
                  var mOnFoodClickListener: OnFoodClickListener):
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemView = LayoutInflater.from(mContext)
            .inflate(R.layout.item_food, parent, false)

        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class FoodViewHolder: RecyclerView.ViewHolder, View.OnClickListener {

        constructor(itemView: View) : super(itemView) {
            itemView.setOnClickListener(this)
        }

        fun bind(food: Food) {
            itemView.iv_picture.setImageResource(food.pictureResId)
            itemView.tv_name.text = food.name
        }

        override fun onClick(view: View?) {
            mOnFoodClickListener.onFoodClicked(mList[adapterPosition])
        }

    }

    interface OnFoodClickListener {
        fun onFoodClicked(food: Food)
    }

}