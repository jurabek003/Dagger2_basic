 package uz.turgunboyevjurabek.dagger2basic.vm

import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.coroutines.launch
import uz.turgunboyevjurabek.dagger2basic.R
import uz.turgunboyevjurabek.dagger2basic.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.dagger2basic.madels.ClientGet
import uz.turgunboyevjurabek.dagger2basic.repozitory.Repozitory
import javax.inject.Inject

class ViewModelClients @Inject constructor(private val repozitory: Repozitory) :ViewModel(){
    private val getAllLiveData=ArrayList<ClientGet>()

    init {
        getALlClients()
    }

    fun getALlClients():ArrayList<ClientGet>{
        viewModelScope.launch {
            val users=   repozitory.getClients()
            getAllLiveData.addAll(users)
            Log.d("XATO", users.toString())
        }
        return getAllLiveData
    }
}