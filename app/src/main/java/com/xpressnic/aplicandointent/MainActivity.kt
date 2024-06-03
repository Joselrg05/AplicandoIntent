package com.xpressnic.aplicandointent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil.setContentView
import com.xpressnic.aplicandointent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = setContentView(this, R.layout.activity_main)

        binding.showMessageButton.setOnClickListener {
            Toast.makeText(this, "Mensaje mostrado", Toast.LENGTH_SHORT).show()
        }

        binding.navigateButton.setOnClickListener {
            val intent = Intent(this, SegundaActivity::class.java)
            startActivity(intent)
        }

        binding.shareContentButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Compartiendo contenido desde mi app.")
            startActivity(Intent.createChooser(intent, "Compartir usando"))
        }

        binding.callButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+123456789")
            startActivity(intent)
        }

        binding.openWebButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(intent)
        }
    }
}
