package br.com.fiap.excecoes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExemploIO {

    public static void main(String[] args) {
        File f = new File("/Users/eduardogondo/dados.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Olá, tudo bem?");
            bw.newLine();
            bw.write("prompt para jogar no ChatGPT");
            bw.close();
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
