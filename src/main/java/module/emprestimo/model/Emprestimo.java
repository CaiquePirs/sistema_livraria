package module.emprestimo.model;

import module.cliente.model.Cliente;
import module.livro.model.Livro;

import java.sql.Date;

public class Emprestimo {
    private int id;
    private Date dataEmprestimo;
    private Livro livro;
    private Cliente cliente;
    private String status;

    public Emprestimo(int id, Date dataEmprestimo, Cliente cliente, Livro livro){
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.cliente = cliente;
        this.livro = livro;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Livro getLivro() { return livro; }
    public void setLivro(Livro livro) { this.livro = livro; }

    public Date getDataEmprestimo() { return dataEmprestimo; }
    public void setDataEmprestimo(Date dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String dados(){
        return "{ Id: " + id + " Cliente: " + cliente.getNome() + " Cpf: " + cliente.getCpf()
                + " Email: " + cliente.getEmail()
                + " Livro: " + livro.getTitulo() + " Data do empréstimo: " + dataEmprestimo.toString()
                + " Status: " + getStatus() + " }";
    }

}
