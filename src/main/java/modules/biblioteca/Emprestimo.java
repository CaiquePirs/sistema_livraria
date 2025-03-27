package modules.biblioteca;

import modules.cliente.Cliente;
import modules.livro.Livro;

import java.time.LocalDate;

public class Emprestimo {

    private int id;
    private LocalDate dataEmprestimo;
    private Livro livro;
    private Cliente cliente;

    Emprestimo(int id, LocalDate dataEmprestimo, Cliente cliente, Livro livro){

        this.dataEmprestimo = dataEmprestimo;
        this.id = id;
        this.cliente = cliente;
        this.livro = livro;

        // Marca o livro como 'Indisponivel'
        livro.setStatus(false);

    }

    public String emprestimoInformacao(){

        return " Id:" + id + " Nome do cliente: " + cliente.getNome()
                + " Livro: " + livro.getTitulo() + " Autor: " + livro.getAutor() + " Data do emprestimo: " + dataEmprestimo;
    }

}
