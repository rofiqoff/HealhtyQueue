package id.rofiqof.healthyqueue.utils

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.reflect.InvocationTargetException

abstract class Adapter<TipeData, ViewHolder : RecyclerView.ViewHolder>(
        protected var mLayout: Int,
        private var mViewHolderClass: Class<ViewHolder>,
        private var modelClass: Class<TipeData>,
        private var mData: MutableList<TipeData>) : RecyclerView.Adapter<ViewHolder>() {

    fun addData(data: TipeData) {
        mData.add(data)
        notifyItemInserted(itemCount - 1)
    }

    fun addListData(list: List<TipeData>) {
        mData.addAll(list)
        notifyDataSetChanged()
    }

    fun insertData(position: Int, data: TipeData) {
        mData.add(position, data)
        notifyItemInserted(position)
        notifyItemRangeChanged(position, mData.size)
    }

    fun removeData(position: Int) {
        mData.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, mData.size)
    }

    fun remove(position: Int) {
        mData.removeAt(position)
        notifyDataSetChanged()
    }

    fun updateData(list: MutableList<TipeData>) {
        mData = list
        notifyDataSetChanged()
    }

    fun getmData(): List<TipeData> {
        return mData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(mLayout, parent, false) as ViewGroup

        try {
            val constructor = mViewHolderClass.getConstructor(View::class.java)
            return constructor.newInstance(view)
        } catch (e: NoSuchMethodException) {
            throw RuntimeException(e)
        } catch (e: IllegalAccessException) {
            throw RuntimeException(e)
        } catch (e: InstantiationException) {
            throw RuntimeException(e)
        } catch (e: InvocationTargetException) {
            throw RuntimeException(e)
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = getItem(position)
        bindView(holder, model, position)
    }

    protected abstract fun bindView(holder: ViewHolder, model: TipeData, position: Int)

    private fun getItem(position: Int): TipeData {
        return mData[position]
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}