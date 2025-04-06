package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMYSQL {

    public static Connection getConexao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    ConfigBD.getUrl(), // Obtém a url do banco de dados
                    ConfigBD.getUser(), //  Obtém a credêncial do usuário para acessar o banco de dados
                    ConfigBD.getPassword() // Obtém a senha de acesso ao banco de dados
            );

        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL não encontrado.");
            e.printStackTrace();
            throw new SQLException("Falha ao carregar o driver JDBC.");
        }
    }
}



