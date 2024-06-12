package mx.fca.aviones;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

//actividad principal de la aplicación.

public class MainActivity extends AppCompatActivity {

    Button btnNext;
    Button btnBack;
    Button btnReset;
    Plano plano; //Variable que almacena el estado actual de los aviones.
    Plano planoInicial; // Variable que almacena el estado inicial de los avione
    RecyclerView listaAviones; // Vista que muestra los aviones.
    AvionAdapter adapter;  //Adaptador para el RecyclerView que maneja la visualización de los aviones.
    TextView txtVColisiones;
    int noPaso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //// Establece el diseño de la actividad desde un archivo XML


        //gestiona los eventos de los botones para avanzar,
        // retroceder y restablecer el estado de los aviones
        listaAviones = findViewById(R.id.listaAviones);
        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);
        btnReset = findViewById(R.id.btnReset);
        txtVColisiones = findViewById(R.id.txtVColisiones);

        //crear un plano inicial y lo asigna a la variable plano.
        planoInicial = Planificador.crearRutaInicial();
        plano = planoInicial;

        // Crea un nuevo adaptador de aviones utilizando el plano inicial y lo establece en el RecyclerView
        adapter = new AvionAdapter(plano.getFullGrid());
        listaAviones.setAdapter(adapter);
        listaAviones.setLayoutManager(new AutoFitGridLayoutManager(this, 100));

        //Asigna un listener al botón "Next" para avanzar al siguiente paso. Actualiza el plano y el adaptador con el nuevo estado,
        // y actualiza el texto del TextView con el número de colisiones.
        btnNext.setOnClickListener(v -> {
            noPaso++; //Incrementa el contador
            plano = Analizador.next(noPaso, plano); //Llama al método next del Analizador para calcular el siguiente estado del plano
            adapter.setElementos(plano.getFullGrid()); //Actualiza el adaptador
            adapter.notifyDataSetChanged(); //notifica los cambio
            txtVColisiones.setText("Colisiones: " + plano.colisiones.size()); //muestra el número de colisiones.
        });

        //Asigna un listener al botón "Back" para retroceder al paso anterior si es posible. Actualiza el plano y el adaptador con el estado anterior,
        // y actualiza el texto del TextView con el número de colisiones.
        btnBack.setOnClickListener(v -> {
            if (noPaso > 0) { //Disminuye el contador noPaso si es mayor que 0
                noPaso--;
                plano = Analizador.prev(noPaso); //obtener el estado anterior del plano.
                adapter.setElementos(plano.getFullGrid());
                adapter.notifyDataSetChanged();
                txtVColisiones.setText("Colisiones: " + plano.colisiones.size()); //mostrar el número de colisiones
            }
        });

        //Asigna un listener al botón "Reset" para restablecer el estado de los aviones al estado inicial. Actualiza el plano,
        // el adaptador y el texto del TextView para reflejar este estado inicial.
        btnReset.setOnClickListener(v -> {
            noPaso = 0; //Restablece el contador noPaso a 0
            plano = planoInicial; //Asigna el estado inicial
            Analizador.inicializa(planoInicial); // Restablece el estado inicial en el analizador
            adapter.setElementos(plano.getFullGrid());
            adapter.notifyDataSetChanged();
            txtVColisiones.setText("Colisiones: 0"); //muestra 0 ocolisiones
        });
    }
}
