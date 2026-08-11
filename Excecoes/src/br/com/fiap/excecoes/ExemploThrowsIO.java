package br.com.fiap.excecoes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExemploThrowsIO {

    public void gravaDados(List<String> infos, String nomeArquivo) throws IOException {

        FileWriter fw = new FileWriter(nomeArquivo);
        BufferedWriter bw = new BufferedWriter(fw);
        for(String s : infos) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();
        fw.close();
    }

    public static void main(String[] args) {
        ExemploThrowsIO exemplo = new ExemploThrowsIO();

        List<String> lista = List.of("CTP", "FrontEnd", "DDD", "Database", "Software Eng.", "IA");

        try {
            exemplo.gravaDados(lista, "disciplinas.txt");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
