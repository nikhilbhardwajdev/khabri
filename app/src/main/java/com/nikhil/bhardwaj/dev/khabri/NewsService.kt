package com.nikhil.bhardwaj.dev.khabri

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val Base_Url = "https://newsapi.org/"
const val Api_key =  "a0334704aa94473c8fadfe263d8684d2"

 interface NewsInterface{

     @GET(value = "v2/top-headlines?apiKey=$Api_key")
     fun gethedlines(@Query("country")country:String,@Query("page")page:Int) : Call<News>


 }

object NewsService {
   val  newsinstance: NewsInterface
    init {
        val retrofit= Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsinstance = retrofit.create(NewsInterface::class.java)


    }


}