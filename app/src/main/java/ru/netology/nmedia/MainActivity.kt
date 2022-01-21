package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.viewModels
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.viewmodal.PostViewModel

fun thousands(n:Long):String{
    val m:String
    when{
        (n<1000) -> m=n.toString()
        ((n>=1000)&&(n<10_000)) -> m=(n/1000).toString()+"."+(n/100-((n/1000)*10)).toString()+"K"
        ((n>=10_000)&&(n<1_000_000)) ->m=(n/1000).toString()+"K"
        else -> {
            var tmp:Long=n/1000
            m=(tmp/1000).toString()+"."+(tmp/100-((tmp/1000)*10)).toString()+"M"
        }
    }


    return m
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel:PostViewModel by viewModels()



        with(binding){
            viewModel.get().observe(this@MainActivity){post->
                author.text=post.author
                content.text=post.content
                published.text=post.published


                if(post.likedByMe){
                    like?.setImageResource(R.drawable.ic_liked)
                }
                else{
                    like?.setImageResource(R.drawable.ic_like_border)
                }

                like.setImageResource(
                    if(post.likedByMe){
                        R.drawable.ic_liked
                    }
                    else{
                        R.drawable.ic_like_border
                    }
                )

                likeCount?.text=thousands(post.likes.toLong()).toString()

                shareCount?.text=thousands(post.shares.toLong()).toString()
            }


            like?.setOnClickListener{
                viewModel.like()
            }

            share?.setOnClickListener{
                viewModel.share()
            }


        }
    }
}