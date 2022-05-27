package com.example.todolistappfinal.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.todolistappfinal.databinding.FragmentTomorrowBinding

class TomorrowFragment : Fragment() {

    private var _binding: FragmentTomorrowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(TomorrowViewModel::class.java)

        _binding = FragmentTomorrowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTomorrow
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}