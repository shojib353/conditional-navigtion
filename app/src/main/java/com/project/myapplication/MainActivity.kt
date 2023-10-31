package com.project.myapplication


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.project.myapplication.MainFragmentDirections
import com.project.myapplication.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var appBarConfig: AppBarConfiguration

    var hasCompletedWelcome: Boolean
        get() = getPreferences(MODE_PRIVATE).getBoolean("hasCompletedWelcome", false)
        set(value) = getPreferences(MODE_PRIVATE).edit()
            .putBoolean("hasCompletedWelcome", value)
            .apply()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navController = findNavController()
        appBarConfig = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfig)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.welcomeFragment) {
                supportActionBar?.hide()
            } else {
                supportActionBar?.show()
            }
        }

        if (!hasCompletedWelcome) {
            //navController.navigate(R.id.welcomeFragment)
            //navigateToWelcome()
            resetStartDestination()
        }
    }

    private fun navigateToWelcome() {
        //findNavController().navigate(MainFragmentDirections.actionMainFragmentToWelcomeFragment())
       findNavController().navigate(R.id.action_mainFragment_to_welcomeFragment)
    }

    private fun resetStartDestination() {
        val navController = findNavController()
        val graph = navController.graph
        graph.setStartDestination(R.id.welcomeFragment)

        navController.graph = graph
    }

    fun restart() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun findNavController(): NavController {
        return findNavController(R.id.nav_host_fragment)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController().navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }
}