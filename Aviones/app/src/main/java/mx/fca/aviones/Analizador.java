package mx.fca.aviones;

import java.util.ArrayList;
import java.util.HashMap;

//se encarga de gestionar el estado de los planos de aviones
// y calcular los movimientos y colisiones entre ellos
public class Analizador {

    static HashMap<Integer, Plano> memoria = new HashMap<>();

    //toma un objeto Plano y lo guarda en memoria con la clave 0,
    // que representa el estado inicial. Luego devuelve el plano inicial.
    public static Plano inicializa(Plano plano) { // Método para inicializar el plano en el estado inicial
        memoria.put(0, plano); //Guarda el plano inicial en el mapa memoria con la clave 0.
        return plano; //Devuelve el plano inicial.
    }

    //calcula el siguiente estado de los aviones, detecta colisiones y guarda el nuevo estado.
    public static Plano next(int noPaso, Plano plano) {
        if (memoria.containsKey(noPaso)) {
            return memoria.get(noPaso);
        } else {
            Plano planoNuevo;
            ArrayList<Avion> nuevosAviones = new ArrayList<>(); //Crea una lista para los nuevos aviones.

            // Calcular movimiento y colisiones
            ArrayList<Colision> colisiones = new ArrayList<>(); //Crea una lista para las colisiones detectadas.
            HashMap<String, Avion> posiciones = new HashMap<>(); //Crea un mapa para rastrear las posiciones de los aviones.
            for (Avion avion : plano.aviones) {
                Avion nuevoAvion = new Avion(avion.direccion, avion.x, avion.y);
                switch (avion.direccion) { //Actualiza la posición del avión basado en su dirección.
                    case NORTH:
                        nuevoAvion.y -= 1;
                        break;
                    case SOUTH:
                        nuevoAvion.y += 1;
                        break;
                    case EAST:
                        nuevoAvion.x += 1;
                        break;
                    case WEST:
                        nuevoAvion.x -= 1;
                        break;
                } //Genera una clave para la posición del avión.
                String key = nuevoAvion.x + "," + nuevoAvion.y;
                //Verifica si la clave generada (que representa la posición del avión) ya existe en el mapa posiciones.
                if (posiciones.containsKey(key)) { //Detecta colisiones si otro avión ya está en la misma posición.
                    //Si la clave ya existe en el mapa posiciones, significa que otro avión ya está en esa posición, lo que indica una colisión
                    colisiones.add(new Colision(nuevoAvion.x, nuevoAvion.y)); //Se crea un objeto Colision con las coordenadas x e y y se añade a la lista de colisiones.
                } else { //se añade la clave y el avión al mapa, indicando que esta posición ahora está ocupada por este avión
                    posiciones.put(key, nuevoAvion);
                }
                nuevosAviones.add(nuevoAvion); //Añade el nuevo avión a la lista de nuevos aviones.
            }
            planoNuevo = new Plano(noPaso, nuevosAviones, colisiones); //Crea un nuevo plano con los aviones y colisiones calculadas.
            memoria.put(noPaso, planoNuevo); //Guarda el nuevo plano en memoria
            return planoNuevo; //Devuelve el nuevo plano.
        }
    }

    //devuelve un estado anterior de los aviones.
    public static Plano prev(int noPaso) {
        return memoria.get(noPaso);
    }
}
