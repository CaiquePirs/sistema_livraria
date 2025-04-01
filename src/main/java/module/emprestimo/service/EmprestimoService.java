package module.emprestimo.service;

import module.cliente.model.Cliente;
import module.cliente.service.ClienteService;
import module.emprestimo.model.Emprestimo;
import module.emprestimo.repository.EmprestimoRepository;
import module.livro.model.Livro;
import module.livro.service.LivroService;

import java.sql.Date;

public class EmprestimoService {
    public void criar(int id, Date dataEmprestimo, int idCliente, int idLivro){

        // Consulta o id do cliente no banco de dados e retorna o objeto Cliente
        Cliente cliente;
        ClienteService clienteService = new ClienteService();
        cliente = clienteService.pesquisar(idCliente);

        // Consulta o id do livro no banco de dados e retorna o objeto Livro
        Livro livro;
        LivroService livroService = new LivroService();
        livro = livroService.pesquisar(idLivro);

        // Realiza o empréstimo do livro
        Emprestimo emprestimo = new Emprestimo(id, dataEmprestimo, cliente, livro);
        EmprestimoRepository repository = new EmprestimoRepository();
        repository.criar(emprestimo);
    }

    public void pesquisar(int id ){
        EmprestimoRepository repository = new EmprestimoRepository();
        repository.pesquisar(id);
    }

    public void devolver(){

    }

    public void excluir(){

    }

}
