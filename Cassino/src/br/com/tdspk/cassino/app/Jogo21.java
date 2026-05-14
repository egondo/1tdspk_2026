package br.com.tdspk.cassino.app;

import br.com.tdspk.cassino.model.Carta;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Jogo21 {

    public static void main(String[] args) {

        Carta especial = new Carta(1, "espadas");
        System.out.println(especial);

        Carta zap = new Carta(4, "paus");
        System.out.println(zap);

        Carta rainha = new Carta(12, "copas");
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
