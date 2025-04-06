package module.biblioteca.service;
import module.biblioteca.repository.BibliotecaRepository;
import module.cliente.model.Cliente;
import module.emprestimo.model.Emprestimo;
import module.livro.model.Livro;

import java.util.List;

public class BibliotecaService{
    private BibliotecaRepository repository = new BibliotecaRepository();

    public List<Cliente> listarClientes(){
        // Recebe a lista de clientes vinda do banco de dados
        List<Cliente> clientes = repository.buscarClientes();

        // Valida se a lista de clientes está vazia
        if(clientes.isEmpty()){
            System.out.println("Não existe clientes cadastrados na biblioteca.");
        }
        return clientes;
    }

    public List<Livro> listarLivros(){
        // Recebe a lista de livros vinda do banco de dados
        List<Livro> livros = repository.buscarLivros();

        // Valida se a lista de livros está vazia
        if(livros.isEmpty()){
            System.out.println("Não existe livros cadastrados na biblioteca.");
        }

        return livros;
    }

    public List<Emprestimo> listarEmprestimos(){
       // Recebe a lista de empréstimos vinda do banco de dados
        List<Emprestimo> emprestimos = repository.buscarEmprestimos();

        // Valida se a lista de empréstimos está vazia
        if(emprestimos.isEmpty()){
            System.out.println("Não existe empréstimos cadastrados na biblioteca.");
        }

        return emprestimos;
    }
}
