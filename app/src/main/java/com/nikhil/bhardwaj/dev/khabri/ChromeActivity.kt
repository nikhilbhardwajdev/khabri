package com.nikhil.bhardwaj.dev.khabri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_chrome.*

class ChromeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chrome)
        val url = intent.getStringExtra("Url")
        if(url!=null){
            chromewebview.settings.javaScriptEnabled=true
            chromewebview.settings.userAgentString = "Mozilla/5.0 (Linux; <Android Version>; <Build Tag etc.>) AppleWebKit/<WebKit Rev> (KHTML, like Gecko) Chrome/<Chrome Rev> Mobile Safari/<WebKit Rev>"
            chromewebview.webViewClient = object : WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    progressBar.visibility= View.GONE
                    chromewebview.visibility= View.VISIBLE
                }
            }
            chromewebview.loadUrl(url)

        }
    }
}
