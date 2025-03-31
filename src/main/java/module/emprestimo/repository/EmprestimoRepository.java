package module.emprestimo.repository;

import module.emprestimo.model.Emprestimo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static config.ConexaoMYSQL.getConexao;

public class EmprestimoRepository {

    public void criar(Emprestimo emprestimo){
        try(Connection conexao = getConexao()){
            if(conexao != null){
                String sql = "INSERT INTO emprestimos(id, dataEmprestimo, idCliente, idLivro, status) VALUES(?, ?, ?, ?, ?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);

                // Cria o empréstimo no banco de dados
                stmt.setInt(1, emprestimo.getId());
                stmt.setDate(2, emprestimo.getDataEmprestimo());
                stmt.setInt(3, emprestimo.getCliente().getId());
                stmt.setInt(4, emprestimo.getLivro().getId());
                stmt.setString(5, "Ativo");
                stmt.executeUpdate();

                // Altera o status do livro para indisponível ao ser emprestado
                String sql1 = "UPDATE livros SET status = 'Indisponível' WHERE id = ? ";
                PreparedStatement stmt1 = conexao.prepareStatement(sql1);
                stmt1.setInt(1, emprestimo.getLivro().getId());
                stmt1.executeUpdate();

                System.out.println("Empréstimo do livro criado com sucesso!");
            }

        }catch (SQLException e){
            System.out.println("Erro ao criar o empréstimo: " + e.getMessage());
        }

    }

    public void pesquisar(){

    }

    public void devolver(){

    }

    public void excluir(){

    }
}
