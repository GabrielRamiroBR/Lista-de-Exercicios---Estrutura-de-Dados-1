package ramiro.EDD1.unirio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite uma expressão: ");
        s = scan.nextLine();

        Posfixada pos = new Posfixada(s.length());

        pos.leExpressao(ConvertePosfixada.converte(s));
        pos.avaliaExpressao();
        pos.imprimeResposta();
    }
}
