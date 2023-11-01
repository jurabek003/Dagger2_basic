 package uz.turgunboyevjurabek.dagger2basic.vm

import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import uz.turgunboyevjurabek.dagger2basic.R
import uz.turgunboyevjurabek.dagger2basic.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.dagger2basic.madels.ClientGet
import uz.turgunboyevjurabek.dagger2basic.repozitory.Repozitory
import javax.inject.Inject

class ViewModelClients @Inject constructor(private val repozitory: Repozitory) :ViewModel(){
     val getAllLiveData=MutableLiveData<ArrayList<ClientGet>>()

    init {
        getALlClients()
    }

    fun getALlClients():MutableLiveData<ArrayList<ClientGet>>{

        viewModelScope.launch {

            coroutineScope {
                val  users=async {
                    repozitory.getClients()
                }.await()

                getAllLiveData.postValue(users)
                Log.d("XATO", users.toString())
            }
        }
        return getAllLiveData
    }
}