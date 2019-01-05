package br.com.gleara

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Stock(

        @SerializedName("Global Quote")
        val info: Info

)

data class Info(

        @SerializedName("01. symbol")
        @Expose
        val symbol: String,


        @SerializedName("05. price")
        @Expose
        val price: String

)
