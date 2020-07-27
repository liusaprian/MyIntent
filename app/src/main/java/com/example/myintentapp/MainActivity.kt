package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.ReferenceQueue

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var returnResult: TextView

    companion object {
        private const val REQUEST_CODE = 100
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstButton: Button = findViewById(R.id.move_activity)
        firstButton.setOnClickListener(this)

        val secondButton: Button = findViewById(R.id.move_with_data)
        secondButton.setOnClickListener(this)

        val thirdButton: Button = findViewById(R.id.dial_number)
        thirdButton.setOnClickListener(this)

        val fourthButton: Button = findViewById(R.id.pojo)
        fourthButton.setOnClickListener(this)

        val fifthButton: Button = findViewById(R.id.result)
        fifthButton.setOnClickListener(this)

        returnResult = findViewById(R.id.return_result)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.move_activity -> {
                val intent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(intent)
            }
            R.id.move_with_data -> {
                val intent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                intent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Lius Aprian Hartono")
                intent.putExtra(MoveWithDataActivity.EXTRA_AGE, 18)
                startActivity(intent)
            }
            R.id.dial_number -> {
                val phone = "089509659318"
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
                startActivity(intent)
            }
            R.id.pojo -> {
                val person = Person("Lius Aprian Hartono", 18, "aprianlius@gmail.com", "Jakarta")
                val intent = Intent(this@MainActivity, PojoActivity::class.java)
                intent.putExtra(PojoActivity.EXTRA_PERSON, person)
                startActivity(intent)
            }
            R.id.result -> {
                val intent = Intent(this@MainActivity, ReturnResultActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE && resultCode == ReturnResultActivity.RESULT_CODE) {
            val value = data?.getIntExtra(ReturnResultActivity.EXTRA_SELECTED_VALUE, 0)
            returnResult.text = "$value"
        }
    }
}