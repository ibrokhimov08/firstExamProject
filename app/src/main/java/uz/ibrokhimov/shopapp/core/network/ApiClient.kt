package uz.ibrokhimov.shopapp.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun createContactService(): ProductService {
        return getRetrofit().create(ProductService::class.java)
    }

}