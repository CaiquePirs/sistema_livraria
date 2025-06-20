package module.biblioteca.view;

import java.util.InputMismatchException;

import module.livro.model.Livro;
import module.livro.service.LivroService;

public class MenuLivro extends MenuPrincipal {
    private LivroService service = new LivroService();

    public void menu() {

        int opcao;
        while (true) {
            System.out.println("\nMenu livro");
            System.out.println("(1) - Cadastrar livro");
            System.out.println("(2) - Atualizar livro");
            System.out.println("(3) - Excluir livro");
            System.out.println("(4) - Pesquisar livro");
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
                        atualizar();
                        break;

                    case 3:
                        excluir();
                        break;

                    case 4:
                        pesquisar();
                        break;

                    case 5:
                        menuInicial();
                        return;

                    case 6:
                        System.out.println("Encerrando...");
                        return;

                    default:
                        System.out.println("Insira a opção de menu válida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine();
            }
        }
    }
    private void cadastrar() {
        System.out.println("\t\n------Cadastrar Livro------");
        try {
            System.out.print("Informe o titulo: ");
            String titulo = scanner.nextLine();

            System.out.print("Informe o autor: ");
            String autor = scanner.nextLine();

            service.cadastrar(titulo, autor);

        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Entrada inválida, digite o valor válido!");
        }
    }

    private void atualizar() {
        System.out.println("\t\n------Atualizar Livro------");
        try {
            System.out.print("Informe o ID do livro: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Informe o novo titulo: ");
            String titulo = scanner.nextLine();

            System.out.print("Informe o novo autor: ");
            String autor = scanner.nextLine();

            System.out.print("Informe o status do livro: ");
            String status = scanner.nextLine();

            service.atualizar(id, titulo, autor, status);

        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Entrada inválida, digite o valor válido!\n");
        }
    }

    private void excluir() {
        System.out.println("\t\n------Excluir Livro------");
        try {
            System.out.print("Informe o ID do livro: ");
            int idLivro = scanner.nextInt();

            service.excluir(idLivro);

        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Entrada inválida, digite o valor válido!");
        }
    }

    private void pesquisar() {
        System.out.println("\t\n------Pesquisar Livro------");
        try {
            System.out.print("Informe o ID do livro: ");
            int id_livro = scanner.nextInt();

            Livro livro = service.pesquisar(id_livro);
            System.out.println(livro.dados());

        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Entrada inválida, digite o valor válido!");
        }
    }
}


