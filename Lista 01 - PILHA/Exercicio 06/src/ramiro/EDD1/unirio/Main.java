package ramiro.EDD1.unirio;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite uma frase: ");
        s = scan.nextLine();

        Pilha pilha = InversorPalavras.invertePalavras(s);

        ImprimePilha.imprimePilha(pilha, s.length());

    }
}
