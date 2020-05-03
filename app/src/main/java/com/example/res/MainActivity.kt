package com.example.res

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val foodList = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //App标题居中

//        initFoods() //初始化食物列表
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = foodAdapter(foodList)
        recyclerView.adapter = adapter
    }

//    private fun initFoods(){
//        repeat(1){
//            foodList.add(Food("苹果", R.drawable.apple_pic,1))
//            foodList.add(Food("香蕉", R.drawable.banana_pic,1))
//            foodList.add(Food("樱桃", R.drawable.cherry_pic))
//            foodList.add(Food("葡萄", R.drawable.grape_pic))
//
//            foodList.add(Food("芒果", R.drawable.mango_pic))
//            foodList.add(Food("橙子", R.drawable.orange_pic))
//            foodList.add(Food("梨子", R.drawable.pear_pic))
//            foodList.add(Food("菠萝", R.drawable.pineapple_pic))
//
//            foodList.add(Food("草莓", R.drawable.strawberry_pic))
//            foodList.add(Food("哈密瓜", R.drawable.watermelon_pic))
//        }
//    }
}
