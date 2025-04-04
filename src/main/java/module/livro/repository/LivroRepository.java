package module.livro.repository;
import module.livro.model.Livro;
import java.sql.*;

import static config.ConexaoMYSQL.getConexao;

public class LivroRepository {

    public void cadastrar(Livro livro){
        try(Connection conexao = getConexao()){
            if(conexao != null) {
                String sql = "INSERT INTO livros(titulo, autor, status, dataCadastro, dataAtualizacao) VALUES(?, ?, ?, ?, ?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);

                // Obtém os dados do livro e prepara para realizar a criação
                stmt.setString(1, livro.getTitulo());
                stmt.setString(2, livro.getAutor());
                stmt.setString(3, livro.getStatus());
                stmt.setDate(4, livro.getDataCadastro());
                stmt.setDate(5, livro.getDataAtualizacao());

                // Executa a criação do livro no banco de dados
                stmt.executeUpdate();
                System.out.println("Livro cadastrado com sucesso!");
            }
        } catch (SQLException e){
            System.err.println("Erro ao cadastrar o livro: " + e.getMessage());
        }
    }

    public void atualizar(Livro livro){
        try(Connection conexao = getConexao()){
            if(conexao != null) {
                String sql = "UPDATE livros SET titulo = ?, autor = ?, status = ?, dataAtualizacao = ? WHERE id = ?";
                PreparedStatement stmt = conexao.prepareStatement(sql);

                // Pega os dados do livro e realiza as alterações no banco de dados
                stmt.setString(1, livro.getTitulo());
                stmt.setString(2, livro.getAutor());
                stmt.setString(3, livro.getStatus());
                stmt.setDate(4, livro.getDataAtualizacao());
                stmt.setInt(5, livro.getId());

                // Verifica se existe um livro com ID selecionado e executa a atualização
                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Livro atualizado com sucesso");
                } else {
                    System.out.println("Id do Livro não encontrado");
                }
            }
        } catch (SQLException e){
            System.out.println("Erro ao atualizar o livro: " + e.getMessage());
        }

    }

    public Livro pesquisar(int id ){
        Livro livro = null;

        try(Connection conexao = getConexao()){
            if(conexao != null) {
                String sql = "SELECT * FROM livros WHERE id = ?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    // Pega os dados do livro através do ID inserido
                    int idLivro = rs.getInt("id");
                    String titulo = rs.getString("titulo");
                    String autor = rs.getString("autor");
                    String status = rs.getString("status");
                    Date dataCadastro = rs.getDate("dataCadastro");
                    Date dataAtualizacao = rs.getDate("dataAtualizacao");

                    // Salva os dados do Livro com os dados obtidos
                    livro = new Livro(titulo, autor);
                    livro.setId(idLivro);
                    livro.setStatus(status);
                    livro.setDataCadastro(dataCadastro);
                    livro.setDataAtualizacao(dataAtualizacao);

                } else {
                    System.out.println("Livro não encontrado");
                }
            }

        } catch(SQLException e){
            System.out.println("Erro ao pesquisar o livro: " + e.getMessage());
        }
        return livro;
    }

    public void excluir(int id ){
        try(Connection conexao = getConexao()){
            if(conexao != null) {
                String sql = "DELETE FROM livros WHERE id = ?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, id);

                // Executa a exclusão do livro através do ID selecionado
                int rows = stmt.executeUpdate();
                if(rows > 0){
                    System.out.println("Livro excluído com sucesso");

                }else {
                    System.out.println("Livro não encontrado");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir o livro: " + e.getMessage());;
        }

    }

}
