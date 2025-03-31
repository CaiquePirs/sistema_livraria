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

    public void atualizar(){
    }

    public void pesquisar(int id){
    }

    public void excluir(int id){
    }

}
