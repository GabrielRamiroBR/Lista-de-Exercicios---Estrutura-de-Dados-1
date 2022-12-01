package ramiro.EDD1.unirio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite uma frase: ");
        s = scan.nextLine();

        if (Verificador.verificaBalanceado(s.toUpperCase()))
            System.out.println("A frase é balanceada");
        else
            System.out.println("A frase NÃO é balanceada");
    }
}

