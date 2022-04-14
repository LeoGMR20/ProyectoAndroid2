package com.example.ProyectoAndroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResultado, tvResultadoInvertir;
    private Button btnMostrar, btnInvertir;
    private EditText etNombre, etCelular;

    private String nombre;
    private int celular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        /*
          van a configurar al botón para que este pendiente
          de un evento en pantalla, en este caso, el evento
          de que un usuario haga click al boton

          Parámetro de la función espera que le mandes
          tu lógica desarrollada que quieres que se aplique
          cada que el usuario haga click
        */
        btnMostrar.setOnClickListener(this);
        btnInvertir.setOnClickListener(this);
    }

    private void inicializarVistas() {
        /*
        Incializamos vistas y referenciamos nuestros
        componentes visuales diseñados con los atributos
        o variables que hemos creado
        */

        tvResultado = findViewById(R.id.tvResultado);
        tvResultadoInvertir = findViewById(R.id.tvResultadoInvertir);
        btnMostrar = findViewById(R.id.btnMostrar);
        etNombre = findViewById(R.id.etNombre);
        etCelular = findViewById(R.id.etCelular);
        btnInvertir = findViewById(R.id.btnInvertir);
    }

    private void obtenerValores(){
        /*
        Como obtener los datos que el usuario
        ingresó al componente de texto
        */
        nombre = etNombre.getText().toString();
        // to.String() -> devuleve la cadena de texto del campo referido
        String celularTexto = etCelular.getText().toString();
        //Usar conocimiento de Java para parsear una variable
        celular = Integer.parseInt(celularTexto);
    }

    private void mostrarTexto(){
        tvResultado.setText("Nombre: " + this.nombre +
                "\nCelular: " + this.celular);
        tvResultadoInvertir.setText("");
    }

    private void invertirNumero(){
        //invertir número
        //12345 -> 54321
        int resto = 0, invertido = 0;
        while (this.celular > 0){
            resto = this.celular % 10;
            invertido = invertido * 10 + resto;
            this.celular = this.celular / 10;
        }
        tvResultadoInvertir.setText("Invertido: "+invertido);
    }

    @Override
    public void onClick(View view) {
        /*
        El parámetro view es un objeto que recibe
        la información del componente visual
        que el usuario ha presionado en pantalla
        si presiona el botón invertir view es igual a ese botón
        y de ese botón umotra vista pueden obtener información
        como por ejemplo el atributo que los identifica como algo único
        */
        obtenerValores();
        switch (view.getId()){
            case R.id.btnMostrar:
                mostrarTexto();
                break;
            case R.id.btnInvertir:
                invertirNumero();
                break;
        }

    }
}