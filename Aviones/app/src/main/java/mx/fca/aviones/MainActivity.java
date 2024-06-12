package mx.fca.aviones;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    Button btnNext;
    Button btnBack;
    Button btnReset;
    Plano plano;
    Plano planoInicial;
    RecyclerView listaAviones;
    AvionAdapter adapter;
    TextView txtVColisiones;
    int noPaso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaAviones = findViewById(R.id.listaAviones);
        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);
        btnReset = findViewById(R.id.btnReset);
        txtVColisiones = findViewById(R.id.txtVColisiones);

        planoInicial = Planificador.crearRutaInicial();
        plano = planoInicial;

        adapter = new AvionAdapter(plano.getFullGrid());
        listaAviones.setAdapter(adapter);
        listaAviones.setLayoutManager(new AutoFitGridLayoutManager(this, 100));

        btnNext.setOnClickListener(v -> {
            noPaso++;
            plano = Analizador.next(noPaso, plano);
            adapter.setElementos(plano.getFullGrid());
            adapter.notifyDataSetChanged();
            txtVColisiones.setText("Colisiones: " + plano.colisiones.size());
        });

        btnBack.setOnClickListener(v -> {
            if (noPaso > 0) {
                noPaso--;
                plano = Analizador.prev(noPaso);
                adapter.setElementos(plano.getFullGrid());
                adapter.notifyDataSetChanged();
                txtVColisiones.setText("Colisiones: " + plano.colisiones.size());
            }
        });

        btnReset.setOnClickListener(v -> {
            noPaso = 0;
            plano = planoInicial;
            Analizador.inicializa(planoInicial); // Restablece el estado inicial en el analizador
            adapter.setElementos(plano.getFullGrid());
            adapter.notifyDataSetChanged();
            txtVColisiones.setText("Colisiones: 0");
        });
    }
}
