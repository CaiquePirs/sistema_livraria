package module.emprestimo.service;

import module.cliente.model.Cliente;
import module.cliente.service.ClienteService;
import module.emprestimo.model.Emprestimo;
import module.emprestimo.repository.EmprestimoRepository;
import module.livro.model.Livro;
import module.livro.service.LivroService;

import java.sql.Date;
import java.time.LocalDate;

public class EmprestimoService {
    private EmprestimoRepository repository = new EmprestimoRepository();
    private ClienteService clienteService = new ClienteService();
    private LivroService livroService = new LivroService();

    public void criar(int idCliente, int idLivro){

        // Consulta o id do cliente no banco de dados e retorna os dados do Cliente
        Cliente cliente;
        cliente = clienteService.pesquisar(idCliente);

        // Consulta o id do livro no banco de dados e retorna os dados do Livro
        Livro livro;
        livro = livroService.pesquisar(idLivro);

        // Valida se o livro já está emprestado
        if(livro.getStatus().equals("Indisponível")){
            System.out.println("Esse livro já foi emprestado");

        } else {
            // Pega Data em que o empréstimo está sendo criado
            LocalDate data = LocalDate.now();
            Date data_atual = Date.valueOf(data);

            // Realiza o empréstimo do livro
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
