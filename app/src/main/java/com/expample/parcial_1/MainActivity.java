package com.expample.parcial_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conversoress.R;

public class MainActivity extends AppCompatActivity {

    TabHost tbh;
    Spinner spn;
    TextView tempVal;
    Button btn;
    conversores miObj = new conversores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tbh= findViewById(R.id.tbhParcial);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("MASA").setContent(R.id.tab_Area).setIndicator("Area",null));
        btn = findViewById(R.id.btnConvertirArea);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spn=findViewById(R.id.spnArea);
                int de = spn.getSelectedItemPosition();
                spn=findViewById(R.id.spnDArea);
                int a =spn.getSelectedItemPosition();
                tempVal=findViewById(R.id.txtCantidadArea);
                double cantidad = Double.parseDouble(tempVal.getText().toString());
                double respuesta = miObj.convertir(0,de,a,cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta "+ respuesta, Toast.LENGTH_SHORT).show();
            }
        });

    }


    class conversores{
        double[][] valores ={
                {1,10.763,1.43,1.19599,0.001590,0.0001434,0.0001}
        };
        public double convertir(int opcion,int de, int a, double cantidad){
            return valores[opcion][a]/valores[opcion][de]*cantidad;
        }
    };

}