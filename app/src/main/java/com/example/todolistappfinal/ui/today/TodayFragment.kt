package com.example.todolistappfinal.ui.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.todolistappfinal.*
import com.example.todolistappfinal.databinding.FragmentTodayBinding


class TodayFragment : Fragment() {
    private var _binding: FragmentTodayBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTodayBinding.inflate(inflater, container, false)
        val view = binding.root
        val application = requireNotNull(this.activity).application
        val dao = ToDoItemDatabase.getInstance(application).todoitemDao
        val viewModelFactory = TodayViewModelFactory(dao)
        val viewModel = ViewModelProvider(
            this, viewModelFactory).get(TodayViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = ToDoItemAdapter { toDoItemId ->
            viewModel.onToDoItemClicked(toDoItemId)

        }
        binding.todoList.adapter = adapter

        viewModel.todoitems.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        viewModel.navigateToToDoItem.observe(viewLifecycleOwner, Observer { toDoItemId ->
            toDoItemId?.let {
                val action = TodayFragmentDirections.actionTodayFragmentToEditToDoItemFragment(toDoItemId)
                this.findNavController().navigate(action)
                viewModel.onToDoItemNavigated()
            }
        })





        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}