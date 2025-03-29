package module.cliente.model;

import module.biblioteca.model.Biblioteca;
import module.biblioteca.service.FormatarData;

import java.time.LocalDate;

public class Cliente {


    private int id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;

    public String dadosCliente(){
        return "Id: " + id + " Nome: " + nome
                + " Email: " + email + " Data de nascimento: " + dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
