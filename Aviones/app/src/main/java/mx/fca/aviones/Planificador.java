package mx.fca.aviones;

import java.util.ArrayList;

//planificar la ruta inicial de los aviones.
public class Planificador {

        // crear y devolver un plano inicial con una configuración específica de aviones.
    public static Plano crearRutaInicial() {
        ArrayList<Avion> aviones = Aerolineas.AEROMEXICO(); //obtener la configuración de los aviones
        //crea un objeto de tipo Plano con esa configuración y lo inicializa en el Analizador
        Plano planoInicial = new Plano(0, aviones, new ArrayList<>());
        Analizador.inicializa(planoInicial); //inicializar el plano inicial en el analizador
        return planoInicial; //Devuelve el plano inicial creado al llamar al método.
    }
}
