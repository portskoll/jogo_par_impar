package net.mundotela.aulajp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class ActivityJogoParImpar : AppCompatActivity() {

    var resultado = 0
    private var score = 0
    lateinit var txtResultado: TextView
    lateinit var btnNovo: Button
    lateinit var btnPar: Button
    lateinit var btnImpar: Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo_par_impar)

        val sharedPref =  this?.getPreferences(Context.MODE_PRIVATE) ?: return
        score = sharedPref.getInt("SCORE",0)


        btnNovo = findViewById(R.id.btnNovoJogo)
        btnPar = findViewById(R.id.btnPar)
        btnImpar = findViewById(R.id.btnImpar)
        txtResultado = findViewById(R.id.txtResultado)


        btnNovo.setOnClickListener {
            novoJogo()
        }

        btnPar.setOnClickListener {
            jogada(btnPar)
        }
        btnImpar.setOnClickListener {
            jogada(btnImpar)
        }

        novoJogo()
    }

    private fun novoJogo() {
        txtResultado.text = "Par ou Impar?"
        resultado = Random.nextInt(0, 10)
        btnNovo.visibility = View.INVISIBLE
        btnImpar.visibility = View.VISIBLE
        btnPar.visibility = View.VISIBLE
    }

    fun jogada(view: View) {
        btnImpar.visibility = View.INVISIBLE
        btnPar.visibility = View.INVISIBLE

        if (resultado % 2 == view.tag.toString().toInt()){

            Toast.makeText(this, "Ganhou!", Toast.LENGTH_SHORT).show()
            if (btnNovo.visibility == View.INVISIBLE) {
                score++
                getPreferences(MODE_PRIVATE).edit().putInt("SCORE", score).commit()


            }
        }else {
            Toast.makeText(this, "Perdeu!", Toast.LENGTH_SHORT).show()
        }
        title = "Score:  $score"
        txtResultado.text = "$resultado"
        btnNovo.visibility = View.VISIBLE
    }


}

