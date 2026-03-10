public class Dado {


    //atributos --- comentario
    private int faces;

    public Dado() {
        faces = 6;
    }

    public Dado(int lados) {
        faces = lados;
    }

    //métodos
    public int lancar() {
        double face = Math.random() * faces + 1;
        return (int)face;
    }

}
