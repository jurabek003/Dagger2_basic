package uz.turgunboyevjurabek.dagger2basic.di.companent

import dagger.Component
import uz.turgunboyevjurabek.dagger2basic.di.module.NetworkModule

@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

}