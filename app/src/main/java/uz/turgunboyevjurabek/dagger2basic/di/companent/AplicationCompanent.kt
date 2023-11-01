package uz.turgunboyevjurabek.dagger2basic.di.companent

import dagger.Component
import uz.turgunboyevjurabek.dagger2basic.MainActivity
import uz.turgunboyevjurabek.dagger2basic.di.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}