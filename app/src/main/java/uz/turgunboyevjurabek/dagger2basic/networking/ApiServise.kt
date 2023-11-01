package uz.turgunboyevjurabek.dagger2basic.networking

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import uz.turgunboyevjurabek.dagger2basic.madels.ClientGet
import uz.turgunboyevjurabek.dagger2basic.madels.ClientPost

interface ApiService {

    @GET("clientlar/")
    suspend fun getClients():ArrayList<ClientGet>

    @POST("clientlar/")
    suspend fun postClient(@Body clientPost: ClientPost ):ClientPost


}