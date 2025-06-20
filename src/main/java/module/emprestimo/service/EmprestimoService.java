package module.emprestimo.service;

import java.sql.Date;
import java.time.LocalDate;

import module.cliente.model.Cliente;
import module.cliente.service.ClienteService;
import module.emprestimo.model.Emprestimo;
import module.emprestimo.repository.EmprestimoRepository;
import module.livro.model.Livro;
import module.livro.service.LivroService;

public class EmprestimoService {
    private EmprestimoRepository repository = new EmprestimoRepository();
    private ClienteService clienteService = new ClienteService();
    private LivroService livroService = new LivroService();

    public void criar(int idCliente, int idLivro){
        Cliente cliente;
        cliente = clienteService.pesquisar(idCliente);

        Livro livro;
        livro = livroService.pesquisar(idLivro);

        if(livro.getStatus().equals("Indisponível")){
            System.out.println("Esse livro já foi emprestado");

        } else {
            LocalDate data = LocalDate.now();
            Date data_atual = Date.valueOf(data);

            Emprestimo emprestimo = new Emprestimo(cliente, livro);
            emprestimo.setDataEmprestimo(data_atual);
            repository.criar(emprestimo);
        }

    }

    public Emprestimo pesquisar(int id ){
        return repository.pesquisar(id);
    }

    public void devolver(int id){
        repository.devolver(id);
    }

    public void excluir(int id){
        repository.excluir(id);
    }

}
