package module.livro.repository;

import module.livro.model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static config.ConexaoMYSQL.getConexao;

public class LivroRepository {

    public void cadastrar(Livro livro){
        try(Connection conexao = getConexao()){
            String sql = "INSERT INTO livros(id, titulo, autor, statusLivro, dataCadastro, dataAtualizacao) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, livro.getId());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getAutor());
            stmt.setBoolean(4, livro.getStatus());
            stmt.setDate(5, livro.getDataCadastro());
            stmt.setDate(6, livro.getDataAtualizacao());
            stmt.executeUpdate();
            System.out.println("Livro cadastrado com sucesso!");

        } catch (SQLException e){
            System.err.println("Erro ao cadastrar o livro: " + e.getMessage());
        }
    }

    public void atualizar(Livro livro){
        try(Connection conexao = getConexao()){
            String sql = "UPDATE livros SET titulo = ?, autor = ?, statusLivro = ?, dataAtualizacao = ? WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setBoolean(3, livro.getStatus());
            stmt.setDate(4, livro.getDataAtualizacao());
            stmt.setInt(5, livro.getId());

            int rows = stmt.executeUpdate();
            if (rows > 0){
                System.out.println("Livro atualizado com sucesso");
            } else {
                System.out.println("Id do Livro não encontrado");
            }

        } catch (SQLException e){
            System.out.println("Erro ao atualizar o livro");
        }

    }

    public void pesquisar(){

    }

    public void excluir(){

    }

}
