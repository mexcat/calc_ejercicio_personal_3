package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var tvResultado: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResultado = findViewById(R.id.tv_result)

        //nombres de variables no pueden tener underscore
        val primerNumero = findViewById<EditText>(R.id.et_num_uno)
        val segundoNumero = findViewById<EditText>(R.id.et_num_dos)
        val suma = findViewById<Button>(R.id.btn_suma)
        val resta = findViewById<Button>(R.id.btn_resta)
        val multiplicacion = findViewById<Button>(R.id.btn_multiplica)
        val dividir = findViewById<Button>(R.id.btn_divide)
        val salir = findViewById<Button>(R.id.btn_exit)

        clear(primerNumero, segundoNumero)
        primerNumero.setOnClickListener { suma(primerNumero, segundoNumero) }
        suma.setOnClickListener { suma(primerNumero, segundoNumero) }
        resta.setOnClickListener { resta(primerNumero, segundoNumero) }
        multiplicacion.setOnClickListener { multiplicacion(primerNumero, segundoNumero) }
        dividir.setOnClickListener { divide(primerNumero, segundoNumero) }
        salir.setOnClickListener { finish() }
    }

    private fun divide(primer_numero: EditText, segundo_numero: EditText) {
        //negar un .isEmpty con exclamacion para que? si tenemos un  .isNotEmpty

        if (primer_numero.text.toString().isNotEmpty() || segundo_numero.text.toString().isNotEmpty()) {
            error("los números no pueden ir vacios")
        } else if (segundo_numero.text.toString() == "0") {
            error("No se puede dividir por cero")
        } else {
            //conversion directa a Double
            val primer = primer_numero.text.toString().toDouble()
            val segundo = segundo_numero.text.toString().toDouble()
            val res = (primer / segundo).toString()
            mostrar(res, "división", primer_numero, segundo_numero)
        }
    }

    private fun multiplicacion(primer_numero: EditText, segundo_numero: EditText) {
        //negar un .isEmpty con exclamacion para que? si tenemos un  .isNotEmpty
        if (primer_numero.text.toString().isNotEmpty() && segundo_numero.text.toString().isNotEmpty()) {
            val primer = primer_numero.text.toString().toInt()
            val segundo = segundo_numero.text.toString().toInt()
            val res = (primer * segundo).toString()
            mostrar(res, "multiplicación", primer_numero, segundo_numero)
        } else {
            error("los números no pueden ir vacios")
        }
    }

    private fun resta(primer_numero: EditText, segundo_numero: EditText) {
        if (primer_numero.text.toString().isNotEmpty() && segundo_numero.text.toString().isNotEmpty()) {
            val primer = primer_numero.text.toString().toInt()
            val segundo = segundo_numero.text.toString().toInt()
            val res = (primer - segundo).toString()
            mostrar(res, "resta", primer_numero, segundo_numero)
        } else {
            error("los números no pueden ir vacios")
        }
    }

    private fun suma(primer_numero: EditText, segundo_numero: EditText) {
        if (primer_numero.text.toString().isNotEmpty() && segundo_numero.text.toString().isNotEmpty()) {
            val primer = primer_numero.text.toString().toInt()
            val segundo = segundo_numero.text.toString().toInt()
            val res = (primer + segundo).toString()
            mostrar(res, "suma", primer_numero, segundo_numero)
        } else {
            error("los números no pueden ir vacios")
        }
    }

    private fun mostrar(
        resultado: String,
        funcion: String,
        primer_numero: EditText,
        segundo_numero: EditText
    ) {
        tvResultado!!.text = resultado
        tvResultado!!.visibility = View.VISIBLE
        Toast.makeText(baseContext, "El resultado de la $funcion es $resultado", Toast.LENGTH_LONG)
            .show()
        clear(primer_numero, segundo_numero)
    }

    private fun error(errorText: String) {
        Toast.makeText(baseContext, errorText, Toast.LENGTH_LONG).show()
    }

    private fun clear(primerNumero: EditText, segundoNumero: EditText) {
        primerNumero.setText("")
        segundoNumero.setText("")
    }
}