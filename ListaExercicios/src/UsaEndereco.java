public class UsaEndereco {

    public static void main(String[] args) {

        Endereco fiap = new Endereco();
        Endereco meu = new Endereco();
        Endereco avo = new Endereco();

        System.out.println(fiap.getLogradouro());

        fiap.setLogradouro("Avenida Paulista");
        fiap.setBairro("Bela Vista");
        fiap.setMunicipio("São Paulo");
        fiap.setNumero("1106");
        fiap.setUf("SP");
        fiap.setCep("01383-000");
        fiap.setComplemento("3º andar");

        System.out.println(fiap.getEtiqueta());
    }
}
