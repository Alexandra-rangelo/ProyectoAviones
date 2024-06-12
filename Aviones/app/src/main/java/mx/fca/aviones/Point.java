package mx.fca.aviones;

import java.util.Objects;

//representa un punto en un plano cartesiano con coordenadas
public class Point {
    // para representar las coordenadas del punto.
    int x;
    int y;

    //inicializa un objeto Point con las coordenadas
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Este método compara si dos objetos Point son iguales, verificando si tienen las mismas coordenadas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }
    //Este método calcula y devuelve un código hash único para un objeto Point basado en sus coordenadas
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
