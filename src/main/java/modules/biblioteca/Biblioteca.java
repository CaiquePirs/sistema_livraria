package modules.biblioteca;

import modules.livro.Autor;
import modules.livro.Livro;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    List<Livro> livros = new ArrayList<>();
    List<Autor> autores = new ArrayList<>();
    List<Emprestimo> emprestimos = new ArrayList<>();
}
