package com.silaeva.end_impl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.silaeva.end_impl.databinding.FragmentEndGameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EndGameFragment : Fragment() {

    private lateinit var binding: FragmentEndGameBinding

    private val viewModel: EndGameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEndGameBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.setContent {
            MaterialTheme {
                EndGameScreen(viewModel)
            }
        }
    }

    companion object {
        fun newInstance() = EndGameFragment()
    }
}