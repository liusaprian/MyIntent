package com.example.myintentapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class ReturnResultActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_return_result)

        val returnButton: Button = findViewById(R.id.choose)
        val option: RadioGroup = findViewById(R.id.rg)

        returnButton.setOnClickListener(View.OnClickListener { v: View ->
            if (v.id == R.id.choose && option.checkedRadioButtonId != 0) {
                var value = 0
                when (option.checkedRadioButtonId) {
                    R.id.fifty -> value = 50
                    R.id.hundred -> value = 100
                    R.id.hunfif -> value = 150
                    R.id.twohun -> value = 200
                }
                val intent = Intent()
                intent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, intent)
                finish()
            }
        })
    }
}