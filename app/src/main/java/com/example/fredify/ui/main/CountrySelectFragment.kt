package com.example.fredify.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.fredify.R
import kotlinx.android.synthetic.main.country_selection_fragment.*

class CountrySelectFragment : Fragment() {

    companion object {
        fun newInstance() = CountrySelectFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val contentView = inflater.inflate(R.layout.country_selection_fragment, container, false)
        return contentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = MainViewModel()
        val countriesAdapter = ArrayAdapter(context!!, R.layout.country_select_list_item, R.id.country_select_list_item_text, viewModel.countries)
        country_select_list.adapter = countriesAdapter
        countries_select_button.setOnClickListener { buttonClicked() }
    }

    private fun getSelectedCounty() : String {
        val position = country_select_list.selectedItemPosition
        return viewModel.countries[position]
    }

    private fun buttonClicked() : Unit {
        val fragment = LoginFragment.newInstance()
        val transaction = activity!!.supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.enter_animation, R.anim.exit_animation)
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}
