package module.biblioteca.Menu;

import module.livro.model.Livro;
import module.livro.service.LivroService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuLivro extends MenuPrincipal{
    Scanner scanner = new Scanner(System.in);
    LivroService service = new LivroService();

    public void menu(){
            System.out.println("\nMenu livro");
            System.out.println("(1) - Cadastrar livro");
            System.out.println("(2) - Atualizar livro");
            System.out.println("(3) - Excluir livro");
            System.out.println("(4) - Pesquisar livro");
            System.out.println("(5) - Voltar ao menu principal");
            System.out.println("(6) - Encerrar");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            while (opcao != 6) {
                switch (opcao) {
                    case 1:
                        System.out.println("\t\n------Cadastrar Livro------");
                        try {
                            System.out.print("Informe o titulo: ");
                            String titulo = scanner.nextLine();

                            System.out.print("Informe o autor: ");
                            String autor = scanner.nextLine();
                            // Realiza o cadastro do livro no banco de dados
                            service.cadastrar(titulo, autor);
                            menu(); // Volta para o menu Livro

                        } catch (InputMismatchException | IllegalArgumentException e){
                            System.out.println("Entrada inválida, digite o valor válido!");
                        }
                        break;

                    case 2:
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

                            // Atualiza os dados do livro no banco de dados
                            service.atualizar(id, titulo, autor, status);
                            menu(); // retoma ao menu do Livro

                        } catch (InputMismatchException | IllegalArgumentException e){
                            System.out.println("Entrada inválida, digite o valor válido!\n");
                        }
                        break;

                    case 3:
                        System.out.println("\t\n------Excluir Livro------");
                        try {
                            System.out.print("Informe o ID do livro: ");
                            int idLivro = scanner.nextInt();
                            service.excluir(idLivro); // Realiza a exclusão do livro no banco de dados
                            menu(); // Volta para o menu livro

                        } catch (InputMismatchException | IllegalArgumentException e){
                            System.out.println("Entrada inválida, digite o valor válido!");
                        }
                        break;

                    case 4:
                        System.out.println("\t\n------Pesquisar Livro------");
                        try {
                            System.out.print("Informe o ID do livro: ");
                            int id_livro = scanner.nextInt();

                            // Retorna os dados do livro Cadastrado
                            Livro livro = service.pesquisar(id_livro);
                            System.out.println(livro.dados()); // Exibe os dados do livro
                            menu(); // Volta para o menu Livro

                        } catch (InputMismatchException | IllegalArgumentException e){
                            System.out.println("Entrada inválida, digite o valor válido!");
                        }
                        break;

                    case 5:
                        menuInicial();
                        break;

                    default:
                        System.out.println("Insira a opção do menu válida.");
                        break;
                }
            }
        // Exibindo mensagem personalizada caso a opção do menu seja igual a 6
        System.out.println("\t------Obrigado por utilizar o nosso sistema------");
    }
}
