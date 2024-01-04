package uz.ibrokhimov.shopapp.core.network

import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("/product")
    fun getAllProduct(): Call<List<ProductResponse>>

}