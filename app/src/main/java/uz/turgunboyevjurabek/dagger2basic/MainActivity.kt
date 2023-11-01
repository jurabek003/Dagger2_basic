package uz.turgunboyevjurabek.dagger2basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        Toast.makeText(this, "${viewModelClients.getALlClients()}", Toast.LENGTH_SHORT).show()
        adapterCreate()

    }

    private fun adapterCreate() {
        rvAdapter=RvAdapter( viewModelClients.getALlClients())
        Toast.makeText(this, "${viewModelClients.getALlClients()}  funksiyani ichida", Toast.LENGTH_SHORT).show()
        binding.rvAdapter.adapter=rvAdapter
    }
}