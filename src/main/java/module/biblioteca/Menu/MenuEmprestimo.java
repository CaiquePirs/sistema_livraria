package module.biblioteca.Menu;

import module.emprestimo.model.Emprestimo;
import module.emprestimo.service.EmprestimoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuEmprestimo extends MenuPrincipal {
    Scanner scanner = new Scanner(System.in);
    EmprestimoService service = new EmprestimoService();

    public void menu() {
        System.out.println("\nMenu empréstimo");
        System.out.println("(1) - Cadastrar empréstimo");
        System.out.println("(2) - Pesquisar empréstimo");
        System.out.println("(3) - Devolver empréstimo");
        System.out.println("(4) - Excluir empréstimo");
        System.out.println("(5) - Voltar ao menu principal");
        System.out.println("(6) - Encerrar");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        while (opcao != 6) {
            switch (opcao) {
                case 1:
                    System.out.println("\t\n------Cadastrar empréstimo------");
                    try {
                        System.out.print("Informe o ID do cliente: ");
                        int id_cliente = scanner.nextInt();

                        System.out.print("Informe o ID do livro: ");
                        int id_livro = scanner.nextInt();

                        // Realiza o empréstimo do livro no banco de dados
                        service.criar(id_cliente, id_livro);
                        menu(); // Volta para o menu empréstimo

                    } catch (InputMismatchException | IllegalArgumentException e) {
                        System.out.println("Entrada inválida, digite o valor válido!");
                    }
                    break;

                case 2:
                    System.out.println("\t\n------Pesquisar Empréstimo------");
                    try {
                        System.out.print("Informe o ID do empréstimo: ");
                        int id_emprestimo = scanner.nextInt();
                        scanner.nextLine();

                        // Recebe os dados do empréstimo e exibe as informações
                        Emprestimo emprestimo = service.pesquisar(id_emprestimo);
                        System.out.println(emprestimo.dados());
                        menu();

                    } catch (InputMismatchException | IllegalArgumentException e) {
                        System.out.println("Entrada inválida, digite o valor válido!\n");
                    }
                    break;

                case 3:
                    System.out.println("\t\n------Devolver Empréstimo------");
                    try {
                        System.out.print("Informe o ID do empréstimo: ");
                        int id_emprestimo = scanner.nextInt();
                        service.devolver(id_emprestimo); // Realiza a devolução do empréstimo e do livro no banco de dados
                        menu(); // Volta para o menu empréstimo

                    } catch (InputMismatchException | IllegalArgumentException e) {
                        System.out.println("Entrada inválida, digite o valor válido!");
                    }
                    break;

                case 4:
                    System.out.println("\t\n------Excluir Empréstimo------");
                    try {
                        System.out.print("Informe o ID do empréstimo: ");
                        int id_emprestimo = scanner.nextInt();

                        service.excluir(id_emprestimo); // Realiza a exclusão do empréstimo no banco de dados
                        menu(); // Volta para o menu emprestimo

                    } catch (InputMismatchException | IllegalArgumentException e) {
                        System.out.println("Entrada inválida, digite o valor válido!");
                    }
                    break;

                case 5:
                   menuInicial();
                    continue;

                default:
                    System.out.println("Insira a opção do menu válida.");
                    break;
            }
        }
        // Exibindo mensagem personalizada caso a opção do menu seja igual a 6
        System.out.println("\t------Obrigado por utilizar o nosso sistema------");
    }
}
