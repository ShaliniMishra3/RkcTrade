
import com.example.tradeapp.PropertyRequest
import com.example.tradeapp.PropertyResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PropertyApiService {

    @POST("UserApi/GetProperty")
    fun getProperties(@Body body: PropertyRequest): Call<PropertyResponse>

 //   fun getProperties(@Body body: Map<String, String>): Call<PropertyResponse>
}