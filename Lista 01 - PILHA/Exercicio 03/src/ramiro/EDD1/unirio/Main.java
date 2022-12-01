package ramiro.EDD1.unirio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int opcao = 0;
        char elemento;

        PilhaDupla pilhaDupla = new PilhaDupla();

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n*** O vetor de capacidade 10 está pronto para ser preenchido! ***");

        while (opcao != 3) {
            System.out.println("\nDigite a opçao desejada\n" +
                    "1 - Incrementar\n2 - Decrementar\n3 - Imprimir vetor e encerrar");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Escolha\n  1 - Pilha 1\n  2 - Pilha 2");
                    opcao = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcao) {
                        case 1:
                            System.out.println("Digite o elemento que deseja adicionar:");
                            elemento = scanner.next().charAt(0);

                            pilhaDupla.push1(elemento);
                            break;

                        case 2:
                            System.out.println("Digite o elemento que deseja adicionar:");
                            elemento = scanner.next().charAt(0);

                            pilhaDupla.push2(elemento);
                            break;
                        default:
                            System.out.println("Opcao invalida");
                    }
                    break;
                case 2:
                    System.out.println("Escolha\n  1 - Pilha 1\n  2 - Pilha 2");
                    opcao = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcao) {
                        case 1:
                            pilhaDupla.pop1();
                            break;

                        case 2:
                            pilhaDupla.pop2();
                            break;

                        default:
                            System.out.println("Opcao invalida");

                    }
                    break;

                case 3:
                    pilhaDupla.imprimeVetor();
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }
    }
}
