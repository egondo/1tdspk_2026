package br.com.fiap.excecoes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExemploLeituraArquivoTratamentoConteudo {

    public static void main(String[] args) throws IOException  {

        FileReader fr = new FileReader("disciplinas.txt");
        BufferedReader br = new BufferedReader(fr);
        List<Integer> dados = new ArrayList<>();

        String registro = br.readLine();
        while (registro != null) {

            try {
                dados.add(Integer.parseInt(registro));
            }
            catch (NumberFormatException nfe) {
                System.out.println("Essa informação não foi processada: " + registro);
            }
            registro = br.readLine();
        }
        br.close();
        fr.close();
        //mandar a lista de numeros para o banco de dados
        System.out.println(dados);
    }


}
