package com.example.assignment4

import android.content.Intent
import android.net.Uri
import android.os.Binder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.assignment4.databinding.ActivityMainBinding
import java.io.Serializable


class MainActivity : AppCompatActivity() {
    //private lateinit var user: ArrayList<User>
    private val user = ArrayList<User>()
    private lateinit var binding: ActivityMainBinding




    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding =DataBindingUtil.setContentView(this,R.layout.activity_main)
        //setContentView(binding.root)
        binding = ActivityMainBinding.inflate(layoutInflater)

        var textEmail =findViewById<EditText>(R.id.etxemail)
        var textPass = findViewById<TextView>(R.id.etxpass)
        var btnSigning = findViewById<Button>(R.id.btn_signin)
        var btCreate= findViewById<Button>(R.id.button2)
        var textViewPass = findViewById<TextView>(R.id.textView6)


        user.add(User("Jean-Roody","Louis","rydoo83@hotmail.com","pass"))
        user.add(User("Jean-Rony","Louis","rydoo88@gmail.com","pass88"))
        user.add(User("Jean-Robert","Faveur","rydoo83@hotmail.com","pass1"))
        user.add(User("Jean-Rosny","Desmornes","rydoo83@hotmail.com","pass2"))
        user.add(User("Jean-Ruth","Descieux","rydoo83@hotmail.com","pass22"))

          btnSigning.setOnClickListener {
              var email1 = textEmail.text.toString()
              user.stream()
                  .filter { it.email == textEmail.text.toString() && it.pass == textPass.text.toString() }
                  .findFirst()
                  .ifPresentOrElse({ foundUser ->
                      Toast.makeText(this, "Success!!!", Toast.LENGTH_LONG).show()
                      Intent(this, ShoppingActivity::class.java).apply {
                          putExtra("EXTRA_EMAIL", foundUser.email)
                          startActivity(this)
                      }
                  }, { Toast.makeText(this, "User not found", Toast.LENGTH_LONG).show() })

          }

              val newUsr = intent.getSerializable("EXTRA_USER") as? User

        if (newUsr != null) {
            user.add(newUsr)
            Toast.makeText(this, " User added Successfully now ${user.size} in total", Toast.LENGTH_LONG).show()
        }



             btCreate.setOnClickListener{
            Intent(this,AccountActivity::class.java).also{
                startActivity(it)
            }
        }


        textViewPass.setOnClickListener {
            val recipient = textEmail.text.toString()
            val subject = "Password Recovery"

            for (usr in user) {

                if (textEmail.text.toString() != null) {
                    if (usr.email.equals(textEmail.text.toString())) {
                        val body = "Here is your  password : ${usr.pass}"
                        val emailUri = Uri.parse("mailto:$recipient?subject=$subject&body=$body ")
                        val emailIntent = Intent(Intent.ACTION_SENDTO, emailUri)
                        if (emailIntent.resolveActivity(packageManager) != null) {
                            startActivity(emailIntent)
                        } else {
                            Toast.makeText(this,"No Email client Found",Toast.LENGTH_LONG).show()
                        }


                        //startActivity(Intent.createChooser(emailIntent, "Choose an email client:"))
                    }
                }


            }
        }

          //              for( usr in user){
//                  if(usr.email.equals(textEmail.text.toString()) && usr.pass.equals(textPass.text.toString()))
//                      Intent(this,ShoppingActivity::class.java).also {
//                          it.putExtra("EXTRA_EMAIL",email1)
//                          startActivity(it)
//                      }
//              }



    }
}

private fun Intent.getSerializable(s: String): Serializable? {
    return this.getSerializableExtra(s)
}
