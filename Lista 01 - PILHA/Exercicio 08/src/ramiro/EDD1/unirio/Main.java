
package ramiro.EDD1.unirio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite um numero N para sequencia: ");
        n = scan.nextInt();

        System.out.println("O numero de subsequencias (a,b) é " + Sequencia.contaSubsequenciasMaximas(n));
    }
}
