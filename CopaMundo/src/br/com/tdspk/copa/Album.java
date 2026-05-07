package br.com.tdspk.copa;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private String proprietario;
    private String evento;
    private String tipo; //capa dura ou normal
    private int maxNumero;

    private List<Figurinha> figurinhas;

    public Album(String evento, String tipo, int maxNumero) {
        this.evento = evento;
        this.tipo = tipo;
        this.maxNumero = maxNumero;

        this.figurinhas = new ArrayList<>();

        /** Temos aqui uma repetição, precisamos adicionar
         *  maxNumero figurinhas dentro do ArrayList, vamos
         *  usar uma repetição!
                Figurinha f = new Figurinha(1);
                this.figurinhas.add(f);
                f = new Figurinha(2);
                this.figurinhas.add(f);
                f = new Figurinha(3);
                this.figurinhas.add(f);
         */

        for(int i = 1; i <= maxNumero; i++) {
            Figurinha f = new Figurinha(i);
            this.figurinhas.add(f);
            //ou this.figurinhas.add(new Figurinha(i));
        }
    }

    public void adicionaFigurinha(Figurinha chromo) {
        //procurar na lista de Figurinhas, a figurinha de mesmo nome.
        //Encontrando, verifico eu tenho ou não tenho ela.
        //Se eu já tenho, atualizo mais 1 na quantidade
        //se eu não tenho, colo ela no meu album substituindo a figurinha anterior

        int pos = chromo.getNumero() - 1;
        Figurinha fig = figurinhas.get(pos);

        if (fig.isRepetida()) //eu ja tenho a figurinha :o(
            fig.aumentaQuantidade();
        else
            figurinhas.set(pos, chromo);
    }















}



