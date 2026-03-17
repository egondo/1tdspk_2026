public class Usuario {

    private String login;
    private String senha;
    private String papel;

    //0 - ativo
    //1 - bloqueado
    //2 - inativo
    private int status;


    public Usuario(String nomeUser, String pwd, String role) {
        login = nomeUser;
        senha = pwd;
        papel = role;
        status = 0;
    }

    //metodo para disponibilizar o papel
    public String getPapel() {
        return papel;
    }

    public boolean autenticar(String user, String pwd) {
        //se login == user e senha == pwd entao
        //      retorna true
        //senao
        //      return false
        return true;
    }

}
