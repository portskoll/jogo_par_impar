package net.mundotela.aulajp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var  texto: TextView
    lateinit var  edtTexto: EditText
    lateinit var  edtNome: EditText
    lateinit var  edtTelefone: EditText
    lateinit var A : String
    lateinit var B : String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        A = getString(R.string.A)
        B = getString(R.string.B)

        texto = findViewById<TextView>(R.id.teste) as TextView;
        edtTexto = findViewById(R.id.edtTxt)
        edtNome = findViewById(R.id.edtTxtNome)
        edtTelefone = findViewById(R.id.edtTxtTelefone)
        var botao = findViewById<Button>(R.id.meu_buton);
        var btnenviar = findViewById<Button>(R.id.btnTexto);
        var cadastrar = findViewById<Button>(R.id.btnCadastrar);
        var jogar = findViewById<Button>(R.id.btn_jogar);

        botao.setOnClickListener {
            title = B
           if (texto.text.equals(A)){

               texto.text = B
               title = B
           }else{
               texto.text = A
               title = A
           }

        }

        btnenviar.setOnClickListener {
            Toast.makeText(this, edtTexto.text.toString(), Toast.LENGTH_SHORT).show()
        }

//        cadastrar.setOnClickListener {
//            val intent = Intent(this, Tela2Activity::class.java).apply {
//                putExtra("Nome", edtNome.text.toString())
//                putExtra("Telefone", edtTelefone.text.toString())
//            }
//            startActivity(intent)
//        }

        jogar.setOnClickListener {
            val intent = Intent(this, ActivityJogoParImpar::class.java)
            startActivity(intent)
        }




    }


}