package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Github_act extends AppCompatActivity {

    private Spinner spn;
    private TextView tv;
    private String[] precios = new String[]{"7000", "22000", "45000","88000","156000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);

        spn = (Spinner) findViewById(R.id.spn);
        tv = (TextView) findViewById(R.id.tv);

        Bundle dat = getIntent().getExtras();
        String[] lista = dat.getStringArray("Cositas");

        ArrayAdapter adapt = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, lista);
        spn.setAdapter(adapt);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(spn.getSelectedItem().equals("Farenheit"))
                {
                    String precio = precios[0];
                    int pc = Integer.parseInt(precio);
                    tv.setText("El Valor de Farenheit es: "+ pc);
                }

                if(spn.getSelectedItem().equals("Revival"))
                {
                    String precioRevival = precios[1];
                    int Pr = Integer.parseInt(precioRevival);
                    tv.setText("El Valor de Revival es: "+ Pr);
                }

                if(spn.getSelectedItem().equals("El Alquimista"))
                {

                    String precioTesla = precios[2];
                    int Pt = Integer.parseInt(precioTesla);
                    tv.setText("El Valor de El Alquimista es: " + Pt);
                }

                if (spn.getSelectedItem().equals("El Poder"))
                {
                    String PrecioElPoder = precios[3];
                    int Pel = Integer.parseInt(PrecioElPoder);
                    tv.setText("El Valor de El Poder es: " + Pel);
                }

                if (spn.getSelectedItem().equals("Despertar"))

                {
                    String PrecioDespertar = precios[4];
                    int Pd = Integer.parseInt(PrecioDespertar);
                    tv.setText("El Valor de Despertar es: "+ Pd);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void Informacion(View v)
    {
    }
}
