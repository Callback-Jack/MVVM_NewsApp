package com.callbackequalsjack.my_mvvm_newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.callbackequalsjack.my_mvvm_newsapp.R
import com.callbackequalsjack.my_mvvm_newsapp.databinding.FragmentArticleBinding
import com.callbackequalsjack.my_mvvm_newsapp.databinding.FragmentSearchNewsBinding
import com.callbackequalsjack.my_mvvm_newsapp.ui.NewsActivity
import com.callbackequalsjack.my_mvvm_newsapp.ui.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private lateinit var binding: FragmentArticleBinding
    private lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)
        viewModel = (activity as NewsActivity).viewModel
    }
}