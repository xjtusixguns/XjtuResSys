package com.example.res

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.res.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Main2Activity : AppCompatActivity(), HomeFragment.freshData {
    public var order = Order();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

//    override fun freshData(data: Food?) {
//    }


//    interface freshData {
//        fun freshData(data: Food?)
//    }

//    private var fresh: freshData? = null
//
//    public fun doFreshData(doFreshData: freshData){
//        fresh = doFreshData
//    }
    override fun freshData(data: Food?) {
        val application: MyApplication = applicationContext as MyApplication
        application.addData(data)
//    val temp = application.data
//    for (i in temp) {
//        Toast.makeText(this, i.name, Toast.LENGTH_SHORT).show()
//    }
    }


}
