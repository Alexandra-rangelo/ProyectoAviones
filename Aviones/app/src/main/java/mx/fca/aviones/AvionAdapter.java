package mx.fca.aviones;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AvionAdapter extends RecyclerView.Adapter<AvionAdapter.ViewHolder> {

    ArrayList<Object> elementos;

    public AvionAdapter(ArrayList<Object> elementos) {
        this.elementos = elementos;
    }

    public void setElementos(ArrayList<Object> elementos) {
        this.elementos = elementos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.elemento_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Object elemento = elementos.get(position);
        if (elemento instanceof Avion) {
            Avion avion = (Avion) elemento;
            holder.imgElemento.setImageResource(avion.getImage());
        } else if (elemento instanceof Colision) {
            Colision colision = (Colision) elemento;
            holder.imgElemento.setImageResource(colision.getImage());
        } else {
            holder.imgElemento.setImageResource(android.R.color.transparent); // Espacio vacío
        }
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgElemento;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgElemento = itemView.findViewById(R.id.imgElemento);
        }
    }
}
