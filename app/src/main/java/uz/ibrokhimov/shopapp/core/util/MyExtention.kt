package uz.ibrokhimov.shopapp.core.util

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.myToast(text: String){

    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

}