package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMYSQL {

    public static Connection getConexao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    ConfigBD.getUrl(),
                    ConfigBD.getUser(),
                    ConfigBD.getPassword()
            );

        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL não encontrado.");
            e.printStackTrace();
            throw new SQLException("Falha ao carregar o driver JDBC.");
        }
    }
}



