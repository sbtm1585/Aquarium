package org.hyperskill.aquarium

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var pagerAdapter: ViewPagerAdapter
    private lateinit var image: List<String>
    private lateinit var name: List<String>
    private lateinit var description: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager2 = findViewById<ViewPager2>(R.id.viewpager2)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        image = intent?.getStringArrayListExtra("imageAnimals") ?: defaultImages
        name = intent?.getStringArrayListExtra("nameAnimals") ?: defaultNames
        description = intent?.getStringArrayListExtra("descriptionAnimals") ?: defaultDescriptions

        pagerAdapter = ViewPagerAdapter(image, name, description)
        viewPager2.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = name[position]
        }.attach()
    }
}


