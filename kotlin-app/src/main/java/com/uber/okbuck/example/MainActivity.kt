package com.uber.okbuck.example

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.uber.okbuck.example.sqldelightmodel.GithubRepo
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var analytics: Analytics

    private val fab by lazy { findViewById<FloatingActionButton>(R.id.fab) }
    private val toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            analytics.sendAnalyticsEvent("FAB Clicked")
        }

        val repo = GithubRepo(100, "OkBuck", "auto buck")
        Toast.makeText(this, repo.name + ": " + repo.description, Toast.LENGTH_SHORT).show()
    }

    companion object {
      internal const val TEST_INTERNAL = ""
    }
}
