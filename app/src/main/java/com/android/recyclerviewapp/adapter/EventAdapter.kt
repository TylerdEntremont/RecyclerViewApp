package com.android.recyclerviewapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.recyclerviewapp.R
import com.android.recyclerviewapp.model.Event
import com.android.recyclerviewapp.model.EventArray
import java.text.SimpleDateFormat

class EventAdapter(
    private val eventClickedListener:OnItemClickListener,
    private var eventList: MutableList<Event> = EventArray.eventList
) : RecyclerView.Adapter<EventViewHolder>() {

    // This method will update our data set
    fun updateEventData(event: Event) {

        val date = SimpleDateFormat("dd/M/yyyy").parse(event.date).time

        for (item in eventList) {
            val itemDate = SimpleDateFormat("dd/M/yyyy").parse(item.date).time
            if (date <= itemDate) {
                eventList.add(eventList.indexOf(item), event)
                notifyItemInserted(eventList.indexOf(event))
                return
            }
        }
        eventList.add(eventList.size,event)
        notifyItemInserted(eventList.indexOf(event))
    }


    /**
     * Here you are creating your view holder that holds you views to be bound
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        // here i am inflating my EVENT ITEM coming from the XML file
        val eventView = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return EventViewHolder(eventView, eventClickedListener)

    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]

        holder.bind(event)
    }

    override fun getItemCount(): Int = eventList.size
}

class EventViewHolder(itemView: View, private val onClick:OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.event_title)
    private val category: TextView = itemView.findViewById(R.id.event_category)
    private val date: TextView = itemView.findViewById(R.id.event_date)


    fun bind(event: Event) {
        title.text = event.title
        category.text = event.category
        date.text = event.date

        itemView.setOnClickListener{
            onClick.onItemClick(event)}
    }
}