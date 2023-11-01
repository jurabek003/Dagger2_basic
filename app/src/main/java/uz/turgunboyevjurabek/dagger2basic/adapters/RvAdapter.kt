package uz.turgunboyevjurabek.dagger2basic.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import dagger.Module
import dagger.Provides
import uz.turgunboyevjurabek.dagger2basic.databinding.ItemRvBinding
import uz.turgunboyevjurabek.dagger2basic.madels.ClientGet

@Module
class RvAdapter(val list:ArrayList<ClientGet>):RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(val itemRvBinding: ItemRvBinding):ViewHolder(itemRvBinding.root){
        fun onBind(clientGet: ClientGet){
            itemRvBinding.thtItem.text=clientGet.ism
            itemRvBinding.imgItem.setImageURI(Uri.parse(clientGet.clientRasm as String?))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
}