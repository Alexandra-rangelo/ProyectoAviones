package mx.fca.aviones;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

//todo estos es agregado

public class PlanoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //Declara dos listas de aviones y colisiones y un constructor para inicializarlas.
    private final ArrayList<Avion> aviones;
    private final ArrayList<Colision> colisiones;

    public PlanoAdapter(ArrayList<Avion> aviones, ArrayList<Colision> colisiones) {
        this.aviones = aviones;
        this.colisiones = colisiones;
    }
    //determina el tipo de vista que se debe mostrar en una posición específica. Devuelve 1 si hay una colisión en la posición dada,
    // de lo contrario, devuelve 0 para indicar que hay un avión.
    @Override
    public int getItemViewType(int position) {
        // Return 1 for collisions, 0 for planes
        for (Colision colision : colisiones) {
            if (position == colision.y * 5 + colision.x) {
                return 1;
            }
        }
        return 0;
    }

    //Este método crea y devuelve un nuevo ViewHolder
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            View view = inflater.inflate(R.layout.colision_view, parent, false);
            return new ColisionHolder(view);
        } else {
            View view = inflater.inflate(R.layout.avion_view, parent, false);
            return new AvionHolder(view);
        }
    }

    //Configura la vista correspondiente con los datos adecuados según el tipo de vista (avión o colisión).
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AvionHolder) {
            Avion avion = aviones.get(position);
            ((AvionHolder) holder).imgAvion.setImageResource(avion.getImage());
        } else if (holder instanceof ColisionHolder) {
            ((ColisionHolder) holder).imgColision.setImageResource(R.mipmap.collision);
        }
    }
    //devuelve el número total de elementos en la lista de aviones, que es el tamaño de la lista de aviones.
    @Override
    public int getItemCount() {
        return aviones.size();
    }
}
//mantener referencias a las vistas de un elemento de la lista que representa una colisión.
class ColisionHolder extends RecyclerView.ViewHolder {
    ImageView imgColision;

    public ColisionHolder(@NonNull View itemView) {
        super(itemView);
        imgColision = itemView.findViewById(R.id.imgColision);
    }


}