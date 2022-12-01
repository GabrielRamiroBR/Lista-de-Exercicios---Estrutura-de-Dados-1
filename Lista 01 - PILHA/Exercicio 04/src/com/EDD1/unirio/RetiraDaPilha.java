package com.EDD1.unirio;

public class RetiraDaPilha<T> {
    public void retiraDaPilha(PilhaGenerica<T> pilha, int tam, T elemento){


        PilhaGenerica<T> pilhaAux = new PilhaGenerica<T>(tam);

        T topo = null;
        //encontrei dificuldade fazendo do jeito abaixo pois a variável topo não estava recebendo valor nenhum
//        while(!pilha.vazia()){
//            pilha.retornaTopo(topo);
//            if(!topo.equals(elemento))
//                pilhaAux.push(pilha.pop());
//            else
//                pilha.pop();
//        }
        while(!pilha.vazia()){
            topo = pilha.pop();
            pilha.push(topo);
            if(!topo.equals(elemento))
                pilhaAux.push(pilha.pop());
            else
                pilha.pop();
        }

        while(!pilhaAux.vazia()){
            pilha.push(pilhaAux.pop());
        }
    }

}
