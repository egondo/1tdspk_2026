public class UsaCirculo {

    //para esta classe ser executavel, preciso colocar o método main

    public static void main(String[] args) {
        Circulo peq = new Circulo(3, 0, 0);
        Circulo med = new Circulo(6, 2, -2);
        Circulo gde = new Circulo(20, -6.9, -8.5);

        System.out.println("Area do circ peq " + peq.getArea());
        System.out.println("Perimetro do circ gde " + gde.getPerimetro());
        System.out.println("Area do circ med " + med.getArea());

        //double raioGrande = gde.raio;
        //gde.raio = -5;


    }
}
