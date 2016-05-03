package com.icaboalo.historystore.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import com.icaboalo.historystore.io.ProductApiModel
import java.util.*

/**
 * Created by icaboalo on 29/04/16.
 */
class ProductAutoCompleteAdapter: ArrayAdapter<ProductApiModel>, Filterable {

    var mContext: Context
    var mProductList: ArrayList<ProductApiModel>
    var mInflater: LayoutInflater
    var mResource: Int
    var mOriginalValues: ArrayList<ProductApiModel>
    private var mFilter: ArrayFilter? = null

    constructor(context: Context, resource: Int, productList: ArrayList<ProductApiModel>) : super(context, resource, productList){
        this.mContext = context
        this.mProductList = productList
        mInflater = LayoutInflater.from(context)
        this.mResource = resource
        this.mOriginalValues = ArrayList(productList)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)
    }

    override fun getItem(position: Int): ProductApiModel? {
        return mProductList[position]
    }

    override fun getCount(): Int {
        return mProductList.size
    }

    override fun getFilter(): Filter {
        if (mFilter ==null){
            mFilter = ArrayFilter()
        }
        return mFilter as ArrayFilter
    }

    private inner class ArrayFilter: Filter() {
        var lock: Object = Object()

        override fun performFiltering(constraint: CharSequence?): FilterResults? {
            var results: FilterResults = FilterResults()

            if (mOriginalValues == null) {
                synchronized (lock) {
                    mOriginalValues = ArrayList<ProductApiModel>(mProductList);
                }
            }

            if (constraint == null || constraint.length == 0){
                synchronized(lock){
                    results.values = mOriginalValues
                    results.count = mOriginalValues.size
                }
            }else {
                val prefixString = constraint.toString().toLowerCase()

                val values = mOriginalValues
                val count = values.size

                val newValues = ArrayList<ProductApiModel>(count)

                for (i in 0..(count - 1)) {
                    val item = values[i]
                    if (item.mName.toLowerCase().contains(prefixString)) {
                        newValues.add(item)
                    }

                }

                results.values = newValues
                results.count = newValues.size
            }
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults) {
            clear();
            setNotifyOnChange(true)
            for (product: ProductApiModel in results.values as List<ProductApiModel>) {
                add(product);
            }
            if (results.count > 0) {
                this@ProductAutoCompleteAdapter.notifyDataSetChanged();
            } else {
                this@ProductAutoCompleteAdapter.notifyDataSetInvalidated();
            }

        }

        override fun convertResultToString(resultValue: Any?): CharSequence {
            return if (resultValue == null) "" else (resultValue as ProductApiModel).mName
        }
    }
}