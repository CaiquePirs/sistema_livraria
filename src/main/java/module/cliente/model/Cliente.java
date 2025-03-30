package module.cliente.model;

import module.biblioteca.service.FormatarData;

import java.sql.Date;
import java.time.LocalDate;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private Date dataNascimento;

    public Cliente(int id, String nome, String email, String cpf, LocalDate data){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;

        // Convertendo o tipo LocalDate para o tipo Datesql
        FormatarData formatar = new FormatarData();
        dataNascimento = formatar.converterDataSql(data);
    }

    public int getId() { return id;}
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public Date getDataNascimento() {return dataNascimento;}
    public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email; }

    public String dados(){
        return "{Id: " + id + " Nome: " + nome
                + " Cpf: " + cpf + " Email: " + email + " Data de nascimento: " + dataNascimento.toString() + "}";
    }
}
