public class CarrinhoCompra {

    private String cpf;
    private String itens;
    private double total;

    public CarrinhoCompra(String cpf) {
        this.cpf = cpf;
        this.total = 0;
        this.itens = "";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void adicionaCompra(int qtd, double valorUnitario, String item) {
        this.itens = this.itens + "\n" + item + "\t" + qtd + "\t" + valorUnitario;
        this.total = this.total + qtd * valorUnitario;
    }
}
