package com.aetherized.view.pondpediaview.ui.authenticated.home.pond

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aetherized.view.pondpediaview.R
import com.aetherized.view.pondpediaview.data.repository.PondRepository
import com.aetherized.view.pondpediaview.ui.adapter.PondAdapter
import com.aetherized.view.pondpediaview.utils.helper.CustomPreference
import com.aetherized.view.pondpediaview.utils.helper.ViewModelFactory

class PondFragmentA : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var pondAdapter: PondAdapter
    private lateinit var progressBar: ProgressBar


    private val viewModelFactory by lazy { ViewModelFactory.getInstance(requireContext()) }
    private val pondViewModel by viewModels<PondViewModel> { viewModelFactory }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pond_a, container, false)

        pondAdapter = PondAdapter(ArrayList())
        progressBar = view.findViewById(R.id.progressBar)

        recyclerView = view.findViewById(R.id.rv_users)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = pondAdapter


        pondViewModel.getAllPonds().observe(viewLifecycleOwner) { ponds ->
            if (ponds != null) {
                pondAdapter.addPonds(ponds)
            }
        }

        pondViewModel.isLoading.observe(viewLifecycleOwner) {
            showLoading(it)
        }

        return view
    }

    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}