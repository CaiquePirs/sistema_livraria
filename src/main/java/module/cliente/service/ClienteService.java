package module.cliente.service;

import module.cliente.model.Cliente;
import module.cliente.repository.ClienteRepository;

import java.sql.Date;

public class ClienteService {
    private ClienteRepository repository = new ClienteRepository();

    public void cadastrar(String nome, String email, String cpf, Date dataNascimento){
        Cliente cliente = new Cliente(nome, email, cpf, dataNascimento);
        repository.criar(cliente);
    }

    public void atualizar(int id, String nome, String email, String cpf, Date dataNascimento){
        Cliente cliente = new Cliente(nome, email, cpf, dataNascimento);
        cliente.setId(id);
        repository.atualizar(cliente);
    }

    public void excluir(int id){
        repository.excluir(id);
    }

    public Cliente pesquisar(int id){
        Cliente cliente;
        cliente = repository.pesquisar(id);
        return cliente;
    }

}
