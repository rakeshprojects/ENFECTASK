package com.example.taskenfc

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskenfc.repository.Repository
import com.example.taskenfc.viewmodel.PostUserViewModel
import com.example.taskenfc.viewmodel.PostUserViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PostUserAdapter
    private val viewModel: PostUserViewModel by viewModels {
        PostUserViewModelFactory(Repository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.postUserData.observe(this, Observer { postUserList ->
            adapter = PostUserAdapter(postUserList)
            recyclerView.adapter = adapter
        })

        viewModel.error.observe(this, Observer { errorMessage ->
            // Handle error
        })

        viewModel.fetchPostUserData()
    }
}