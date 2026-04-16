public class TesteCarrinho {

    public static void main(String[] args) {
        CarrinhoCompra cesta = new CarrinhoCompra("111.783.090-87");
        cesta.adicionaCompra(5, 26.80, "Arroz Camil");
        cesta.adicionaCompra(3, 8.78, "Feijão Pantera");
        cesta.adicionaCompra(2, 7.89, "Óleo Soya");

        System.out.println(cesta.getItens());
        System.out.println("Total " + cesta.getTotal());

        cesta.adicionaCompra(6, 5.89, "Heineken");
        System.out.println(cesta.getItens());
        System.out.println("Total " + cesta.getTotal());

    }
}
