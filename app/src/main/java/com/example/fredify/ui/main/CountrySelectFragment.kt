package com.example.fredify.ui.main

import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatButton
import androidx.core.text.HtmlCompat
import com.example.fredify.R
import kotlinx.android.synthetic.main.language_selection_layout.*
import kotlinx.android.synthetic.main.login_fragment.*

class CountrySelectFragment : Fragment() {

    companion object {
        fun newInstance() = CountrySelectFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val contentView = inflater.inflate(R.layout.language_selection_layout, container, false)
        return contentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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
        activity!!.supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}
