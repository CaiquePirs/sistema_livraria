package module.livro.service;

import module.livro.model.Livro;
import module.livro.repository.LivroRepository;

import java.sql.Date;
import java.time.LocalDate;

public class LivroService {
    private  LivroRepository repository = new LivroRepository();

    public void cadastrar(String titulo, String autor){
        // Pega a data "atual" que o livro está sendo Criado e atualiza a data automaticamente
        LocalDate data = LocalDate.now();
        Date data_atualizacao = Date.valueOf(data);

        Livro livro = new Livro(titulo, autor);
        livro.setDataCadastro(data_atualizacao);
        livro.setDataAtualizacao(data_atualizacao);

        // Chama o repository para cadastrar o livro no banco no dados
        repository.cadastrar(livro);
    }

    public void atualizar(int id, String titulo, String autor, String status){
        // Pega a data "atual" que o livro está sendo atualizado
        LocalDate data = LocalDate.now();
        Date data_atualizacao = Date.valueOf(data);

        Livro livro = new Livro(titulo, autor);
        livro.setDataAtualizacao(data_atualizacao);
        livro.setStatus(status);
        livro.setId(id);

        // Chama o repository para realizar as alterações do livro no banco de dados
        repository.atualizar(livro);
    }

    public Livro pesquisar(int id){
        Livro livro;
        LivroRepository repository = new LivroRepository();
        livro = repository.pesquisar(id);
        return livro;
    }

    public void excluir(int id){
        LivroRepository repository = new LivroRepository();
        repository.excluir(id);
    }

}
