public class UsaTrabalhador {

    public static void main(String[] args) {
        Trabalhador t1 = new Trabalhador("João Torres", "diretor financeiro", 16500);
        Trabalhador t2 = new Trabalhador("Rose Mendes", "chefe RH", 8600);
        Trabalhador t3 = new Trabalhador("Matias Aires", "estoquista", 3900);

        System.out.println(t1.getNome() + " INSS: " + t1.getInss());

        t2.aumento(5);
        System.out.println(t2.getNome() + " Salario: " + t2.getSalario());

        t3.promocao("repositor", 4200);
        System.out.println(t3.getNome() + " cargo: " + t3.getCargo() + " salario: " + t3.getSalario());
    }

}
