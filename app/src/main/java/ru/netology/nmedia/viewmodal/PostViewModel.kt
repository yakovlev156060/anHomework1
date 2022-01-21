package ru.netology.nmedia.viewmodal

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.repository.PostRepository
import ru.netology.nmedia.repository.PostRepositoryInMemoryImpl

class PostViewModel:ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()

    fun like(){
        repository.like()
    }
    fun share(){
        repository.share()
    }
    fun get(): LiveData<Post> = repository.get()
}