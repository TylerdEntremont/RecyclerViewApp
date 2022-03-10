package com.android.recyclerviewapp.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.recyclerviewapp.adapter.EventAdapter
import com.android.recyclerviewapp.adapter.OnItemClickListener
import com.android.recyclerviewapp.databinding.FragmentFirstBinding
import com.android.recyclerviewapp.fragmentNavigation
import com.android.recyclerviewapp.model.Event


/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment(), OnItemClickListener {


    private val binding by lazy {
        FragmentFirstBinding.inflate(layoutInflater)
    }

    // This is my adapter to be used to change the data
    private val eventAdapter by lazy {
        EventAdapter(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let {
            val event= it.getParcelable<Event>("myEvent")
            if (event != null) {
                eventAdapter.updateEventData(event)
            }
            setRetainInstance(true)



        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding.myRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = eventAdapter
        }

        binding.addEvent.setOnClickListener {
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                SecondFragment.newInstance()
            )
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        return binding.root
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment FirstFragment.
         */
        @JvmStatic
        fun newInstance(newEvent: Event? = null) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("myEvent", newEvent)
                }
            }

    }

    override fun onItemClick(event: Event) {
        fragmentNavigation(
           supportFragmentManager = requireActivity().supportFragmentManager,
           ThirdFragment.newInstance(event)
       )
    }


}

