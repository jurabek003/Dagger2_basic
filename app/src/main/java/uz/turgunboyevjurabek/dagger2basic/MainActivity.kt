package uz.turgunboyevjurabek.dagger2basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import uz.turgunboyevjurabek.dagger2basic.adapters.RvAdapter
import uz.turgunboyevjurabek.dagger2basic.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.dagger2basic.madels.ClientGet
import uz.turgunboyevjurabek.dagger2basic.vm.ViewModelClients
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var rvAdapter: RvAdapter
    @Inject
    lateinit var viewModelClients: ViewModelClients
    override fun onCreate(savedInstanceState: Bundle?) {
        App.applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        adapterCreate()

    }

    private fun adapterCreate() {
        viewModelClients.getALlClients().observe(this,Observer{
            rvAdapter=RvAdapter(it)
            binding.rvAdapter.adapter=rvAdapter
        })

    }
}