package com.example.lianxi7_18.adapter

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.lianxi7_18.entity.FoodEntity
import com.example.week001_work.R

class FoodAdapter(layoutResId: Int, data: List<FoodEntity.DataBean>?) :
    BaseQuickAdapter<FoodEntity.DataBean, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder, item: FoodEntity.DataBean) {
        helper.setText(R.id.tv, item.title)
        Glide.with(mContext)
            .load(item.pic)
//            .transform(CircleCrop())
            .into(helper.getView(R.id.image))
    }
}

