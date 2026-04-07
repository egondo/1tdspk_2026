public class Hacker {

    public static void main(String[] args) {
        Usuario u = new Usuario("jrobert", "ncc1701");

        //u.pwd = "123fiap";

        boolean resp = u.autentica("jrobert", "ncc1701");

    }

}
