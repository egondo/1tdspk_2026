public class Usuario {

    private String login;
    private String pwd;

    public Usuario(String login, String senha) {
        this.login = login;
        this.pwd = senha;
    }

    public boolean alteraSenha(String oldPwd, String newPwd) {
        if (pwd.equals(oldPwd)) {
            pwd = newPwd;  //atualizando a senha para a nova
            return true;
        }
        return false;
    }

    public String getPwd() {
        return pwd;
    }

    public boolean autentica(String login, String pwd) {
        //verifica se login e pwd dos atributos sao iguais ao login e
        //senha dos parametros passados no método
        //se sao iguais retorna true, caso contrário retorna false
        return false;
    }
}
