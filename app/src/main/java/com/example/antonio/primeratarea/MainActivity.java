package com.example.antonio.primeratarea;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declaración de campos y variables.
    EditText posicion;
    TextView solucion;
    CalculaPrimos calculaPrimos = new CalculaPrimos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Añadimos icono a la barra de herramientas.
        toolbar.setLogo(R.mipmap.ic_launcher);
        // Asignamos a las variables los campos de la actividad.
        posicion = (EditText) findViewById(R.id.posicion);
        solucion = (TextView) findViewById(R.id.solucion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Controla la introducción de datos, lanza el método para calcular el
     * número primo y escribe la solución.
     * @param view Vista.
     */
    public void calcularPrimo(View view) {
        int pos;
        try {
            pos = Integer.parseInt(posicion.getText().toString());
            if (pos < 1 || pos > 999999) {
                Toast.makeText(this, "Introduce un número entre 1 y 999999", Toast.LENGTH_LONG).show();
            } else {
                int sol = calculaPrimos.devolverPrimos(pos);
                solucion.setText("El primo número " + pos + " es el " + sol);
                posicion.setText("");
            }
        } catch (NumberFormatException nfe) {
            Toast.makeText(this, "Introduce un número válido (1 - 999999)", Toast.LENGTH_LONG).show();
            posicion.setText("");
        }
    }
}
