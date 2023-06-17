package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText primer_numero = findViewById(R.id.et_num_uno);
        EditText segundo_numero = findViewById(R.id.et_num_dos);

        tvResultado = findViewById(R.id.tv_result);
        Button suma = findViewById(R.id.btn_suma);
        Button resta = findViewById(R.id.btn_resta);
        Button multiplicacion = findViewById(R.id.btn_multiplica);
        Button dividir = findViewById(R.id.btn_divide);
        Button salir = findViewById(R.id.btn_exit);

        clear(primer_numero, segundo_numero);

        primer_numero.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { suma(primer_numero,segundo_numero);}});
        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { suma(primer_numero,segundo_numero);}});

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { resta(primer_numero,segundo_numero);}
        });

        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { multiplicacion(primer_numero,segundo_numero);}
        });

        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { divide(primer_numero,segundo_numero);}
        });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish();}
        });

    }
    private void divide(EditText primer_numero, EditText segundo_numero) {


        if(primer_numero.getText().toString().isEmpty() || segundo_numero.getText().toString().isEmpty() ) {
            error("los números no pueden ir vacios");
        }else if(segundo_numero.getText().toString().equals("0")){
            error("No se puede dividir por cero");
        }else{
            Integer primer = Integer.parseInt(primer_numero.getText().toString());
            Integer segundo = Integer.parseInt(segundo_numero.getText().toString());

            String res = String.valueOf((primer/segundo));
            mostrar(res, "división", primer_numero, segundo_numero);
        }
    }

    private void multiplicacion(EditText primer_numero, EditText segundo_numero) {
        if(!primer_numero.getText().toString().isEmpty()  && !segundo_numero.getText().toString().isEmpty()){
            Integer primer = Integer.parseInt(primer_numero.getText().toString());
            Integer segundo = Integer.parseInt(segundo_numero.getText().toString());

            String res = String.valueOf((primer * segundo));
            mostrar(res, "multiplicación", primer_numero, segundo_numero);
        }else{
            error("los números no pueden ir vacios");
        }
    }

    private void resta(EditText primer_numero, EditText segundo_numero) {
        if(!primer_numero.getText().toString().isEmpty()  && !segundo_numero.getText().toString().isEmpty()){
            Integer primer = Integer.parseInt(primer_numero.getText().toString());
            Integer segundo = Integer.parseInt(segundo_numero.getText().toString());

            String res = String.valueOf((primer - segundo));
            mostrar(res, "resta", primer_numero, segundo_numero);
        }else{
            error("los números no pueden ir vacios");
        }
    }

    private void suma(EditText primer_numero, EditText segundo_numero) {
        if(!primer_numero.getText().toString().isEmpty()  && !segundo_numero.getText().toString().isEmpty()){
            Integer primer = Integer.parseInt(primer_numero.getText().toString());
            Integer segundo = Integer.parseInt(segundo_numero.getText().toString());

            String res = String.valueOf((primer + segundo));
            mostrar(res, "suma", primer_numero, segundo_numero);
        }else{
            error("los números no pueden ir vacios");
        }
    }

    private void mostrar(String resultado,String funcion,EditText primer_numero, EditText segundo_numero){
        tvResultado.setText(resultado);
        tvResultado.setVisibility(View.VISIBLE);
        Toast.makeText(getBaseContext(), "El resultado de la "+funcion+" es "+resultado , Toast.LENGTH_LONG).show();
        clear(primer_numero, segundo_numero);
    }
    private void error(String errorText){
        Toast.makeText(getBaseContext(), errorText , Toast.LENGTH_LONG).show();
    }

    private void clear(EditText primer_numero, EditText segundo_numero){
        primer_numero.setText("");
        segundo_numero.setText("");
    }
}