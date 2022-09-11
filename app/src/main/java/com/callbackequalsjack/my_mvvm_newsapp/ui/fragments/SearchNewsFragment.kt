package com.callbackequalsjack.my_mvvm_newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.callbackequalsjack.my_mvvm_newsapp.R
import com.callbackequalsjack.my_mvvm_newsapp.databinding.FragmentSavedNewsBinding
import com.callbackequalsjack.my_mvvm_newsapp.databinding.FragmentSearchNewsBinding
import com.callbackequalsjack.my_mvvm_newsapp.ui.NewsActivity
import com.callbackequalsjack.my_mvvm_newsapp.ui.NewsViewModel

class SearchNewsFragment : Fragment(R.layout.fragment_search_news) {

    private lateinit var binding: FragmentSearchNewsBinding
    private lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchNewsBinding.bind(view)
        viewModel = (activity as NewsActivity).viewModel
    }
}