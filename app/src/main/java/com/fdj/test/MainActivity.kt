package com.fdj.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fdj.test.teams.TeamsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, TeamsFragment.newInstance())
            .commit()
    }
}
