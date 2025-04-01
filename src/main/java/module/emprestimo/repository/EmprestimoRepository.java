package module.emprestimo.repository;

import module.cliente.model.Cliente;
import module.cliente.service.ClienteService;
import module.emprestimo.model.Emprestimo;
import module.livro.model.Livro;
import module.livro.service.LivroService;

import java.sql.*;

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

    public void pesquisar(int id){
        try(Connection conexao = getConexao()){
            if(conexao != null){
                String sql = "SELECT * FROM emprestimos WHERE id = ?";
                PreparedStatement stmt = conexao.prepareCall(sql);
                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    int id_emprestimo = rs.getInt("id");
                    int id_livro = rs.getInt("idLivro");
                    int id_cliente = rs.getInt("idCliente");
                    Date data_emprestimo = rs.getDate("dataEmprestimo");
                    String status = rs.getString("status");

                    // Pesquisa o cliente no banco de dados através do id_cliente e retorna os dados do Cliente
                    Cliente cliente = null;
                    ClienteService service = new ClienteService();
                    cliente = service.pesquisar(id_cliente);

                    // Pesquisa o livro no banco de dados através do id_livro e retorna os dados do livro
                    Livro livro = null;
                    LivroService livroService = new LivroService();
                    livro = livroService.pesquisar(id_livro);

                    Emprestimo emprestimo = new Emprestimo(id_emprestimo, data_emprestimo, cliente, livro);
                    emprestimo.setStatus(status);
                    System.out.println(emprestimo.dados());

                } else {
                    System.out.println("Id do empréstimo não encontrado");
                }

            }

        }catch(SQLException e){
            System.out.println("Erro ao consultar o empréstimo: " + e.getMessage());
        }
    }

    public void devolver(){

    }

    public void excluir(){

    }
}
