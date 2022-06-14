package com.example.todolistappfinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.todolistappfinal.databinding.FragmentEditToDoItemBinding

class EditToDoItemFragment : Fragment() {
    private var _binding: FragmentEditToDoItemBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditToDoItemBinding.inflate(inflater, container, false)
        val view = binding.root

        val toDoItemId = EditToDoItemFragmentArgs.fromBundle(requireArguments()).toDoItemId

        val application = requireNotNull(this.activity).application
        val dao = ToDoItemDatabase.getInstance(application).todoitemDao

        val viewModelFactory = EditToDoItemViewModelFactory(toDoItemId, dao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(EditToDoItemViewModel::class.java)

        viewModel.navigateToList.observe(viewLifecycleOwner, Observer { navigate ->
            if (navigate) {
                view.findNavController().navigate(R.id.action_editToDoItemFragment_to_nav_today)
                viewModel.onNavigatedToList()
            }
        })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}