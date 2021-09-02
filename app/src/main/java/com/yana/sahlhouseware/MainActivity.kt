package com.yana.sahlhouseware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.yana.sahlhouseware.feed.FeedProduct
import com.yana.sahlhouseware.news.News
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.coordinator_layout, Home()).commit()

        bottom.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->{
                    supportFragmentManager.beginTransaction().replace(R.id.coordinator_layout, Home()).commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_product->{
                    supportFragmentManager.beginTransaction().replace(R.id.coordinator_layout, FeedProduct()).commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_news->{
                    supportFragmentManager.beginTransaction().replace(R.id.coordinator_layout, News()).commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_profile->{
                    supportFragmentManager.beginTransaction().replace(R.id.coordinator_layout, Profile()).commit()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
        return true
    }

}