package module.biblioteca.repository;
import module.cliente.model.Cliente;
import module.cliente.service.ClienteService;
import module.emprestimo.model.Emprestimo;
import module.livro.model.Livro;
import module.livro.service.LivroService;

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
                Livro livro = new Livro(id, titulo, autor, dataCadastro);

                livro.setDataAtualizacao(dataAtualizacao);
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

                 // Pesquisa o cliente pelo id_cliente e retorna os dados do cliente que realizou o empréstimo
                 ClienteService clienteService = new ClienteService();
                 Cliente cliente = clienteService.pesquisar(id_cliente);

                 // Pesquisa o livro pelo id_livro e retorna os dados do Livro empréstado
                 LivroService livroService = new LivroService();
                 Livro livro = livroService.pesquisar(id_livro);

                 // Cria um objeto do tipo 'Empréstimo' com as informações obtidas
                 Emprestimo emprestimo = new Emprestimo(id_emprestimo, data_emprestimo, cliente, livro);
                 emprestimo.setDataDevolucao(data_devolucao);
                 emprestimo.setStatus(status);

                 // Adiciona cada empréstimo cadastrado na lista de empréstimos
                 emprestimos.add(emprestimo);
                }
            }

        } catch (SQLException e){
            System.out.println("Erro ao listar os empréstimos: " + e.getMessage());
        }
        return emprestimos;
    }
}
