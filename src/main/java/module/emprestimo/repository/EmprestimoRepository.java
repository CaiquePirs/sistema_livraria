package module.emprestimo.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static config.ConexaoMYSQL.getConexao;
import module.cliente.model.Cliente;
import module.cliente.service.ClienteService;
import module.emprestimo.model.Emprestimo;
import module.emprestimo.service.EmprestimoService;
import module.livro.model.Livro;
import module.livro.service.LivroService;

public class EmprestimoRepository {

    public void criar(Emprestimo emprestimo) {
        try (Connection conexao = getConexao()) {
            if (conexao != null) {
                String sql = "INSERT INTO emprestimos(dataEmprestimo, idCliente, idLivro, status) VALUES(?, ?, ?, ?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);

                stmt.setDate(1, emprestimo.getDataEmprestimo());
                stmt.setInt(2, emprestimo.getCliente().getId());
                stmt.setInt(3, emprestimo.getLivro().getId());
                stmt.setString(4, "Ativo");
                stmt.executeUpdate();

                String sql1 = "UPDATE livros SET status = 'Indisponível' WHERE id = ? ";
                PreparedStatement stmt1 = conexao.prepareStatement(sql1);
                stmt1.setInt(1, emprestimo.getLivro().getId());
                stmt1.executeUpdate();

                System.out.println("Empréstimo do livro criado com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao criar o empréstimo: " + e.getMessage());
        }

    }

    public Emprestimo pesquisar(int id) {
        Emprestimo emprestimo = null;

        try (Connection conexao = getConexao()) {
            if (conexao != null) {
                String sql = "SELECT * FROM emprestimos WHERE id = ?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {

                    int id_emprestimo = rs.getInt("id");
                    int id_livro = rs.getInt("idLivro");
                    int id_cliente = rs.getInt("idCliente");
                    String status = rs.getString("status");
                    Date data_emprestimo = rs.getDate("dataEmprestimo");
                    Date data_devolucao = rs.getDate("dataDevolucao");

                    Cliente cliente = null;
                    ClienteService service = new ClienteService();
                    cliente = service.pesquisar(id_cliente);

                    Livro livro = null;
                    LivroService livroService = new LivroService();
                    livro = livroService.pesquisar(id_livro);

                    emprestimo = new Emprestimo(cliente, livro);
                    emprestimo.setId(id_emprestimo);
                    emprestimo.setStatus(status);
                    emprestimo.setDataDevolucao(data_devolucao);
                    emprestimo.setDataEmprestimo(data_emprestimo);

                } else {
                    System.out.println("Id do empréstimo não encontrado");
                }

            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar o empréstimo: " + e.getMessage());
        }
        return emprestimo;
    }

    public void devolver(int id) {
        try (Connection conexao = getConexao()) {
            if (conexao != null) {
                LocalDate data = LocalDate.now();
                Date data_atual = Date.valueOf(data);

                String sql = "UPDATE emprestimos SET status = 'Devolvido', dataDevolucao = ? WHERE id = ?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setDate(1, data_atual);
                stmt.setInt(2, id);

                Emprestimo emprestimo = null;
                EmprestimoService service = new EmprestimoService();
                emprestimo = service.pesquisar(id);

                if (emprestimo.getStatus().equals("Devolvido")) {
                    System.out.println("O empréstimo do livro já foi devolvido");

                } else {
                    int rows = stmt.executeUpdate();
                    if (rows > 0) {

                        String sql1 = "UPDATE livros SET status = 'Disponível' WHERE id = ? ";
                        PreparedStatement stmt1 = conexao.prepareStatement(sql1);
                        stmt1.setInt(1, emprestimo.getLivro().getId());
                        stmt1.executeUpdate();

                        System.out.println("Livro devolvido com sucesso!");
                    } else {
                        System.out.println("Empréstimo não encontrado");
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao devolver o empréstimo do livro: " + e.getMessage());;
        }
    }

    public void excluir(int id) {
        try (Connection conexao = getConexao()) {
            if (conexao != null) {
                String sql = "DELETE FROM emprestimos WHERE id = ?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, id);

                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Empréstimo excluído com sucesso");
                } else {
                    System.out.println("Id do empréstimo não encontrado");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao tentar excluir o empréstimo: " + e.getMessage());
        }
    }
}
