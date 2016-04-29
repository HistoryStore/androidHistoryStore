package com.icaboalo.historystore.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.icaboalo.historystore.R
import com.icaboalo.historystore.io.ProductApiModel
import java.util.*

/**
 * Created by icaboalo on 28/04/16.
 */
class ProductRecyclerAdapter: RecyclerView.Adapter<ProductRecyclerAdapter.ProductViewHolder> {

    var mContext: Context
    var mProductList: ArrayList<ProductApiModel>
    var mInflater: LayoutInflater

    constructor(context: Context, purchaseList: ArrayList<ProductApiModel>) : super() {
        this.mContext = context
        this.mProductList = purchaseList
        mInflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductViewHolder? {
        val view: View = mInflater.inflate(R.layout.item_products, parent, false)
        return ProductViewHolder(view, R.id.product_text, R.id.quantity_text, R.id.price_text)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product: ProductApiModel = mProductList[position]
        holder.mProduct.text = product.mName
        holder.mQuantity.text = "0"
        holder.mPrice.text = "0"
    }

    override fun getItemCount(): Int {
        return mProductList.size
    }

    class ProductViewHolder: RecyclerView.ViewHolder{

        var mProduct: TextView
        var mQuantity: TextView
        var mPrice: TextView

        constructor(itemView: View, productTextId: Int, quantityTextId: Int, priceTextId: Int): super(itemView){
            mProduct = itemView.findViewById(productTextId) as TextView
            mQuantity = itemView.findViewById(quantityTextId) as TextView
            mPrice = itemView.findViewById(priceTextId) as TextView
        }

    }
}