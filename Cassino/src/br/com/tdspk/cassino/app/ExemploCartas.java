package br.com.tdspk.cassino.app;

import br.com.tdspk.cassino.model.Carta;
import br.com.tdspk.cassino.model.Naipe;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

public class ExemploCartas {

    public static void main(String[] args) {

        Carta especial = new Carta(1, Naipe.ESPADAS);
        System.out.println(especial);

        Carta zap = new Carta(4, Naipe.PAUS);
        System.out.println(zap);

        Carta rainha = new Carta(12, Naipe.COPAS);
        System.out.println(rainha);

        //Mostrando a carta Unicode Ás de espadas
        //PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
        System.out.println("\uD83C\uDCA1");
        System.out.println("\uD83C\uDCA2");
        System.out.println("\uD83C\uDCAA");

        Font f = new Font("Consola0", Font.PLAIN, 100);
        FontUIResource fr = new FontUIResource(f);
        UIManager.put("OptionPane.messageFont", fr);

        JOptionPane.showMessageDialog(null,
                "\uD83C\uDCA1 \uD83C\uDCA2 \uD83C\uDCAA");
    }
}
