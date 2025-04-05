package module.biblioteca.Menu;

import java.util.Scanner;

public class MenuPrincipal {
    Scanner scanner = new Scanner(System.in);

    public void menuInicial() {
        System.out.println("\nMenu inicial");
        System.out.println("(1) - Menu Cliente");
        System.out.println("(2) - Menu Livro");
        System.out.println("(3) - Menu Empréstimo");
        System.out.println("(4) - Menu Biblioteca");
        System.out.println("(5) - Sair do sistema");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
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
                    System.out.println("\t-----Obrigado por utilizar o nosso sistema!-----");
                    break;

                default:
                    System.out.println("Insira a opção do menu válida");
                    break;
            }

    }
}
