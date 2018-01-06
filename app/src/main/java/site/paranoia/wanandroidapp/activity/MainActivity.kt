package site.paranoia.wanandroidapp.activity

import android.graphics.Color
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import kotlinx.android.synthetic.main.activity_main.*
import pers.victor.ext.addFragments
import pers.victor.ext.findColor
import pers.victor.ext.hideFragment
import pers.victor.ext.showFragment
import site.paranoia.common.base.TitleBarActivity
import site.paranoia.wanandroidapp.R
import site.paranoia.wanandroidapp.fragment.HomeFragment

class MainActivity : TitleBarActivity() ,NavigationView.OnNavigationItemSelectedListener{

    private var titles = listOf("首页" to R.drawable.ic_home_black_24dp,"知识体系" to R.drawable.ic_dashboard_black_24dp)

    private var fragments = listOf(HomeFragment(), HomeFragment())

    override fun initData() {
        addFragments(fragments,R.id.fl_main)
        fragments.forEachIndexed { index, fragment ->
            if (index == 0) {
                showFragment(fragment)
            }else {
                hideFragment(fragment)
            }
        }
    }

    override fun initWidget() {
        getToolBar().inflateMenu(R.menu.menu_main)
        getToolBar().title = getString(R.string.app_name)
        val toggle = ActionBarDrawerToggle(
                this@MainActivity, dl_main, getToolBar(), R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        dl_main.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)

        bottom_nav.addItems(titles.map { AHBottomNavigationItem(it.first,it.second) })
        bottom_nav.defaultBackgroundColor = Color.parseColor("#FEFEFE")
        bottom_nav.accentColor = findColor(R.color.colorPrimary)
        bottom_nav.inactiveColor = findColor(R.color.grey)
        bottom_nav.isForceTint = true
        bottom_nav.titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW
        bottom_nav.setOnTabSelectedListener { position, _ ->
            showFragmentAt(position)
            return@setOnTabSelectedListener true
        }
    }

    override fun bindLayout(): Int = R.layout.activity_main


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {

        }
        dl_main.closeDrawer(GravityCompat.START)
        return true
    }

    private fun showFragmentAt(pos: Int) {
        fragments.forEachIndexed { index, fragment ->
            if (index == pos) {
                showFragment(fragment)
            } else {
                hideFragment(fragment)
            }
        }
    }
}
