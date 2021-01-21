package com.worklin.hiltdaggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.worklin.hiltdaggerhilt.data.DataSource
import com.worklin.hiltdaggerhilt.domain.RepoImpl
import com.worklin.hiltdaggerhilt.ui.viewmodel.MainViewModel
import com.worklin.hiltdaggerhilt.ui.viewmodel.VMFactory

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this , navController)

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}