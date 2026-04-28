package br.com.tdspk.cinemark.app;

import br.com.tdspk.cinemark.model.Filme;
import br.com.tdspk.cinemark.model.Ingresso;
import br.com.tdspk.cinemark.model.Sessao;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Filme filme = new Filme();
        filme.setDuracao(157);
        filme.setGenero("Comédia");
        filme.setTitulo("Se beber não case");
        filme.setClassificacaoIndicativa("Livre");

        Sessao manha = new Sessao();
        manha.setFilme(filme);
        manha.setPeriodo("manhã");
        LocalDateTime dataHora = LocalDateTime.of(2026, 4, 28, 11, 0);
        manha.setDataHora(dataHora);

        Sessao tarde = new Sessao();
        tarde.setFilme(filme);
        tarde.setPeriodo("tarde");
        dataHora = LocalDateTime.of(2026, 4, 28, 14, 30);
        tarde.setDataHora(dataHora);

        Ingresso joao = new Ingresso();
        joao.setSessao(manha);
        joao.setPoltrona("35G");
        joao.setValor(25.89);

        Ingresso fabi = new Ingresso();
        fabi.setSessao(tarde);
        fabi.setPoltrona("10D");
        fabi.setValor(34.50);

        //para destruir o objeto fabi:
        fabi = null;

        
    }
}
