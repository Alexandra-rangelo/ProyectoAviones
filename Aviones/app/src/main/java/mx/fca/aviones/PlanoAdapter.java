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

    private final ArrayList<Avion> aviones;
    private final ArrayList<Colision> colisiones;

    public PlanoAdapter(ArrayList<Avion> aviones, ArrayList<Colision> colisiones) {
        this.aviones = aviones;
        this.colisiones = colisiones;
    }

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

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AvionHolder) {
            Avion avion = aviones.get(position);
            ((AvionHolder) holder).imgAvion.setImageResource(avion.getImage());
        } else if (holder instanceof ColisionHolder) {
            ((ColisionHolder) holder).imgColision.setImageResource(R.mipmap.collision);
        }
    }

    @Override
    public int getItemCount() {
        return aviones.size();
    }
}

class ColisionHolder extends RecyclerView.ViewHolder {
    ImageView imgColision;

    public ColisionHolder(@NonNull View itemView) {
        super(itemView);
        imgColision = itemView.findViewById(R.id.imgColision);
    }


}