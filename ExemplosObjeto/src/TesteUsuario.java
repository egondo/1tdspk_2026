public class TesteUsuario {

    public static void main(String[] args) {
        Usuario eduardo = new Usuario("edu", "fiap123", "professor");

        Usuario aluno1, aluno2, aluno3;

        System.out.println("Já criei o usuario professor, agora criarei os alunos");

        aluno1 = new Usuario("matheus", "mat123", "aluno");
        aluno2 = new Usuario("jacqueline", "jac123", "aluno");
        aluno3 = new Usuario("paulo", "paulo321", "monitor");


        String papelDoEdu = eduardo.getPapel();
        System.out.println("O papel do usuario Edu é " + papelDoEdu);

        String papelDoMatheus = aluno1.getPapel();
        System.out.println("O papel do usuario Matheus é " + papelDoMatheus);
    }
}
