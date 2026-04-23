package br.com.tdspk.jogodados.model;

import java.util.Random;

public class Dado {

    public int lancar() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
