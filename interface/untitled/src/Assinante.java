public class Assinante implements Observer {

    private String nome;
    private String telefone;
    private String email;

    public Assinante(String nome) {
        this.nome = nome;
    }

    @Override
    public void notification(Subject subject) {
        CanalYoutube canal = (CanalYoutube)subject;
        System.out.println("Novo video adicionado em " + subject + " " + nome);
    }
}
