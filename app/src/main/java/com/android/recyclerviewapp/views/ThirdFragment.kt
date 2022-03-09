package com.android.recyclerviewapp.views

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.recyclerviewapp.R
import com.android.recyclerviewapp.databinding.FragmentThirdBinding
import com.android.recyclerviewapp.model.Event
import java.text.SimpleDateFormat


/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {


    private val binding by lazy {
        FragmentThirdBinding.inflate(layoutInflater)
    }

    private lateinit var event: Event

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            event= it.getParcelable("myEvent")!!
        }
    }

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.eventTitleEt.text=event.title
        binding.eventCategoryEt.text=event.category

        val eventDateLong = SimpleDateFormat("dd/M/yyyy").parse(event.date).time
        binding.daysLeft.text = getString(R.string.DaysLeft)+((eventDateLong -binding.eventCalendar.date)/86400000 + 1).toString()
        binding.eventCalendar.date = eventDateLong


        return binding.root
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ThirdFragment.
         */

        @JvmStatic
        fun newInstance(newEvent: Event? = null) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("myEvent", newEvent)
                }
            }
    }
}