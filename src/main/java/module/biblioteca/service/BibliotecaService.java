package module.biblioteca.service;
import module.biblioteca.repository.BibliotecaRepository;
import module.cliente.model.Cliente;

import java.util.List;

public class BibliotecaService{
    BibliotecaRepository repository = new BibliotecaRepository();

    public List<Cliente> listarClientes(){
        // Recebe a lista de clientes vinda do banco de dados
        List<Cliente> clientes = repository.buscarClientes();

        // Valida se a lista de clientes está vazia
        if(clientes.isEmpty()){
            throw new RuntimeException("Não existe clientes cadastrados no sistema.");
        }
        return clientes;
    }

    public void listarLivros(){

    }

    public void listarEmprestimos(){

    }
}
