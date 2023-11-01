package uz.turgunboyevjurabek.dagger2basic

import android.app.Application
import uz.turgunboyevjurabek.dagger2basic.di.companent.ApplicationComponent
import uz.turgunboyevjurabek.dagger2basic.di.DaggerApplicationComponent

class App:Application() {

    companion object{
        private lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent= DaggerApplicationComponent
            .builder()
            .build()
    }
}