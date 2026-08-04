package br.com.fiap.heranca;

import br.com.fiap.heranca.model.Carro;
import br.com.fiap.heranca.model.Formula1;

import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        Carro c = new Carro();
        c.setModelo("Creta");
        c.setMontadora("Hyundai");
        c.setMotor(2.0);
        c.setVelocidadeMaxima(180);

        Formula1 f = new Formula1();
        f.setEquipe("Ferrari");
        f.setModelo("F15");
        f.setMontadora("Fiat");
        f.setMotor(8.5);
        f.setVelocidadeMaxima(350);

        Formula1 f2 = new Formula1();
        f2.setEquipe("Honda");
        f2.setMotor(7.5);
        f2.setVelocidadeMaxima(325);
        f2.setMontadora("Honda");
        f2.setModelo("HE4542");

        Carro passeio = new Carro("Polo", "Volkswagen", 1.6, 176);

        List<Carro> garagem = new ArrayList<>();
        garagem.add(c);
        garagem.add(f);
        garagem.add(f2);
        //garagem.add("Fiat Uno, 1.5: 145");
        garagem.add(passeio);

        for(Carro carro : garagem) {
            System.out.println(carro.getMontadora() + " " + carro.getModelo());
        }
    }
}
