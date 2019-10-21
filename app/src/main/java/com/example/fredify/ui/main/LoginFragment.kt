package com.example.fredify.ui.main

import android.app.Notification
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.example.fredify.R
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {
    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val contentView = inflater.inflate(R.layout.login_fragment, container, false)
        return contentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLinks()
    }

    private fun setupLinks(): Unit {
        val link = "https://www.google.se/"
        forgot_password_link.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(link)
            startActivity(i)
        }

        alternative_employment_link.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(link)
            startActivity(i)
        }
    }
}