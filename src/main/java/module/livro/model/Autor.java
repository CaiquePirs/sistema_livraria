package module.livro.model;

import java.time.LocalDate;

public class Autor {
    private int id;
    private String nome;
    private LocalDate dataNascimento;

    Autor(int id, String nome, LocalDate dataNascimento){
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
