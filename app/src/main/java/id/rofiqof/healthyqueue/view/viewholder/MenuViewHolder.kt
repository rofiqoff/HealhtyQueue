package id.rofiqof.healthyqueue.view.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import id.rofiqof.healthyqueue.models.Feature
import id.rofiqof.healthyqueue.utils.AppWireframe
import kotlinx.android.synthetic.main.item_menu.view.*

class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val wireframe by lazy { AppWireframe() }

    fun onBind(feature: Feature?) {
        val title = feature?.title
        val icon = feature?.icon

        itemView.title_menu?.text = title
        feature?.icon?.let { itemView.icon_menu?.setImageResource(it) }

        itemView.rootView?.setOnClickListener {
            wireframe.detail.toView(itemView.context, title, icon)
        }
    }
}