package uz.turgunboyevjurabek.dagger2basic.repozitory

import uz.turgunboyevjurabek.dagger2basic.networking.ApiService
import javax.inject.Inject

class Repozitory @Inject constructor(private val apiService: ApiService) {
    suspend fun getClients()=apiService.getClients()

}