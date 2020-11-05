package com.nikhil.bhardwaj.dev.khabri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {



    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getnews()
    }

    private fun getnews() {
        val news = NewsService.newsinstance.gethedlines("in", 1)
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {
                    Log.d("newsupdate", news.toString())
                    adapter = NewsAdapter(this@MainActivity, news.articles)
                    newslist.adapter = adapter
                    newslist.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {

                Log.d("newsupdate", "Error in news ", t)
            }
        })


    }

}
