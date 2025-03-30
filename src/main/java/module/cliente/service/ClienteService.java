package module.cliente.service;

import module.biblioteca.service.FormatarData;
import module.cliente.model.Cliente;
import module.cliente.repository.ClienteRepository;

import java.time.LocalDate;

public class ClienteService {
    private ClienteRepository repository = new ClienteRepository();

    public void Cadastrar(int id, String nome, String email, String cpf, LocalDate data){
        Cliente cliente = new Cliente(id, nome, email, cpf, data);
        repository.criar(cliente);
    }


    public void atualizar(int id, String nome, String email, String cpf, LocalDate data){
        Cliente cliente = new Cliente(id, nome, email, cpf, data);
        repository.atualizar(cliente);
    }

    public void excluir(int id){
        ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.excluir(id);
    }

}
