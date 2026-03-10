public class Dado {

    //atributos

    //métodos
    public int lancar() {
        double face = Math.random() * 6 + 1;
        return (int)face;
    }

}
