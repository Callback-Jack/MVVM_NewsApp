package com.callbackequalsjack.my_mvvm_newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.callbackequalsjack.my_mvvm_newsapp.R
import com.callbackequalsjack.my_mvvm_newsapp.databinding.FragmentArticleBinding
import com.callbackequalsjack.my_mvvm_newsapp.ui.NewsActivity
import com.callbackequalsjack.my_mvvm_newsapp.ui.NewsViewModel
import androidx.navigation.fragment.navArgs

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private lateinit var binding: FragmentArticleBinding
    private lateinit var viewModel: NewsViewModel
    private val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)
        viewModel = (activity as NewsActivity).viewModel
        val article = args.article
        if (article.url == null) Toast.makeText(activity, "Url is invalid", Toast.LENGTH_SHORT).show()
        else binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url) }

        binding.fab.setOnClickListener {
            viewModel.saveArticle(article)
            Toast.makeText(activity, "Article saved successfully", Toast.LENGTH_SHORT).show()
        }
    }
}