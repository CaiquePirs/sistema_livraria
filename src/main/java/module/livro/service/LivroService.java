package module.livro.service;

import module.livro.model.Livro;
import module.livro.repository.LivroRepository;

import java.sql.Date;
import java.time.LocalDate;

public class LivroService {
    private  LivroRepository repository = new LivroRepository();

    public void cadastrar(int id, String titulo, String autor, Date dataCadastro){
        Livro livro = new Livro(id, titulo, autor, dataCadastro);
        repository.cadastrar(livro);
    }

    public void atualizar(int id, String titulo, String autor, String status){
        
        LocalDate data = LocalDate.now();
        Date data_atualizacao = Date.valueOf(data);

        Livro livro = new Livro(id, titulo, autor, data_atualizacao);
        livro.setStatus(status);
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
