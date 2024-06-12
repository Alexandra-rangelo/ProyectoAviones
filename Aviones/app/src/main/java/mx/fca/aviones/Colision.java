package mx.fca.aviones;

//representar colisiones entre aviones en un plano.
public class Colision {

    int x;
    int y;

    public Colision(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //obtener el identificador de recurso de la imagen que representa una
    // colisión en la interfaz de usuario.
    public int getImage() {
        return R.mipmap.collision;
    }
}
