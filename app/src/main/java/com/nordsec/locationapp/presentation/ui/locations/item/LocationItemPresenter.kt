package com.nordsec.locationapp.presentation.ui.locations.item

import androidx.recyclerview.widget.RecyclerView
import com.nordsec.locationapp.R
import com.nordsec.locationapp.domain.entity.Location
import kotlinx.android.synthetic.main.item_location.view.*
import net.kibotu.android.recyclerviewpresenter.Presenter
import net.kibotu.android.recyclerviewpresenter.PresenterViewModel

class LocationItemPresenter(private val onClick: (location: Location) -> Unit): Presenter<Location>(R.layout.item_location) {
    override fun bindViewHolder(
        viewHolder: RecyclerView.ViewHolder,
        item: PresenterViewModel<Location>,
        payloads: MutableList<Any>?
    ) {
        with(viewHolder.itemView) {
            city_name_tv.text = item.model.city
            viewHolder.itemView.setOnClickListener{
                onClick.invoke(item.model)
            }
        }
    }
}