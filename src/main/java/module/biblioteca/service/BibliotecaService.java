package module.biblioteca.service;
import module.biblioteca.repository.BibliotecaRepository;
import module.cliente.model.Cliente;
import module.livro.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaService{
    BibliotecaRepository repository = new BibliotecaRepository();

    public List<Cliente> listarClientes(){
        // Recebe a lista de clientes vinda do banco de dados
        List<Cliente> clientes = repository.buscarClientes();

        // Valida se a lista de clientes está vazia
        if(clientes.isEmpty()){
            throw new RuntimeException("Não existe clientes cadastrados na biblioteca.");
        }
        return clientes;
    }

    public List<Livro> listarLivros(){
        // Recebe a lista de livros vinda do banco de dados
        List<Livro> livros = repository.buscarLivros();

        // Valida se a lista de livros está vazia
        if(livros.isEmpty()){
            throw new RuntimeException("Não existe livros cadastrados na biblioteca");
        }

        return livros;
    }

    public void listarEmprestimos(){

    }
}
