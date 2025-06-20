package module.biblioteca.service;
import java.util.List;

import module.biblioteca.repository.BibliotecaRepository;
import module.cliente.model.Cliente;
import module.emprestimo.model.Emprestimo;
import module.livro.model.Livro;

public class BibliotecaService{
    private BibliotecaRepository repository = new BibliotecaRepository();

    public List<Cliente> listarClientes(){
        List<Cliente> clientes = repository.buscarClientes();

        if(clientes.isEmpty()){
            System.out.println("Não existe clientes cadastrados na biblioteca.");
        }
        return clientes;
    }

    public List<Livro> listarLivros(){
        List<Livro> livros = repository.buscarLivros();

        if(livros.isEmpty()){
            System.out.println("Não existe livros cadastrados na biblioteca.");
        }
        return livros;
    }

    public List<Emprestimo> listarEmprestimos(){
        List<Emprestimo> emprestimos = repository.buscarEmprestimos();

        if(emprestimos.isEmpty()){
            System.out.println("Não existe empréstimos cadastrados na biblioteca.");
        }
        return emprestimos;
    }
}
