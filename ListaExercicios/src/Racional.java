public class Racional {

    private int numerador;
    private int denominador;

    public Racional(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public Racional soma(Racional r) {
        int novoDen = this.denominador * r.getDenominador();

        int novoNum =  (novoDen / this.denominador) * this.numerador;
        novoNum = novoNum + (novoDen / r.getDenominador()) * r.getNumerador();

        return new Racional(novoNum, novoDen);
    }

    public Racional mutiplica(Racional r) {
        int novoNumerador = this.numerador * r.getNumerador();
        int novoDenominador = this.denominador * r.getDenominador();

        Racional resposta = new Racional(novoNumerador, novoDenominador);
        return resposta;
    }

    public static void main(String[] args) {
        Racional a = new Racional(1, 2);
        Racional b = new Racional(2, 3);

        Racional mult = a.mutiplica(b);
        System.out.println(mult.getNumerador() + "/" + mult.getDenominador());

        Racional sum = a.soma(b);
        System.out.println(sum.getNumerador() + "/" + sum.getDenominador());
    }
}





