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
    public void criar(int idCliente, int idLivro){

        // Consulta o id do cliente no banco de dados e retorna o Cliente
        Cliente cliente;
        ClienteService clienteService = new ClienteService();
        cliente = clienteService.pesquisar(idCliente);

        // Consulta o id do livro no banco de dados e retorna o Livro
        Livro livro;
        LivroService livroService = new LivroService();
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
            EmprestimoRepository repository = new EmprestimoRepository();
            repository.criar(emprestimo);
        }

    }

    public Emprestimo pesquisar(int id ){
        EmprestimoRepository repository = new EmprestimoRepository();
        return repository.pesquisar(id);
    }

    public void devolver(int id){
        EmprestimoRepository repository = new EmprestimoRepository();
        repository.devolver(id);
    }

    public void excluir(int id){
        EmprestimoRepository repository = new EmprestimoRepository();
        repository.excluir(id);
    }

}
