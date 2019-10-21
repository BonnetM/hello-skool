package com.octo.skool.front.helloskool.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.octo.skool.front.helloskool.R
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext


class ResultActivity : AppCompatActivity(), HeroesView, CoroutineScope {
    private lateinit var presenter: HeroesPresenter
    private lateinit var adapter: HeroesAdapter

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://superheroapi.com/api/10220012489959478/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        presenter = HeroesPresenter(
            heroesRepository = HeroesRepository(heroesService = retrofit.create(HeroesService::class.java)),
            heroesView = this
        )
        setContentView(R.layout.activity_result)
        adapter = HeroesAdapter()
        heroesList.layoutManager = LinearLayoutManager(this)
        heroesList.adapter = adapter
        launch(Dispatchers.IO) {
            progressBar.visibility = View.VISIBLE
            presenter.load()
        }
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

    override fun displayHeroes(list: List<Hero>) {
        launch {
            progressBar.visibility = View.GONE
            adapter.list = list
        }
    }

}
