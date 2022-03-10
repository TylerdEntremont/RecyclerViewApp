package com.android.recyclerviewapp.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.recyclerviewapp.R
import com.android.recyclerviewapp.adapter.EventArrayEditor
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

    private val eventArrayEditor by lazy{
        EventArrayEditor()
    }

    private lateinit var event: Event

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            event= it.getParcelable("myEvent")!!
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.eventTitleEt.text=event.title
        binding.eventCategoryEt.text=event.category

        val eventDateLong = SimpleDateFormat("dd/M/yyyy").parse(event.date).time
        (getString(R.string.DaysLeft)+((eventDateLong -binding.eventCalendar.date)/86400000 + 1).toString()).also { binding.daysLeft.text = it }
        binding.eventCalendar.date = eventDateLong

        binding.deleteButton.setOnClickListener{
            eventArrayEditor.remove(event)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_frag_container, FirstFragment.newInstance())
                .commit()
        }

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