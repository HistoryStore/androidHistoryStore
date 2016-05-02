package com.icaboalo.historystore.adapter

import java.util.ArrayList

import android.content.Context

import android.view.View

import android.view.ViewGroup

import android.widget.ArrayAdapter

import android.widget.Filter

import android.widget.Filterable

import com.icaboalo.historystore.io.ProductApiModel

class AutoCompleteAdapter(context: Context, resource: Int,
                          textViewResourceId: Int, private var fullList: ArrayList<ProductApiModel>?) : ArrayAdapter<ProductApiModel>(context, resource, textViewResourceId, fullList), Filterable {
    private var mOriginalValues: ArrayList<ProductApiModel>? = null
    private var mFilter: ArrayFilter? = null

    init {
        mOriginalValues = ArrayList(fullList)

    }

    override fun getCount(): Int {
        return fullList!!.size
    }

    override fun getItem(position: Int): ProductApiModel {
        return fullList!![position]
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)
    }

    override fun getFilter(): Filter {
        if (mFilter == null) {
            mFilter = ArrayFilter()
        }
        return ArrayFilter()
    }

    private inner class ArrayFilter : Filter() {
        private val lock = Object()

        override fun performFiltering(prefix: CharSequence?): Filter.FilterResults {
            val results = Filter.FilterResults()

            if (mOriginalValues == null) {
                synchronized(lock) {
                    mOriginalValues = ArrayList(fullList)
                }
            }

            if (prefix == null || prefix.length == 0) {
                synchronized (lock) {
                    val list = ArrayList(
                            mOriginalValues)
                    results.values = list
                    results.count = list.size
                }
            } else {
                val prefixString = prefix.toString().toLowerCase()

                val values = mOriginalValues
                val count = values?.size

                val newValues = ArrayList<ProductApiModel>(count!!)

                for (i in 0..(count - 1)) {
                    val item = values!![i]
                    if (item.mName.toLowerCase().contains(prefixString)) {
                        newValues.add(item)
                    }

                }

                results.values = newValues
                results.count = newValues.size
            }

            return results
        }

        @SuppressWarnings("unchecked")
        override fun publishResults(constraint: CharSequence,
                                    results: Filter.FilterResults) {

            if (results.values != null) {
                fullList = results.values as ArrayList<ProductApiModel>
            } else {
                fullList = ArrayList<ProductApiModel>()
            }
            /*if (results.count > 0) {
            notifyDataSetChanged();
        } else {
            notifyDataSetInvalidated();
        }*/
            notifyDataSetChanged()
            clear()
            var i = 0
            val l = fullList!!.size
            while (i < l) {
                add(fullList!![i])
                i++
            }
            notifyDataSetInvalidated()

        }
    }
}