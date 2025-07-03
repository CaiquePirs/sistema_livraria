package module.livro.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String status;
    private Date dataCadastro;
    private Date dataAtualizacao;

   public Livro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
        status = "Disponível";
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }
    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Date getDataCadastro(){
       return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro){
        this.dataCadastro = dataCadastro;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataCadastroFormatada() {
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        return formatar.format(this.dataCadastro);
    }

    public String getDataAtualizacaoFormatada() {
       if(dataAtualizacao == null || dataAtualizacao.equals("")){
        return "Atualizado";
       }else {
           SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
           return formatar.format(this.dataAtualizacao);
       }
       }

    public String dados(){
        return "{Id: " + id + ", Titulo: " + titulo
                + ", Autor: " + autor + ", Disponibilidade: " + getStatus() + ", Data de cadastro: " + getDataCadastroFormatada()
                + ", Data de atualização: " + getDataAtualizacaoFormatada() + "}";
    }


}
