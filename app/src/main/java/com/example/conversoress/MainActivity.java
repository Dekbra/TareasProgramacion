package com.example.conversoress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conversoress.R;

public class MainActivity extends AppCompatActivity {
    TabHost tbh;
    TextView tempVal;
    Spinner spn;
    Button btn;
    conversores objConversor = new conversores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhConversores);
        tbh.setup();
        tbh.addTab(tbh.newTabSpec("LON").setIndicator("LONGITUD", null).setContent(R.id.Longitud));
        tbh.addTab(tbh.newTabSpec("MON").setIndicator("MONEDAS", null).setContent(R.id.Divisas));
        tbh.addTab(tbh.newTabSpec("ALM").setIndicator("ALMACENAMIENTO", null).setContent(R.id.Almacenamiento));
        tbh.addTab(tbh.newTabSpec("DTS").setIndicator("Datos", null).setContent(R.id.Datos));
        tbh.addTab(tbh.newTabSpec("MSA").setIndicator("Masa", null).setContent(R.id.Masa));
        tbh.addTab(tbh.newTabSpec("VLM").setIndicator("Volumen", null).setContent(R.id.Volumen));
        tbh.addTab(tbh.newTabSpec("TMP").setIndicator("Tiempo", null).setContent(R.id.Tiempo));

        //botonLongitud
        btn = findViewById(R.id.btnCalcularLongitud);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //verificacion de si el edit text esta vacio
                EditText txtCantidadLongitud = findViewById(R.id.txtCantidadLongitud);
                String cantidadStr = txtCantidadLongitud.getText().toString().trim();
                if (cantidadStr.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor, ingrese una cantidad", Toast.LENGTH_SHORT).show();
                    return;
                }
                spn = findViewById(R.id.spnDeLongitud);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnALongitud);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadLongitud);
                double cantidad = Double.parseDouble(tempVal.getText().toString());
                double resp = objConversor.convertir(0, de, a, cantidad);

                Toast.makeText(getApplicationContext(), "Respuesta: " + resp, Toast.LENGTH_LONG).show();
            }
        });

        //botonMonedas
        btn = findViewById(R.id.btnCalcularMoneda);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //verificacion de si el edit text esta vacio
                EditText txtCantidadMoneda = findViewById(R.id.txtCantidadMoneda);
                String cantidadStr = txtCantidadMoneda.getText().toString().trim();
                if (cantidadStr.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor, ingrese una cantidad", Toast.LENGTH_SHORT).show();
                    return;
                }

                spn = findViewById(R.id.spnDeMoneda);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAMoneda);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadMoneda);

                double cantidad = Double.parseDouble(tempVal.getText().toString());
                double resp = objConversor.convertir(1, de, a, cantidad);

                Toast.makeText(getApplicationContext(), "Respuesta: " + resp, Toast.LENGTH_LONG).show();
            }
        });

        //botonAlmacenamiento
        btn = findViewById(R.id.btnCalcularAlmacenamiento);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verificacion de si el edit text esta vacio
                EditText txtCantidadAlmacenamiento = findViewById(R.id.txtCantidadAlmacenamiento);
                String cantidadStr = txtCantidadAlmacenamiento.getText().toString().trim();
                if (cantidadStr.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor, ingrese una cantidad", Toast.LENGTH_SHORT).show();
                    return;
                }
                spn = findViewById(R.id.spnDeAlmacenamiento);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAAlmacenamiento);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadAlmacenamiento);
                double cantidad = Double.parseDouble(tempVal.getText().toString());
                double resp = objConversor.convertir(2, de, a, cantidad);

                Toast.makeText(getApplicationContext(), "Respuesta: " + resp, Toast.LENGTH_LONG).show();
            }
        });

        //botonDatos
        btn = findViewById(R.id.btnCalcularDatos);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verificacion de si el edit text esta vacio
                EditText txtCantidadDatos = findViewById(R.id.txtCantidadDatos);
                String cantidadStr = txtCantidadDatos.getText().toString().trim();
                if (cantidadStr.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor, ingrese una cantidad", Toast.LENGTH_SHORT).show();
                    return;
                }
                spn = findViewById(R.id.spnDeDatos);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnADatos);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadDatos);
                double cantidad = Double.parseDouble(tempVal.getText().toString());
                double resp = objConversor.convertir(3, de, a, cantidad);

                Toast.makeText(getApplicationContext(), "Respuesta: " + resp, Toast.LENGTH_LONG).show();
            }
        });
        //botonMasa
        btn = findViewById(R.id.btnCalcularMasa);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verificacion de si el edit text esta vacio
                EditText txtCantidadMasa = findViewById(R.id.txtCantidadMasa);
                String cantidadStr = txtCantidadMasa.getText().toString().trim();
                if (cantidadStr.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor, ingrese una cantidad", Toast.LENGTH_SHORT).show();
                    return;
                }
                spn = findViewById(R.id.spnDeMasa);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAMasa);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadMasa);
                double cantidad = Double.parseDouble(tempVal.getText().toString());
                double resp = objConversor.convertir(4, de, a, cantidad);

                Toast.makeText(getApplicationContext(), "Respuesta: " + resp, Toast.LENGTH_LONG).show();
            }
        });

        //botonVolumen
        btn = findViewById(R.id.btnCalcularVolumen);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verificacion de si el edit text esta vacio
                EditText txtCantidadVolumen = findViewById(R.id.txtCantidadVolumen);
                String cantidadStr = txtCantidadVolumen.getText().toString().trim();
                if (cantidadStr.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor, ingrese una cantidad", Toast.LENGTH_SHORT).show();
                    return;
                }
                spn = findViewById(R.id.spnDeVolumen);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAVolumen);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadVolumen);
                double cantidad = Double.parseDouble(tempVal.getText().toString());
                double resp = objConversor.convertir(5, de, a, cantidad);

                Toast.makeText(getApplicationContext(), "Respuesta: " + resp, Toast.LENGTH_LONG).show();
            }
        });

        //botonTiempo
        btn = findViewById(R.id.btnCalcularTiempo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verificacion de si el edit text esta vacio
                EditText txtCantidadTiempo = findViewById(R.id.txtCantidadTiempo);
                String cantidadStr = txtCantidadTiempo.getText().toString().trim();
                if (cantidadStr.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor, ingrese una cantidad", Toast.LENGTH_SHORT).show();
                    return;
                }
                spn = findViewById(R.id.spnDeTiempo);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnATiempo);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadTiempo);
                double cantidad = Double.parseDouble(tempVal.getText().toString());
                double resp = objConversor.convertir(6, de, a, cantidad);

                Toast.makeText(getApplicationContext(), "Respuesta: " + resp, Toast.LENGTH_LONG).show();
            }
        });
    }


    class conversores {
        double[][] valores = {
                {1, 100, 39.3701, 3.28084, 1.193, 1.09361, 0.001, 0.000621371}, /*longitud*/
                {1.0, 0.84, 0.73, 110.59, 1.27, 0.92, 1.31, 1.38, 20.08, 6.35},  //divisas
                {1, 0.125, 0.000125, 1.25e-7, 1.25e-10, 1.25e-13, 1.25e-16}, //almacenamiento digital
                {1,0.001,0.0000001,0.0000000001,0.0000000000001}, //transferencia de datos
                {1, 1000, 2.20462, 35.274, 1000000, 1000000000, 0.001, 0.01}, //Masa
                {1, 1000, 0.001, 1000, 0.001308, 0.264172, 33.814, 0.00629}, //volumen
                {1000, 1, 0.01667, 0.0002778, 1.157E-5, 1.653E-6, 3.803E-7, 3.169E-8}//tiempo
        };

        public double convertir(int opcion, int de, int a, double cantidad) {
            return valores[opcion][a] / valores[opcion][de] * cantidad;
        }


    }
}