package module.biblioteca.repository;
import module.cliente.model.Cliente;

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

    public void listarLivros(){

    }

    public void listarEmprestimos(){

    }
}
