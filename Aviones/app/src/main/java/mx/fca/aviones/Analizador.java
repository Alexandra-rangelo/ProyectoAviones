package mx.fca.aviones;

import java.util.ArrayList;
import java.util.HashMap;

//se encarga de gestionar el estado de los planos de aviones
// y calcular los movimientos y colisiones entre ellos
public class Analizador {

    static HashMap<Integer, Plano> memoria = new HashMap<>();

    //toma un objeto Plano y lo guarda en memoria con la clave 0,
    // que representa el estado inicial. Luego devuelve el plano inicial.
    public static Plano inicializa(Plano plano) {
        memoria.put(0, plano);
        return plano;
    }

    //calcula el siguiente estado de los aviones, detecta colisiones y guarda el nuevo estado.
    public static Plano next(int noPaso, Plano plano) {
        if (memoria.containsKey(noPaso)) {
            return memoria.get(noPaso);
        } else {
            Plano planoNuevo;
            ArrayList<Avion> nuevosAviones = new ArrayList<>();

            // Calcular movimiento y colisiones
            ArrayList<Colision> colisiones = new ArrayList<>();
            HashMap<String, Avion> posiciones = new HashMap<>();
            for (Avion avion : plano.aviones) {
                Avion nuevoAvion = new Avion(avion.direccion, avion.x, avion.y);
                switch (avion.direccion) {
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
                }
                String key = nuevoAvion.x + "," + nuevoAvion.y;
                if (posiciones.containsKey(key)) {
                    colisiones.add(new Colision(nuevoAvion.x, nuevoAvion.y));
                } else {
                    posiciones.put(key, nuevoAvion);
                }
                nuevosAviones.add(nuevoAvion);
            }
            planoNuevo = new Plano(noPaso, nuevosAviones, colisiones);
            memoria.put(noPaso, planoNuevo);
            return planoNuevo;
        }
    }

    //devuelve un estado anterior de los aviones.
    public static Plano prev(int noPaso) {
        return memoria.get(noPaso);
    }
}
