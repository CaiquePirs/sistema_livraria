package module.livro.model;

import module.biblioteca.service.FormatarData;

import java.sql.Date;
import java.time.LocalDate;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private boolean status = false;
    private Date dataCadastro;
    private Date dataAtualizacao;

   public Livro(int id, String titulo, String autor, LocalDate data){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        status = true;

        // Método para converter a data do tipo LocalDate para Date
        FormatarData formatarData = new FormatarData();
        dataCadastro = formatarData.converterDataSql(data);
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

    public boolean getStatus() { return status; }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public String dados(){
        return "Id: " + id + " Titulo: " + titulo
                + " Autor: " + autor + " Disponibilidade " + (status ? " Disponível" : " Indisponível")  + " Data de cadastro: " + dataCadastro.toString()
                + " Data de atualização: " + dataAtualizacao.toString();
    }


}
