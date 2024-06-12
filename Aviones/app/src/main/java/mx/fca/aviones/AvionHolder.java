package mx.fca.aviones;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AvionHolder extends RecyclerView.ViewHolder {
    //Mantiene una referencia a la vista de imagen (ImageView) que se utilizará para mostrar la imagen de un avión.
    ImageView imgAvion;
    public AvionHolder(@NonNull View itemView) {
        super(itemView);
        imgAvion = itemView.findViewById(R.id.imgAvion);
    }
}
