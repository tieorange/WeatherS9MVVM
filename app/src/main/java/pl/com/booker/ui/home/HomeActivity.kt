package pl.com.booker.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import pl.com.booker.R
import pl.com.booker.databinding.ActivityHomeBinding
import pl.com.booker.ui.base.BaseActivity

class HomeActivity
    : BaseActivity<
        ActivityHomeBinding,
        HomeMvvm.View,
        HomeMvvm.ViewModel>(),
      HomeMvvm.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setAndBindContentView(savedInstanceState, R.layout.activity_home)
        //        setSupportActionBar(binding.appBarContainer.toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
        }
        return true
    }

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }
}