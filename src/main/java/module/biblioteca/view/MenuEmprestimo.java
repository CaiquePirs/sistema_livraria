package module.biblioteca.view;

import java.util.InputMismatchException;

import module.emprestimo.model.Emprestimo;
import module.emprestimo.service.EmprestimoService;

public class MenuEmprestimo extends MenuPrincipal {
   private EmprestimoService service = new EmprestimoService();

    public void menu() {

        int opcao;
        while (true) {
            System.out.println("\nMenu empréstimo");
            System.out.println("(1) - Cadastrar empréstimo");
            System.out.println("(2) - Pesquisar empréstimo");
            System.out.println("(3) - Devolver empréstimo");
            System.out.println("(4) - Excluir empréstimo");
            System.out.println("(5) - Voltar ao menu principal");
            System.out.println("(6) - Encerrar");
            System.out.print("Opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrar();
                        break;

                    case 2:
                        pesquisar();
                        break;

                    case 3:
                        devolver();
                        return;

                    case 4:
                        excluir();
                        return;

                    case 5:
                        menuInicial();
                        return;

                    case 6:
                        System.out.println("Encerrando...");
                        return;

                    default:
                        System.out.println("Insira a opção do menu válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine();
            }
        }
    }

    private void cadastrar(){
        System.out.println("\t\n------Cadastrar empréstimo------");
        try {
            System.out.print("Informe o ID do cliente: ");
            int id_cliente = scanner.nextInt();

            System.out.print("Informe o ID do livro: ");
            int id_livro = scanner.nextInt();

            service.criar(id_cliente, id_livro);

        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Entrada inválida, digite o valor válido!");
        }
    }

    private void pesquisar(){
        System.out.println("\t\n------Pesquisar Empréstimo------");
        try {
            System.out.print("Informe o ID do empréstimo: ");
            int id_emprestimo = scanner.nextInt();
            scanner.nextLine();

            Emprestimo emprestimo = service.pesquisar(id_emprestimo);
            System.out.println(emprestimo.dados());

        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Entrada inválida, digite o valor válido!\n");
        }
    }

    private void devolver(){
        System.out.println("\t\n------Devolver Empréstimo------");
        try {
            System.out.print("Informe o ID do empréstimo: ");
            int id_emprestimo = scanner.nextInt();

            service.devolver(id_emprestimo);

        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Entrada inválida, digite o valor válido!");
        }
    }

    private void excluir(){
        System.out.println("\t\n------Excluir Empréstimo------");
        try {
            System.out.print("Informe o ID do empréstimo: ");
            int id_emprestimo = scanner.nextInt();

            service.excluir(id_emprestimo);

        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Entrada inválida, digite o valor válido!");
        }
    }

}
