package com.nikhil.bhardwaj.dev.khabri

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(val context: Context, val articles: List<Article>) :
    RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.newsTitle.text = article.title
        holder.newsdescription.text = article.description
        Glide.with(context).load(article.urlToImage).into(holder.newsimage)
        holder.itemView.setOnClickListener {

            Toast.makeText(context, article.title, Toast.LENGTH_SHORT).show()
            val intent = Intent(context, ChromeActivity::class.java)
            intent.putExtra("Url", article.url)
            context.startActivity(intent)


        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var newsimage = itemView.findViewById<ImageView>(R.id.newsimage)
        var newsTitle = itemView.findViewById<TextView>(R.id.newstitle)
        var newsdescription = itemView.findViewById<TextView>(R.id.newsdescription)

    }
}