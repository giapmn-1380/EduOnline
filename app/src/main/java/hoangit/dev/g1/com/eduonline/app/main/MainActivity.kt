package hoangit.dev.g1.com.eduonline.app.main

import android.content.Intent
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.view.MenuItem
import android.view.View
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.adapter.MainPagerAdapter
import hoangit.dev.g1.com.eduonline.app.search.SearchActivity
import hoangit.dev.g1.com.eduonline.base.BaseActivity
import hoangit.dev.g1.com.eduonline.extension.startActivityWithTransition
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.tool_bar.*

class MainActivity : BaseActivity(),
    NavigationView.OnNavigationItemSelectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener,
    View.OnClickListener {

    val arrItemNav = arrayOf(R.id.bottom_home, R.id.bottom_notification, R.id.bottom_my_course, R.id.bottom_setting)

    override fun getLayoutID(): Int {
        return R.layout.activity_main
    }

    override fun onCreateActivity() {
        initViews()

    }

    private fun initViews() {

        val mainPagerAdapter: MainPagerAdapter = MainPagerAdapter(supportFragmentManager)
        view_page_main.adapter = mainPagerAdapter
        view_page_main.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                bottom_navigation.selectedItemId = arrItemNav[position]
            }

            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }
        })

        imv_menu.setOnClickListener(this)
        imv_search.setOnClickListener(this)
        nav_view.setNavigationItemSelectedListener(this)
        bottom_navigation.setOnNavigationItemSelectedListener(this)
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.imv_menu -> {
                drawer_layout.openDrawer(GravityCompat.START)
            }
            R.id.imv_search -> {
                val intent: Intent = Intent(this@MainActivity, SearchActivity::class.java)
                startActivityWithTransition(intent)
            }
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }

            //Bottom Nav
            R.id.bottom_home -> {
                view_page_main.currentItem = 0
            }
            R.id.bottom_notification -> {
                view_page_main.currentItem = 1
            }
            R.id.bottom_my_course -> {
                view_page_main.currentItem = 2
            }
            R.id.bottom_setting -> {
                view_page_main.currentItem = 3
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
