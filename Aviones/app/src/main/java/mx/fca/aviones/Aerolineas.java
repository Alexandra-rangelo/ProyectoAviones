package mx.fca.aviones;

import java.util.ArrayList;

public class Aerolineas {

    public static ArrayList<Avion> AEROMEXICO(){
        ArrayList<Avion> aviones = new ArrayList<>();
        aviones.add(new Avion(Direccion.EAST, 1, 0));
        aviones.add(new Avion(Direccion.EAST, 1, 1));
        aviones.add(new Avion(Direccion.WEST, 1, 2));
        aviones.add(new Avion(Direccion.SOUTH, 1, 3));
        aviones.add(new Avion(Direccion.WEST, 1, 4));
        aviones.add(new Avion(Direccion.NORTH, 2, 0));
        aviones.add(new Avion(Direccion.WEST, 2, 1));
        aviones.add(new Avion(Direccion.SOUTH, 2, 2));
        aviones.add(new Avion(Direccion.WEST, 2, 3));
        aviones.add(new Avion(Direccion.EAST, 2, 4));
        aviones.add(new Avion(Direccion.WEST, 3, 1));
        aviones.add(new Avion(Direccion.SOUTH, 3, 2));
        aviones.add(new Avion(Direccion.WEST, 3, 3));
        aviones.add(new Avion(Direccion.NORTH, 4, 0));
        aviones.add(new Avion(Direccion.WEST, 4, 1));
        aviones.add(new Avion(Direccion.SOUTH, 4, 2));
        aviones.add(new Avion(Direccion.WEST, 4, 3));
        aviones.add(new Avion(Direccion.WEST, 5, 5));
        aviones.add(new Avion(Direccion.NORTH, 5, 6));
        aviones.add(new Avion(Direccion.WEST, 1, 5));
        aviones.add(new Avion(Direccion.SOUTH, 1, 6));
        aviones.add(new Avion(Direccion.WEST, 1, 7));

        return aviones;
    }
}
