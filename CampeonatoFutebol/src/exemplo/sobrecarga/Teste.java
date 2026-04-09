package exemplo.sobrecarga;

public class Teste {

    public int soma(int x, int y) {
        return x + y;
    }

    public double soma(double a, int b) {
        return a + b;
    }

    public int soma(int a, int b, int c) {
        return this.soma(a, b) + c;
    }

}








