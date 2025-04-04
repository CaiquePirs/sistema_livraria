package module.biblioteca.repository;
import module.cliente.model.Cliente;
import module.livro.model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static config.ConexaoMYSQL.getConexao;

public class BibliotecaRepository {

    public List<Cliente> buscarClientes(){
        List<Cliente> clientes = new ArrayList<>();

        try(Connection conexao = getConexao()){
            if(conexao != null){
                String sql = "SELECT * FROM clientes ORDER BY id ASC";
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                       clientes.add(new Cliente(
                               rs.getInt("id"),
                               rs.getString("nome"),
                               rs.getString("email"),
                               rs.getString("cpf"),
                               rs.getDate("dataNascimento")
                               ));
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar os clientes: " + e.getMessage());
        }
       return clientes;
    }

    public List<Livro> buscarLivros(){
        List<Livro> livros = new ArrayList<>();

        try(Connection conexao = getConexao()){
            String sql = "SELECT * FROM livros ORDER BY id ASC";
            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String status = rs.getString("status");
                Date dataCadastro = rs.getDate("dataCadastro");
                Date dataAtualizacao = rs.getDate("dataAtualizacao");
                Livro livro = new Livro(id, titulo, autor, dataCadastro);

                livro.setDataAtualizacao(dataAtualizacao);
                livro.setStatus(status);
                livros.add(livro);
            }

        }catch (SQLException e){
            System.out.println("Erro ao listar os livros: " + e.getMessage());
        }
        return livros;
    }

    public void listarEmprestimos(){

    }
}
