package uz.turgunboyevjurabek.dagger2basic.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.turgunboyevjurabek.dagger2basic.networking.ApiService
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideBaseUrl():String="https://api111.pythonanywhere.com/"

    @Provides
    @Singleton
    fun provideConvertor():GsonConverterFactory=GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl:String,gsonConvertor:GsonConverterFactory):Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConvertor)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }

}