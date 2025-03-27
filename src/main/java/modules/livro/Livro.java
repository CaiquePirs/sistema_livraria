package modules.livro;

import java.time.LocalDate;

public class Livro {

    private int id;
    private String titulo;
    private Autor autor;
    private boolean status = false;
    private LocalDate dataCadastro;
    private  LocalDate dataAtualizacao;

    Livro(int id, String titulo, Autor autor, LocalDate dataCadastro, LocalDate dataAtualizacao){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        status = true;
    }

    private String livroInformacao(){

        return "Id do livro: " + id + " Titulo: " + titulo
                + " Autor: " + autor.getNome() + " Disponibilidade " + (status ? "Disponível" : "Indisponível")  + " Data de cadastro: " + dataCadastro
                + " Data de atualização: " + dataAtualizacao;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public LocalDate getDataCadastro(){
       return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro){
        this.dataCadastro = dataCadastro;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
