package mx.fca.aviones;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Gestiona una lista de elementos (Avion, Colision, o espacios vacíos) y proporciona las vistas adecuadas para un RecyclerView.
public class AvionAdapter extends RecyclerView.Adapter<AvionAdapter.ViewHolder> {

    ArrayList<Object> elementos;

    public AvionAdapter(ArrayList<Object> elementos) {
        this.elementos = elementos;
    }

    public void setElementos(ArrayList<Object> elementos) {
        this.elementos = elementos;
    }

    //Infla la vista para cada elemento.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.elemento_view, parent, false);
        return new ViewHolder(view);
    }

    //Vincula los datos de un elemento a la vista.
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

    //Devuelve el número total de elementos.
    @Override
    public int getItemCount() {
        return elementos.size();
    }

    // Gestiona las referencias de las vistas de cada elemento en el RecyclerView.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgElemento;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgElemento = itemView.findViewById(R.id.imgElemento);
        }
    }
}
