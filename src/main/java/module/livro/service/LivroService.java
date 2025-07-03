package module.livro.service;

import module.livro.model.Livro;
import module.livro.repository.LivroRepository;

import java.sql.Date;
import java.time.LocalDate;

public class LivroService {
    private  LivroRepository repository = new LivroRepository();

    public void cadastrar(String titulo, String autor){
        LocalDate data = LocalDate.now();
        Date data_atualizacao = Date.valueOf(data);

        Livro livro = new Livro(titulo, autor);
        livro.setDataCadastro(data_atualizacao);
        livro.setDataAtualizacao(data_atualizacao);

        repository.cadastrar(livro);
    }

    public void atualizar(int id, String titulo, String autor, String status){
        LocalDate data = LocalDate.now();
        Date data_atualizacao = Date.valueOf(data);

        Livro livro = new Livro(titulo, autor);
        livro.setDataAtualizacao(data_atualizacao);
        livro.setStatus(status);
        livro.setId(id);

        repository.atualizar(livro);
    }

    public Livro pesquisar(int id){
        Livro livro;
        livro = repository.pesquisar(id);
        return livro;
    }

    public void excluir(int id){
        repository.excluir(id);
    }

}
