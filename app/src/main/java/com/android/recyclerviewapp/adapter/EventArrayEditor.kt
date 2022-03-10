package com.android.recyclerviewapp.adapter

import com.android.recyclerviewapp.model.Event
import com.android.recyclerviewapp.model.EventArray

class EventArrayEditor {
    private var eventList: MutableList<Event> = EventArray.eventList

    fun remove(event:Event){
        eventList.remove(event)
    }
}