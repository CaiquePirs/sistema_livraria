package module.cliente.model;

import java.time.LocalDate;

public class Cliente {


    private int id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;

    Cliente(int id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public String clienteInfo(){

        return "Id: " + id + " Nome: " + nome
                + " Email: " + email + "Data de nascimento: " + dataNascimento;
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
