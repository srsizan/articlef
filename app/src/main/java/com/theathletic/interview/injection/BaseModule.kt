package com.theathletic.interview.injection

import com.theathletic.interview.articleDetails.data.ArticleDetailsRepository
import com.theathletic.interview.articleDetails.data.remote.ArticleDetailsApi
import com.theathletic.interview.articleDetails.ui.ArticleDetailsViewModel
import com.theathletic.interview.articles.data.ArticleRepository
import com.theathletic.interview.articles.data.remote.ArticleApi
import com.theathletic.interview.articles.ui.ArticlesViewModel
import com.theathletic.interview.leagues.data.LeagueRepository
import com.theathletic.interview.leagues.data.remote.LeagueApi
import com.theathletic.interview.leagues.ui.LeaguesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val baseModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://mobile-interview-backend.theathletic.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory { get<Retrofit>().create(ArticleApi::class.java) }
    factory { get<Retrofit>().create(ArticleDetailsApi::class.java) }
    factory { get<Retrofit>().create(LeagueApi::class.java) }

    single { ArticleRepository(get()) }

    viewModel { ArticlesViewModel(get()) }

    single { ArticleDetailsRepository(get()) }

    viewModel { ArticleDetailsViewModel(get()) }
    single { LeagueRepository(get()) }

    viewModel { LeaguesViewModel(get()) }
}