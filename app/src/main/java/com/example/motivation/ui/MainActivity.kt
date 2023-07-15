package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreference
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var categoryId = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        handleUserName()
        handleFilter(R.id.image_all)


        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageEmoji.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase) {
            println("oi")
        } else if (view.id in listOf(
                R.id.image_all,
                R.id.image_emoji,
                R.id.image_sunny
            )
        ) {
            handleFilter(view.id)
        }

    }

    private fun handleUserName() {
        val name =
            SecurityPreference(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.TextUserName.text = "Olá, $name!"
    }

    private fun handleFilter(id: Int) {
        binding.imageAll.setColorFilter(
            ContextCompat.getColor(
                this,
                R.color.dark_purple
            )
        )

        binding.imageEmoji.setColorFilter(
            ContextCompat.getColor(
                this,
                R.color.dark_purple
            )
        )

        binding.imageSunny.setColorFilter(
            ContextCompat.getColor(
                this,
                R.color.dark_purple
            )
        )

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.image_emoji -> {
                binding.imageEmoji.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                categoryId = MotivationConstants.FILTER.EMOJI
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                categoryId = MotivationConstants.FILTER.SUNNY
            }
        }
    }
}