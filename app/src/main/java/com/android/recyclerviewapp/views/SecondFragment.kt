package com.android.recyclerviewapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.recyclerviewapp.MainActivity
import com.android.recyclerviewapp.R
import com.android.recyclerviewapp.databinding.FragmentSecondBinding
import com.android.recyclerviewapp.model.Event





/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {

    private val binding by lazy {
        FragmentSecondBinding.inflate(layoutInflater)
    }

    private var newDate = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding.eventCalendar.setOnDateChangeListener { _, i, i2, i3 ->
            newDate=i3.toString()+"/"+(i2+1).toString()+"/"+i.toString()
        }

        binding.doneBtn.setOnClickListener{
            //val mEvent= Event(binding.eventTitleEt.text.toString(),binding.eventCategoryEt.text.toString() ,
             //   DateFormat.getDateInstance().format(binding.eventCalendar.date))

            val mEvent= Event(binding.eventTitleEt.text.toString(),binding.eventCategoryEt.text.toString(),newDate)

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_frag_container, FirstFragment.newInstance(mEvent))
                .commit()

        }

        return binding.root
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            SecondFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}