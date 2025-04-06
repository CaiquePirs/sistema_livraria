package module.biblioteca.view;

import module.biblioteca.service.BibliotecaService;
import module.cliente.model.Cliente;
import module.emprestimo.model.Emprestimo;
import module.livro.model.Livro;

import java.util.InputMismatchException;
import java.util.List;

public class MenuBiblioteca extends MenuPrincipal {
    private BibliotecaService service = new BibliotecaService();

    public void menu() {

        int opcao;
        while (true) {
            System.out.println("\nMenu biblioteca");
            System.out.println("(1) - Listar todos os clientes");
            System.out.println("(2) - Listar todos os livros");
            System.out.println("(3) - Listar todos os empréstimos");
            System.out.println("(4) - Voltar ao menu principal");
            System.out.println("(5) - Encerrar");
            System.out.println("Opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        buscarClientes();
                        break;

                    case 2:
                        buscarLivros();
                        break;

                    case 3:
                        buscarEmprestimos();
                        break;

                    case 4:
                        menuInicial();
                        return;

                    case 5:
                        System.out.println("Encerrando...");
                        return;

                    default:
                        System.out.println("Insira uma opção do menu válida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine();
            }
        }
    }
    private void buscarClientes(){
        System.out.println("\t-----Lista de Clientes-----");

        // Busca e exibe a lista dos clientes cadastrados no banco de dados
        List<Cliente> clientes = service.listarClientes();
        clientes.forEach(cliente -> System.out.println(cliente.dados()));
    }

    private void buscarLivros(){
        System.out.println("\t-----Lista de Livros-----");

        // Busca e exibe a lista dos livros cadastrados no banco de dados
        List<Livro> livros = service.listarLivros();
        livros.forEach(livro -> System.out.println(livro.dados()));
    }
    private void buscarEmprestimos(){
        System.out.println("\t-----Lista de Empréstimos-----");

        // Busca e exibe a lista dos empréstimos cadastrados no banco de dados
        List<Emprestimo> emprestimos = service.listarEmprestimos();
        emprestimos.forEach(emprestimo -> System.out.println(emprestimo.dados()));
    }

}
