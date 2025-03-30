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


}
