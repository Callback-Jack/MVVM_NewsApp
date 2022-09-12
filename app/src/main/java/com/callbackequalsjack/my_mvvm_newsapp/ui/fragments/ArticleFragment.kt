package com.callbackequalsjack.my_mvvm_newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.callbackequalsjack.my_mvvm_newsapp.R
import com.callbackequalsjack.my_mvvm_newsapp.databinding.FragmentArticleBinding
import com.callbackequalsjack.my_mvvm_newsapp.ui.NewsActivity
import com.callbackequalsjack.my_mvvm_newsapp.ui.NewsViewModel
import androidx.navigation.fragment.navArgs

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private lateinit var binding: FragmentArticleBinding
    private lateinit var viewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)
        viewModel = (activity as NewsActivity).viewModel
        val article = args.article
        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { loadUrl(it) }
        }
    }
}