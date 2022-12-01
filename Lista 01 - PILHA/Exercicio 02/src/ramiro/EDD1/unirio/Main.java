package ramiro.EDD1.unirio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String s;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite uma frase: ");
        s = scan.nextLine();

        if (Comparador.isCadeiaXcY(s.toUpperCase()))
            System.out.println("A frase é do tipo \n" +
                    "a D b D c D ... D z");
        else
            System.out.println("A frase NÃO é do tipo \n" +
                    "a D b D c D ... D z");

    }
}