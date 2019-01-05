package br.com.gleara

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import com.google.gson.GsonBuilder

interface AlphaVantageService {
    companion object {
        const val GQ = "GLOBAL_QUOTE"
        const val URL = "https://www.alphavantage.co/"
        const val API_KEY = ""
    }
    @GET("query")
    fun getStockInfo(@Query("symbol") symbol: String, @Query("function") function:String = GQ,
                     @Query("apikey") k:String = API_KEY): Call<Stock>

}

object ServiceBuilder {
    fun create(): AlphaVantageService {
        val gson = GsonBuilder()
                .setLenient()
                .create()
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(AlphaVantageService.URL)
                .build()
        return retrofit.create(AlphaVantageService::class.java)
    }
}
