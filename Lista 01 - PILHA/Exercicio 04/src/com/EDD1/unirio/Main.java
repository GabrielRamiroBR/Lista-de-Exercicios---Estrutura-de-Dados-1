package com.EDD1.unirio;

public class Main {

    public static void main(String[] args) {

        PilhaGenerica<String> pilha = new PilhaGenerica<>(5);
        pilha.push("janeiro");
        pilha.push("fevereiro");
        pilha.push("março");
        pilha.push("abril");
        pilha.push("maio");

        String elemento = "abril";



        RetiraDaPilha<String> r = new RetiraDaPilha<>();
        r.retiraDaPilha(pilha, 5, elemento);
        pilha.imprime();

    }
}
