package com.android.recyclerviewapp.adapter

import com.android.recyclerviewapp.model.Event

interface OnItemClickListener {
    fun onItemClick (event: Event)
}