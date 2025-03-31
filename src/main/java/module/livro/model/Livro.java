package module.livro.model;

import java.sql.Date;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String status;
    private Date dataCadastro;
    private Date dataAtualizacao;

   public Livro(int id, String titulo, String autor, Date data){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.dataCadastro = data;
        status = "Disponível";
        setDataAtualizacao(dataCadastro);
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

    public String dados(){
        return "Id: " + id + " Titulo: " + titulo
                + " Autor: " + autor + " Disponibilidade: " + getStatus() + " Data de cadastro: " + dataCadastro.toString()
                + " Data de atualização: " + dataAtualizacao.toString();
    }


}
