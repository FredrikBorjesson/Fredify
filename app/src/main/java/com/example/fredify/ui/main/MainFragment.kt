package com.example.fredify.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import androidx.lifecycle.ViewModelProvider
import com.example.fredify.R
import kotlinx.android.synthetic.main.country_select_list_item.*
import kotlinx.android.synthetic.main.language_selection_layout.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.language_selection_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = MainViewModel()
        val countriesAdapter = ArrayAdapter(context!!, R.layout.country_select_list_item, R.id.country_select_list_item_text, viewModel.countries)
        country_select_list.adapter = countriesAdapter
    }

}
