package uz.turgunboyevjurabek.dagger2basic

import android.app.Application
import uz.turgunboyevjurabek.dagger2basic.di.companent.ApplicationComponent
import uz.turgunboyevjurabek.dagger2basic.di.companent.DaggerApplicationComponent

class App:Application() {

    companion object{
         lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent= DaggerApplicationComponent
            .builder()
            .build()
    }
}