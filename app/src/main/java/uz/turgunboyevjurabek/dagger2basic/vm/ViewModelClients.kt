 package uz.turgunboyevjurabek.dagger2basic.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.turgunboyevjurabek.dagger2basic.madels.ClientGet
import uz.turgunboyevjurabek.dagger2basic.repozitory.Repozitory
import javax.inject.Inject

class ViewModelClients @Inject constructor(private val repozitory: Repozitory) :ViewModel(){
    private val getAllLiveData=MutableLiveData<ArrayList<ClientGet>>()

    init {
        getALlClients()
    }

    fun getALlClients():MutableLiveData<ArrayList<ClientGet>>{
        viewModelScope.launch {
            val users=   repozitory.getClients()
            getAllLiveData.postValue(users)
            Log.d("XATO", users.toString())
        }
        return getAllLiveData
    }
}