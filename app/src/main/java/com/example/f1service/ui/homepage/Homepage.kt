package com.example.f1service.ui.homepage

import android.annotation.SuppressLint
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
import com.example.f1service.R
import com.example.f1service.counter.NextRaceCounter
import com.example.f1service.databinding.FragmentHomepageBinding
import com.example.f1service.ui.lastRace.LastRace
import com.example.f1service.ui.theme.F1ServiceTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Homepage : Fragment() {

    private lateinit var mBinding: FragmentHomepageBinding

    private val viewModel by viewModels<HomepageViewModel>()

    @Inject
    lateinit var counter: NextRaceCounter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentHomepageBinding.inflate(
            layoutInflater,
            container,
            false
        )
        return mBinding.root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.nextRaceInfo.observe(viewLifecycleOwner) {
            mBinding.nextRaceContainer.setContent {
                F1ServiceTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color.Transparent
                    ) {
                        it?.let {
                            NextRaceUI(it,counter)
                        }
                    }
                }
            }
        }

        viewModel.sendRequest()
        initContainer()
    }

    private fun initContainer() {
        val frgManager = requireActivity().supportFragmentManager.beginTransaction()
        frgManager.replace(
            R.id.container,
            LastRace()
        )
        frgManager.commit()
    }
}