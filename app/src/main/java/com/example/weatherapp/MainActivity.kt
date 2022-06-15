package com.example.weatherapp

import android.annotation.SuppressLint
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import kotlin.math.log
import kotlin.math.log10

class MainActivity : AppCompatActivity() {
    var weather=""

    //api id for url
    var api_id1="21f89a684c3e22f27ad089fb22490b20"

    private lateinit var textView: TextView
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     textView = findViewById(R.id.textview)
     fusedLocationClient= LocationServices.getFusedLocationProviderClient(this)
        Log.e("lat","onClick")

       //function to find the coordinates
       //of the location
        btn_weather.setOnClickListener{
            Log.e("lat","onClick")

       obtainlocation()
    }

    }
    @SuppressLint("MissingPermission")
    private fun obtainlocation(){
     Log.e("lat","function")
     //get the last location

        fusedLocationClient.lastLocation.addOnSuccessListener{location:Location?->
      //get the latitude and longitude
      //and create the http URL
     // weather=""
     }

    }

    fun getTemp(){
    //Instantiate the RequestQueue.
    val queue= Volley.newRequestQueue(this)
    val url:String=weather
    Log.e("lat",url)

    //Request a string response
    //from the provided URL.
    val stringReq= StringRequest(Request.Method.GET,url, { response ->
        Log.e("lat",response.toString())

        // get the JSON object
        val obj=JSONObject(response)

        // get the Array from obj of name

            val arr=obj.getJSONArray("data")
            Log.e("lat obj1",arr.toString())

        //get the JSON object from the
        //array at index position 0
        val obj2=arr.getJSONObject(0)
        Log.e("lat obj2",obj2.toString())

        //set the temperature and the city
        //name using getString() function
        textView.text=obj2.getString("temp")+"deg Celsius in"+obj2.getString("city_name")},
        //In case of any error
        { textView!!.text="That didn't work!"})
        queue.add(stringReq)
    }}
