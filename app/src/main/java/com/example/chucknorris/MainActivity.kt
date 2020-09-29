package com.example.chucknorris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chucknorris.view.NamedFragment
import com.example.chucknorris.viewmodel.ChuckViewModel
import com.example.chucknorris.viewmodel.ChuckViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var chuckViewModelProvider: ChuckViewModelProvider
    lateinit var chuckViewModel: ChuckViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NorrisApplication.getComponent().inject(this)
        chuckViewModel = chuckViewModelProvider.create(ChuckViewModel::class.java)

        btn_first_case.setOnClickListener { getSingleJoke() }
        btn_second_case.setOnClickListener { getNamedJoke() }
        btn_third_case.setOnClickListener { getEndlessJoke() }
    }

    private fun getSingleJoke() {
        chuckViewModel.getSingleJoke()
        chuckViewModel.getSingleJokeLiveData()
    }

    private fun getNamedJoke() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, NamedFragment())
            .commit()
    }

    private fun getEndlessJoke() {
        chuckViewModel.getEndlessJoke()
        chuckViewModel.getEndlessJokeLiveData()
    }
}