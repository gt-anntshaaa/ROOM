package com.example.roomandflow.ui.busSchedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.roomandflow.R
import com.example.roomandflow.data.database.ScheduleApplication
import com.example.roomandflow.data.viewmodel.BusScheduleViewModel
import com.example.roomandflow.data.viewmodel.BusScheduleViewModelImpl
import com.example.roomandflow.databinding.FragmentBusScheduleBinding
import com.example.roomandflow.ui.adapter.ScheduleAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BusScheduleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BusScheduleFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private var _binding: FragmentBusScheduleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBusScheduleBinding.inflate(inflater,container,false)
        return binding.root
    }



    private val viewModel: BusScheduleViewModel by activityViewModels {
        BusScheduleViewModelImpl(
            (activity?.application as ScheduleApplication).database.scheduleDao()
        )
    }
    private lateinit var adapter: ScheduleAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ScheduleAdapter()
        binding.recyclerview.adapter = adapter
        GlobalScope.launch(Dispatchers.IO) {
            adapter.submitList(viewModel.fullSchedule())
        }
    }


}