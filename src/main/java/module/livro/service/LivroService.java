package module.livro.service;

import module.livro.model.Livro;
import module.livro.repository.LivroRepository;

import java.time.LocalDate;

public class LivroService {
    private  LivroRepository repository = new LivroRepository();

    public void cadastrar(int id, String titulo, String autor, LocalDate dataCadastro){
        Livro livro = new Livro(id, titulo, autor, dataCadastro);
        repository.cadastrar(livro);
    }

    public void atualizar(int id, String titulo, String autor, Boolean status, LocalDate data){
        Livro livro = new Livro(id, titulo, autor, data);
        livro.setStatus(status);
        repository.atualizar(livro);
    }

    public void pesquisar(int id){
        LivroRepository repository = new LivroRepository();
        repository.pesquisar(id);
    }

    public void excluir(int id){
    }

}
