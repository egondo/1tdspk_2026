package br.com.fiap.enquete.service;

import br.com.fiap.enquete.model.Alternativa;
import br.com.fiap.enquete.model.Pergunta;
import br.com.fiap.enquete.model.TipoPergunta;
import br.com.fiap.enquete.repository.PerguntaRepository;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;

import java.util.List;

public class PerguntaService {

    private PerguntaRepository perguntaRepositorio;


    public void cadastraPergunta(Pergunta pergunta, List<Alternativa> lista) throws Exception {
        //RN1 se lista de alternativas é nula implica pergunta do tipo ABERTA
        if (lista == null || lista.size() == 0) {
            if (pergunta.getTipo() != TipoPergunta.ABERTA)
                throw new RuntimeException("Lista de alternativas nula, verifique o tipo da pergunta");
        }

        //RN2 se pergunta é do tipo ABERTA, implica lista == null ou vazia
        if (pergunta.getTipo() == TipoPergunta.ABERTA) {
            if (lista != null && !lista.isEmpty())
                throw new RuntimeException("Pergunta do tipo aberta, requer lista de alternativas vazia");
        }

        //Consulta perguntas para aplicacao da enquente (ou seja, com as respectivas alternativas)
        //Criar o Service de Resposta com as funcionalidades: gravar respostas e relatório resposta

        try {
            //gravar a resposta e com a resposta gravada, gravo as alternativas
            perguntaRepositorio.save(pergunta);
            for (Alternativa alt : lista) {
                alt.setPergunta(pergunta);
                perguntaRepositorio.saveAlternativa(alt);
            }
        } catch (Exception erro) {
            erro.printStackTrace();
            throw new RuntimeException("Erro na gravação da pergunta: " + pergunta.getTexto());
        }
    }

}
