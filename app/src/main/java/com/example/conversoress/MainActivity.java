package com.example.conversoress;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.conversoress.R;

public class MainActivity extends AppCompatActivity {

    TabHost tbh;
    Spinner spnArea, spnDArea;
    TextView tvResultadoAgua, txtMetrosConsumidos;
    EditText txtCantidadArea;
    Button btnConvertirArea, btnCalcularAgua; // Eliminado btnRealizarConversion y nuevoButton ya que no están en el diseño XML
    Conversores miObj = new Conversores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhParcial);
        tbh.setup();

        // Pestaña "Calcular Metros Consumidos por Agua"
        tbh.addTab(tbh.newTabSpec("CalcularAgua").setContent(R.id.tab_CalcularAgua).setIndicator("Calcular Agua", null));
        btnCalcularAgua = findViewById(R.id.btnCalcularAgua);
        txtMetrosConsumidos = findViewById(R.id.txtMetrosConsumidos);
        tvResultadoAgua = findViewById(R.id.tvResultadoAgua);

        // Pestaña "Conversor"
        tbh.addTab(tbh.newTabSpec("Conversor").setContent(R.id.tab_Conversor).setIndicator("Conversor", null));

        ArrayAdapter<CharSequence> adapterArea = ArrayAdapter.createFromResource(this,
                R.array.spnARea, android.R.layout.simple_spinner_item);
        adapterArea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnArea = findViewById(R.id.spnArea);
        spnArea.setAdapter(adapterArea);

        spnDArea = findViewById(R.id.spnDArea);
        spnDArea.setAdapter(adapterArea);

        // Inicializar componentes para la pestaña "Conversor"
        ArrayAdapter<CharSequence> adapterUnidades = ArrayAdapter.createFromResource(this,
                R.array.spnARea, android.R.layout.simple_spinner_item);
        adapterUnidades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        txtCantidadArea = findViewById(R.id.txtCantidadArea);

        btnConvertirArea = findViewById(R.id.btnConvertirArea);

        btnConvertirArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int de = spnArea.getSelectedItemPosition();
                int a = spnDArea.getSelectedItemPosition();
                double cantidad = Double.parseDouble(txtCantidadArea.getText().toString());
                double respuesta = miObj.convertir(0, de, a, cantidad);
                tvResultadoAgua.setText("Resultado: " + respuesta);
                Toast.makeText(getApplicationContext(), "Respuesta " + respuesta, Toast.LENGTH_SHORT).show();
            }
        });

        btnCalcularAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén los metros consumidos desde el EditText
                double metrosConsumidos = Double.parseDouble(txtMetrosConsumidos.getText().toString());

                // Calcula el costo del agua utilizando el método en la clase Conversores
                double costoAgua = miObj.calcularCostoAgua(metrosConsumidos);

                // Muestra el resultado en el TextView
                tvResultadoAgua.setText("Costo del agua: $" + costoAgua);
            }
        });
    }

    // Clase Conversores ahora es estática
    static class Conversores {
        double[][] valores = {
                {1, 10.763, 1.43, 1.19599, 0.001590, 0.0001434, 0.0001}
        };

        public double convertir(int opcion, int de, int a, double cantidad) {
            return valores[opcion][a] / valores[opcion][de] * cantidad;
        }

        public double calcularCostoAgua(double metrosConsumidos) {
            double cuotaFija = 6.0;
            double tarifaAdicionalPrimeraParte = 0.45;
            double tarifaAdicionalSegundaParte = 0.65;
            int limitePrimeraParte = 18;
            int limiteSegundaParte = 28;

            // Si la cantidad de metros consumidos está en la primera parte
            if (metrosConsumidos <= limitePrimeraParte) {
                return cuotaFija; // Cuota fija
            }

            // Si la cantidad de metros consumidos está en la segunda parte
            if (metrosConsumidos <= limiteSegundaParte) {
                // Resta el límite superior
                double metrosExcedidos = metrosConsumidos - limitePrimeraParte;

                // Calcula la tarifa adicional para los primeros metros
                double tarifaAdicionalPrimera = metrosExcedidos * tarifaAdicionalPrimeraParte;

                // Suma la cuota fija y la tarifa adicional
                return cuotaFija + tarifaAdicionalPrimera;
            }

            // Si la cantidad de metros consumidos está en la tercera parte
            // Resta el límite superior
            double metrosExcedidos = metrosConsumidos - limiteSegundaParte;

            // Calcula la tarifa adicional para los primeros metros
            double tarifaAdicionalPrimera = (limiteSegundaParte - limitePrimeraParte) * tarifaAdicionalPrimeraParte;

            // Calcula la tarifa adicional para los metros restantes
            double tarifaAdicionalSegunda = metrosExcedidos * tarifaAdicionalSegundaParte;

            // Suma la cuota fija y las tarifas adicionales
            return cuotaFija + tarifaAdicionalPrimera + tarifaAdicionalSegunda;
        }

        public double realizarConversion(String unidad, double valor) {
            double resultado = 0.0;
            // Agrega la lógica de conversión según tus requisitos
            return resultado;
        }
    }
}