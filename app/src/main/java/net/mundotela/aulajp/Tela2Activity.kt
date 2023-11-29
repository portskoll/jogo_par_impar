package net.mundotela.aulajp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Tela2Activity : AppCompatActivity() {

    lateinit var  textoEnviado: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)
        val botaoVoltar = findViewById<Button>(R.id.btn_voltar)
        textoEnviado = findViewById(R.id.txtCadastro)

        val usuario = intent.getStringExtra("Nome")
        val telefone = intent.getStringExtra("Telefone")

        textoEnviado.text = "Recebi o seu cadastro com o nome : $usuario e o Telefone: $telefone"



        botaoVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

    }
}