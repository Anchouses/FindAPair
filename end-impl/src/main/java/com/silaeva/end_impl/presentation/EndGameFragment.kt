package com.silaeva.end_impl.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.silaeva.end_impl.R

class EndGameFragment : Fragment() {

    companion object {
        fun newInstance() = EndGameFragment()
    }

    private lateinit var viewModel: EndGameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_end_game, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EndGameViewModel::class.java)
        // TODO: Use the ViewModel
    }

}