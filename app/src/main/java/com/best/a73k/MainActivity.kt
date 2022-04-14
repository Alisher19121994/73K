package com.best.a73k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text1)
        editText = findViewById(R.id.edit1)
        getDetails()
        getData()
    }
    private fun getDetails(){
        editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                    Toast.makeText(this,editText.text,Toast.LENGTH_SHORT).show()
                textView.text=editText.text
                return@OnKeyListener true
            }
            false
        })
    }
    private fun getData(){
        editText.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               val texts = editText.text.toString()
               textView.text = texts
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }
}