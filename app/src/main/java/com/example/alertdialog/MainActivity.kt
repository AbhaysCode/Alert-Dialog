package com.example.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val typeonebuilder = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setIcon(R.drawable.baseline_person_add_24)
            .setMessage("Do You Want To Add Contact ?")
            .setPositiveButton("Yes"){ _, _->
                Toast.makeText(this,"Contact Added !",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){_,_->
                Toast.makeText(this,"Contact Not Added !",Toast.LENGTH_SHORT).show()
             }.create()
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            typeonebuilder.show()
        }
        val options = arrayOf("First Option","Second Option","Third Option")
        val typeSecondBuilder = AlertDialog.Builder(this)
            .setTitle("Choose One of the Following")
            .setSingleChoiceItems(options, 0){_,i->
                Toast.makeText(this,"You Clicked ${options[i]}",Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Yes"){ _, _->
                Toast.makeText(this,"Yes On SingleChoiceItem !",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){_,_->
                Toast.makeText(this,"No On SingleChoiceItem !",Toast.LENGTH_SHORT).show()
             }.create()
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            typeSecondBuilder.show()
        }
        val typethirdBuilder = AlertDialog.Builder(this)
            .setTitle("Choose One of the Following of MultiChoice")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false)){ _, i,isChecked->
                if(isChecked){
                    Toast.makeText(this,"You Checked ${options[i]}",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"You UnChecked ${options[i]}",Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Yes"){ _, _->
                Toast.makeText(this,"Yes On setMultiChoiceItems !",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){_,_->
                Toast.makeText(this,"No On setMultiChoiceItems !",Toast.LENGTH_SHORT).show()
            }.create()
        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            typethirdBuilder.show()
        }

    }
}