package ramiro.EDD1.unirio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String s;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite uma frase: ");
        s = scan.nextLine();

        if (Comparador.isXcY(s.toUpperCase()))
            System.out.println("A frase é do tipo xCy");
        else
            System.out.println("A frase NÃO é do tipo xCy");

    }
}
