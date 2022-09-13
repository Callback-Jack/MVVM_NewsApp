package com.callbackequalsjack.my_mvvm_newsapp

import android.app.Application
import com.callbackequalsjack.my_mvvm_newsapp.db.ArticleDatabase
import com.callbackequalsjack.my_mvvm_newsapp.repository.NewsRepository
import com.callbackequalsjack.my_mvvm_newsapp.ui.NewsViewModelProviderFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class NewsApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@NewsApplication))
        bind() from singleton { ArticleDatabase(instance()) }
        bind() from singleton { NewsRepository(instance()) }
        bind() from provider { NewsViewModelProviderFactory(this@NewsApplication, instance()) }
    }
}