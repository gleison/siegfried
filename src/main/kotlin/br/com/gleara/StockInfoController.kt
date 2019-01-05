package br.com.gleara

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class StockInfoController {

    val service = ServiceBuilder.create()

    @GetMapping("/stock")
    fun recuperar(@RequestParam(value = "symbol") symbol: String): Stock? {
        val call = service.getStockInfo("$symbol.SA")
        val response = call.execute()
        return response.body();
    }
}
