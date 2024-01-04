package uz.ibrokhimov.shopapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.ibrokhimov.shopapp.core.adapter.ProductAdapter
import uz.ibrokhimov.shopapp.core.network.ApiClient
import uz.ibrokhimov.shopapp.core.util.myToast
import uz.ibrokhimov.shopapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { ProductAdapter() }
    private val api = ApiClient.createContactService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadAdapter()
        loadView()

    }

    private fun loadView() {

        api.getAllProduct().enqueue(object : Callback<List<ProductResponse>> {
            override fun onResponse(
                call: Call<List<ProductResponse>>,
                response: Response<List<ProductResponse>>
            ) {

                if (response.isSuccessful) {

                    myToast("Success")
                    adapter.setData(response.body()!!)

                } else {
                    myToast("Products not found!")

                }

            }

            override fun onFailure(call: Call<List<ProductResponse>>, t: Throwable) {

                myToast("Fatal")

            }


        })

    }

    private fun loadAdapter() {

        binding.rvProduct.adapter = adapter
        adapter.setData()

    }


}