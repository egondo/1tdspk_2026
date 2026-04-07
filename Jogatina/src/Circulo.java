import java.awt.*;

public class Circulo {

    private double raio;
    private double x;
    private double y;

    public Circulo(double raio, double x, double y) {
        this.raio = raio;
        this.x = x;
        this.y = y;
    }

    public double getRaio() {
        return raio;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getPerimetro() {
        return 2 * this.raio * Math.PI;
    }

    public double getArea() {
        return raio * raio * Math.PI;
    }

    public Graphics desenha() {
        //coloque a implementacao de desenhar o circulo na tela
        return null;
    }
}
