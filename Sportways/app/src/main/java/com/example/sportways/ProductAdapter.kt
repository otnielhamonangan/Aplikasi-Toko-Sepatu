package com.example.sportways

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_produck.view.*


class ProductAdapter (val context: Context) :
                        RecyclerView.Adapter<ProductAdapter.ViewHolder>(), Filterable {

    var arrayList = ArrayList<product_model>()
    var ProductListFilter = ArrayList<product_model>()


    fun setData(arrayList: ArrayList<product_model>) {
        this.arrayList = arrayList
        this.ProductListFilter = arrayList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(model: product_model) {
            // id pada item_product.xml
            itemView.product_name.text = model.nmProduct
            itemView.product_desc.text = model.dsProduct
            itemView.price_product.text = model.priceofProduct.toString()
            itemView.gambar.setImageResource(model.picProduct)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_produck, parent, false)
        return ProductAdapter.ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(arrayList[position])

        holder.itemView.setOnClickListener() {
            val model = arrayList.get(position)

            var gProduct: String = model.nmProduct
            var gDesc: String = model.dsProduct
            var gPrice: Int = model.priceofProduct.toString().toInt()
            var gImg: Int = model.picProduct

            val intent = Intent(context, Order::class.java)
            intent.putExtra("pProduct", gProduct)
            intent.putExtra("pDesc", gDesc)
            intent.putExtra("pPrice", gPrice)
            intent.putExtra("pImg", gImg)

            context.startActivity(intent)
        }
    }

    override fun getFilter(): android.widget.Filter {
        return object : Filter(){
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (charSequence == null || charSequence.length<0){
                    filterResults.count = ProductListFilter.size
                    filterResults.values = ProductListFilter
                }else{
                    var searchChr = charSequence.toString()
                    val produkSearch = ArrayList<product_model>()
                    for (item in ProductListFilter){
                        if (item.nmProduct.toLowerCase().contains(searchChr) || item.dsProduct.toLowerCase().contains(searchChr)){
                            produkSearch.add(item)
                        }
                    }
                    filterResults.count = produkSearch.size
                    filterResults.values = produkSearch
                }
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
                arrayList = filterResults!!.values as ArrayList<product_model>
                notifyDataSetChanged()
            }

        }
    }


}