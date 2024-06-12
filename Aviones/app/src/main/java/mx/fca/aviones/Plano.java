package mx.fca.aviones;

import java.util.ArrayList;
import java.util.HashMap;

public class Plano {

    public ArrayList<Avion> aviones;
    public ArrayList<Colision> colisiones;
    public int col;
    public int row;
    public int noPaso;

    // Constructor
    // inicializa sus atributos con los valores proporcionados. Calcula el número máximo de columnas (col) y filas (row)
    // en función de las coordenadas de los aviones presentes en el plano.
    Plano(int noPaso, ArrayList<Avion> aviones, ArrayList<Colision> colisiones) {
        this.noPaso = noPaso;
        this.aviones = aviones;
        this.colisiones = colisiones;

        int tmpX = 0;
        int tmpY = 0;
        for (Avion avion: aviones) {
            if (avion.x > tmpX) {
                tmpX = avion.x;
            }
            if (avion.y > tmpX) {
                tmpY = avion.y;
            }
        }
        col = tmpX;
        row = tmpY;
    }

    //genera una representación completa del plano en forma de una lista (ArrayList) llamada fullGrid
    public ArrayList<Object> getFullGrid() { //representar visualmente el estado del plano en una interfaz de usuario, como una cuadrícula.
        HashMap<String, Object> grid = new HashMap<>(); // mapear las posiciones

        // Agregar aviones al grid
        for (Avion avion : aviones) {
            String key = avion.x + "," + avion.y;
            grid.put(key, avion);
        }

        // Agregar colisiones al grid
        for (Colision colision : colisiones) {
            String key = colision.x + "," + colision.y;
            grid.put(key, colision);
        }

        // Crear una lista completa con todos los elementos en el grid
        ArrayList<Object> fullGrid = new ArrayList<>();
        for (int y = 0; y <= row; y++) {
            for (int x = 0; x <= col; x++) {
                String key = x + "," + y;
                if (grid.containsKey(key)) {
                    fullGrid.add(grid.get(key));
                } else {
                    fullGrid.add(null);
                }
            }
        }
        return fullGrid;
    }
}
