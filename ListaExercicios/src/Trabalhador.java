public class Trabalhador {

    private String nome;
    private String cargo;
    private double salario;
    private String tipo;

    public Trabalhador(String nome, String cargo, double salario) {
        this.cargo = cargo;
        this.nome = nome;
        this.salario = salario;
        this.tipo = "CLT";
    }

    //15% qual o valor do percentual?
    //vamos passar 15, se for 5,6% vou passar 5.6
    public void aumento(double percentual) {
        this.salario = this.salario * (1 + percentual / 100);
    }

    public void promocao(String cargo, double salario) {
        this.cargo = cargo;
        this.salario = salario;
    }

    public double getInss() {
        return this.salario * 0.11;
    }

    public double valorFerias() {
        return salario * 0.33;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
