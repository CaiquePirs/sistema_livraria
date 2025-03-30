package module.cliente.repository;
import module.cliente.model.Cliente;
import java.sql.*;
import static config.ConexaoMYSQL.getConexao;

public class ClienteRepository {

    public void criar(Cliente cliente){

        try (Connection conexao = getConexao()) {
            if (conexao != null) {
                String sql = "INSERT INTO clientes (id, nome, email, cpf, dataNascimento) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);

                stmt.setInt(1, cliente.getId());
                stmt.setString(2, cliente.getNome());
                stmt.setString(3, cliente.getEmail());
                stmt.setString(4, cliente.getCpf());
                stmt.setDate(5, cliente.getDataNascimento());
                stmt.executeUpdate();
                System.out.println("Cliente cadastrado com sucesso!");

            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar o cliente: " + e.getMessage());
        }
    }

    public void atualizar(Cliente cliente){

        try (Connection conexao = getConexao()) {
            if (conexao != null) {
                String sql = "UPDATE clientes SET nome = ?, email = ?, cpf = ?, dataNascimento = ? WHERE id = ?";
                PreparedStatement stmt = conexao.prepareStatement(sql);

                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getEmail());
                stmt.setString(3, cliente.getCpf());
                stmt.setDate(4, cliente.getDataNascimento());
                stmt.setInt(5, cliente.getId());

                int rows = stmt.executeUpdate();
                if (rows > 0){
                    System.out.println("Cliente atualizado com sucesso!");
                } else {
                    System.out.println("Não existe cliente com esse ID.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o cliente: " + e.getMessage());
        }

    }

    public void excluir(int id){

        try (Connection conexao = getConexao()) {
            if (conexao != null) {
                String sql = "DELETE FROM clientes WHERE id = ?";
                PreparedStatement stmt = conexao.prepareStatement(sql);

                stmt.setInt(1, id);

                int rows = stmt.executeUpdate();
                if (rows > 0){
                    System.out.println("Cliente excluído com sucesso!");
                } else {
                    System.out.println("Não existe cliente com esse ID.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluír o cliente: " + e.getMessage());
        }

    }

}
