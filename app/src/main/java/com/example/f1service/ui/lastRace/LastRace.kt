package com.example.f1service.ui.lastRace

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.viewModels
import com.example.f1service.constant.F1Team
import com.example.f1service.constant.F1Driver
import com.example.f1service.databinding.FragmentLastRaceBinding
import com.example.f1service.ui.theme.F1ServiceTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LastRace : Fragment() {

    private lateinit var mBinding: FragmentLastRaceBinding

    private val viewModel by viewModels<LastRaceViewModel>()

   @Inject lateinit var mF1Driver: F1Driver
   @Inject lateinit var mF1Team: F1Team

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentLastRaceBinding.inflate(
            layoutInflater,
            container,
            false
        )

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.resultList.observe(viewLifecycleOwner) {
            mBinding.lastRaceResultView.setContent {
                F1ServiceTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color.Transparent
                    ) {
                        it?.let {
                            LastRaceUI(it,mF1Driver,mF1Team)
                        }
                    }
                }
            }
        }
        viewModel.sendRequest()
    }
}