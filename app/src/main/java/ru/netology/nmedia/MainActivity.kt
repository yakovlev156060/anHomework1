package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post

fun thousands(n:Long):String{
    val m:String
    if(n<1000){
        m=n.toString()
    }
    else{
        if(n<10_000){
            m=(n/1000).toString()+"."+(n/100-((n/1000)*10)).toString()+"K"
        }
        else{
            if(n<1_000_000){
                m=(n/1000).toString()+"K"
            }
            else{
                var tmp:Long=n/1000
                m=(tmp/1000).toString()+"."+(tmp/100-((tmp/1000)*10)).toString()+"M"
            }
        }

    }
    return m
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //println("zzz+ ${R.string.str_nmedia}")
        //println("zzz+ ${getString(R.string.str_nmedia)}")
        Log.d("aaaaaaaaa", "${R.string.str_nmedia}")
        //setContentView(R.layout.activity_main)

        var post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            published = "21 мая в 18:36",
            content ="Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            likedByMe  = false
        )
        with(binding){
            author.text=post.author
            content.text=post.content
            published.text=post.published


            if(post.likedByMe){
                like?.setImageResource(R.drawable.ic_liked)
            }
            else{
                like?.setImageResource(R.drawable.ic_like_border)
            }

            like.setOnClickListener{
                post.likedByMe = !post.likedByMe
                Log.d("testMessage", "like message 1111")
                like.setImageResource(
                    if(post.likedByMe){
                        R.drawable.ic_liked
                    }
                    else{
                        R.drawable.ic_like_border
                    }
                )
                if(post.likedByMe){
                    post.likes++
                }
                else{
                    post.likes--
                }
                likeCount?.text=post.likes.toString()

            }

            share.setOnClickListener{
                post.shares++
                shareCount?.text=thousands(post.shares)
            }

        }
    }
}