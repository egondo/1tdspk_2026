import model.Trabalhador;

public class Persistencia {

    public static void main(String[] args) {

        String sql = Reflexao.getCreateTable(Trabalhador.class);
        System.out.println(sql);
        sql = Reflexao.getCreateTable(Produto.class);
        System.out.println(sql);
    }
}
