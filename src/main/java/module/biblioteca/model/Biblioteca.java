package module.biblioteca.model;

import module.cliente.model.Cliente;
import module.emprestimo.model.Emprestimo;
import module.livro.model.Autor;
import module.livro.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    List<Livro> livros = new ArrayList<>();
    List<Autor> autores = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();
    List<Emprestimo> emprestimos = new ArrayList<>();
}
