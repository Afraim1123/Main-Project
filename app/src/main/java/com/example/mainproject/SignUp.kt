package com.example.mainproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.CheckBox

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        val checkBox = findViewById<CheckBox>(R.id.cbConfirmTC)

        val text = "I agree to the Terms & Conditions and Privacy Policy"

        val spannable = SpannableString(text)

        spannable.setSpan(
            ForegroundColorSpan(Color.BLUE),
            text.indexOf("Terms & Conditions"),
            text.indexOf("Terms & Conditions") + "Terms & Conditions".length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannable.setSpan(
            ForegroundColorSpan(Color.BLUE),
            text.indexOf("Privacy Policy"),
            text.indexOf("Privacy Policy") + "Privacy Policy".length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        checkBox.text = spannable

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}