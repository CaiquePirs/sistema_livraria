package module.biblioteca.Menu;

import module.biblioteca.service.BibliotecaService;
import module.cliente.model.Cliente;
import module.emprestimo.model.Emprestimo;
import module.livro.model.Livro;

import java.util.List;

public class MenuBiblioteca extends MenuPrincipal {
    private BibliotecaService service = new BibliotecaService();

    public void menu(){
        System.out.println("\nMenu biblioteca");
        System.out.println("(1) - Listar todos os clientes");
        System.out.println("(2) - Listar todos os livros");
        System.out.println("(3) - Listar todos os empréstimos");
        System.out.println("(4) - Voltar ao menu principal");
        System.out.println("(5) - Encerrar");
        System.out.println("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        while (opcao != 5){
            switch (opcao){
                case 1:
                    System.out.println("\t-----Lista de Clientes-----");
                    List<Cliente> clientes = service.listarClientes();
                    clientes.forEach(cliente -> System.out.println(cliente.dados()));
                    menu();
                    break;

                case 2:
                    System.out.println("\t-----Lista de Livros-----");
                    List<Livro> livros = service.listarLivros();
                    livros.forEach(livro -> System.out.println(livro.dados()));
                    menu();
                    break;

                case 3:
                    System.out.println("\t-----Lista de Empréstimos-----");
                    List<Emprestimo> emprestimos = service.listarEmprestimos();
                    emprestimos.forEach(emprestimo -> System.out.println(emprestimo.dados()));
                    menu();
                    break;

                case 4:
                    menuInicial();
                    break;
            }
        }
        // Exibindo mensagem personalizada caso a opção do menu seja igual a 5
        System.out.println("\t------Obrigado por utilizar o nosso sistema------");
    }
}
