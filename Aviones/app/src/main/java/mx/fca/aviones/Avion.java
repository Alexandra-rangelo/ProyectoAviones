package mx.fca.aviones;

//representa un avión en un plano, con una dirección y coordenadas específicas.
public class Avion {
    Direccion direccion; //la dirección en la que el avión está apuntando.
    int x; //coordenada x
    int y; //coordenada y

    //Este constructor inicializa un objeto Avion
    // con una dirección y coordenadas específicas
    public Avion(Direccion direccion, int x, int y) {
        this.direccion = direccion;
        this.x = x;
        this.y = y;
    }

    //que devuelve un recurso de imagen basado en la dirección del avión.
    public int getImage() {
        switch (direccion){
            case NORTH:
                return R.mipmap.north;
            case SOUTH:
                return R.mipmap.south;
            case EAST:
                return R.mipmap.east;
            case WEST:
                return R.mipmap.west;
        }
        return R.mipmap.north; //alor por defecto
    }
}
