package module.biblioteca.repository;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static config.ConexaoMYSQL.getConexao;
import module.cliente.model.Cliente;
import module.cliente.service.ClienteService;
import module.emprestimo.model.Emprestimo;
import module.livro.model.Livro;
import module.livro.service.LivroService;

public class BibliotecaRepository {

    public List<Cliente> buscarClientes(){
        List<Cliente> clientes = new ArrayList<>();

        try(Connection conexao = getConexao()){
            if(conexao != null){
                String sql = "SELECT * FROM clientes ORDER BY id ASC";
                Statement stmt = conexao.createStatement();

                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){

                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String email =  rs.getString("email");
                    String cpf = rs.getString("cpf");
                    Date dataNascimento = rs.getDate("dataNascimento");

                    Cliente cliente = new Cliente(nome, email, cpf, dataNascimento);
                    cliente.setId(id);

                    clientes.add(cliente);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar os clientes: " + e.getMessage());
        }
       return clientes;
    }

    public List<Livro> buscarLivros(){
        List<Livro> livros = new ArrayList<>();

        try(Connection conexao = getConexao()){
            String sql = "SELECT * FROM livros ORDER BY id ASC";
            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){

                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String status = rs.getString("status");
                Date dataCadastro = rs.getDate("dataCadastro");
                Date dataAtualizacao = rs.getDate("dataAtualizacao");

                Livro livro = new Livro(titulo, autor);
                livro.setDataAtualizacao(dataAtualizacao);
                livro.setDataCadastro(dataCadastro);
                livro.setId(id);
                livro.setStatus(status);

                livros.add(livro);
            }

        }catch (SQLException e){
            System.out.println("Erro ao listar os livros: " + e.getMessage());
        }
        return livros;
    }

    public List<Emprestimo> buscarEmprestimos(){
        List<Emprestimo> emprestimos = new ArrayList<>();

        try(Connection conexao = getConexao()){
            if(conexao != null){
                String sql = "SELECT * FROM emprestimos ORDER BY id ASC";
                Statement stmt = conexao.createStatement();

                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()) {

                 int id_emprestimo = rs.getInt("id");
                 int id_cliente = rs.getInt("idCliente");
                 int id_livro = rs.getInt("idLivro");
                 Date data_emprestimo = rs.getDate("dataEmprestimo");
                 Date data_devolucao = rs.getDate("dataDevolucao");
                 String status = rs.getString("status");

                 ClienteService clienteService = new ClienteService();
                 Cliente cliente = clienteService.pesquisar(id_cliente);

                 LivroService livroService = new LivroService();
                 Livro livro = livroService.pesquisar(id_livro);

                 Emprestimo emprestimo = new Emprestimo(cliente, livro);
                 emprestimo.setDataDevolucao(data_devolucao);
                 emprestimo.setDataEmprestimo(data_emprestimo);
                 emprestimo.setStatus(status);
                 emprestimo.setId(id_emprestimo);
                 
                 emprestimos.add(emprestimo);
                }
            }

        } catch (SQLException e){
            System.out.println("Erro ao listar os empréstimos: " + e.getMessage());
        }
        return emprestimos;
    }
}
