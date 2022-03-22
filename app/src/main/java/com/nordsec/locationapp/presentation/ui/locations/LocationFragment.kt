package com.nordsec.locationapp.presentation.ui.locations

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nordsec.locationapp.R
import com.nordsec.locationapp.domain.entity.Location
import com.nordsec.locationapp.presentation.ui.locations.item.LocationItemPresenter
import kotlinx.android.synthetic.main.fragment_locations.*
import net.kibotu.android.recyclerviewpresenter.PresenterAdapter
import net.kibotu.android.recyclerviewpresenter.PresenterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment: Fragment() {

    private val mainViewModel: MainViewModel by viewModel()
    private val adapter = PresenterAdapter()
    private val items = mutableListOf<PresenterViewModel<*>>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_locations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.getLocationsSortedByCityName()
        setupViews()
        setupObservers()
    }

    private fun setupViews() {
        adapter.registerPresenter(LocationItemPresenter(onClick = {
            getSortedByDistanceLocations(it)
        }))
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        recycler_view.itemAnimator = null
        recycler_view.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        recycler_view.adapter = adapter
    }

    private fun setupObservers() {
        mainViewModel.locationList.observe(viewLifecycleOwner) { locationList ->
            if (locationList.isNullOrEmpty().not()) {
                locationList.forEach { location ->
                    items.add(PresenterViewModel(location, R.layout.item_location))
                }
                adapter.submitList(items)
            }
        }

        mainViewModel.error.observe(viewLifecycleOwner) { error ->
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getSortedByDistanceLocations(location: Location) {
        items.clear()
        mainViewModel.getLocationsSortedByDistance(location)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter.unregisterPresenter()
        mainViewModel.locationList.removeObservers(this)
    }
}