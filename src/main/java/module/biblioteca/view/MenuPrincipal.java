package module.biblioteca.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    public final static Scanner scanner = new Scanner(System.in);

    public static void menuInicial() {

        int opcao;
        while (true) {
            System.out.println("\nMenu inicial");
            System.out.println("(1) - Menu Cliente");
            System.out.println("(2) - Menu Livro");
            System.out.println("(3) - Menu Empréstimo");
            System.out.println("(4) - Menu Biblioteca");
            System.out.println("(5) - Sair do sistema");
            System.out.print("Opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        MenuCliente menuCliente = new MenuCliente();
                        menuCliente.menu();
                        break;

                    case 2:
                        MenuLivro menuLivro = new MenuLivro();
                        menuLivro.menu();
                        break;

                    case 3:
                        MenuEmprestimo menuEmprestimo = new MenuEmprestimo();
                        menuEmprestimo.menu();
                        break;

                    case 4:
                        MenuBiblioteca menuBiblioteca = new MenuBiblioteca();
                        menuBiblioteca.menu();
                        break;

                    case 5:
                        System.out.println("\n\t---------Obrigado por utilizar o nosso sistema!---------");
                        return;

                    default:
                        System.out.println("Insira a opção do menu válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine();
            }
        }
    }
}