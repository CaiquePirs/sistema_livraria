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

                // Executa a consulta de todos os clientes no banco de dados
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){

                    // Obtém os dados obtidos dos clientes
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String email =  rs.getString("email");
                    String cpf = rs.getString("cpf");
                    Date dataNascimento = rs.getDate("dataNascimento");

                    // Cria um objeto do tipo Cliente com os dados obtidos
                    Cliente cliente = new Cliente(nome, email, cpf, dataNascimento);
                    cliente.setId(id);

                    // Adiciona cada cliente criado na lista de clientes
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

            // Executa a consulta dos livros no banco de dados
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){

                // Obtém os dados obtidos dos livros
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String status = rs.getString("status");
                Date dataCadastro = rs.getDate("dataCadastro");
                Date dataAtualizacao = rs.getDate("dataAtualizacao");

                // Cria um objeto do tipo Livro com os dados obtidos
                Livro livro = new Livro(titulo, autor);
                livro.setDataAtualizacao(dataAtualizacao);
                livro.setDataCadastro(dataCadastro);
                livro.setId(id);
                livro.setStatus(status);

                // Adiciona cada livro criado na lista de livros
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

                // Executa a consulta dos empréstimos no banco de dados
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()) {

                 // Obtém os dados obtidos dos empréstimos
                 int id_emprestimo = rs.getInt("id");
                 int id_cliente = rs.getInt("idCliente");
                 int id_livro = rs.getInt("idLivro");
                 Date data_emprestimo = rs.getDate("dataEmprestimo");
                 Date data_devolucao = rs.getDate("dataDevolucao");
                 String status = rs.getString("status");

                 // Pesquisa o cliente pelo id_cliente e retorna os dados do cliente que realizou o empréstimo
                 ClienteService clienteService = new ClienteService();
                 Cliente cliente = clienteService.pesquisar(id_cliente);

                 // Pesquisa o livro pelo id_livro e retorna os dados do Livro emprestado
                 LivroService livroService = new LivroService();
                 Livro livro = livroService.pesquisar(id_livro);

                 // Cria um objeto do tipo 'Empréstimo' com as informações obtidas
                 Emprestimo emprestimo = new Emprestimo(data_emprestimo, cliente, livro);
                 emprestimo.setDataDevolucao(data_devolucao);
                 emprestimo.setStatus(status);
                 emprestimo.setId(id_emprestimo);

                 // Adiciona cada empréstimo na lista de empréstimos
                 emprestimos.add(emprestimo);
                }
            }

        } catch (SQLException e){
            System.out.println("Erro ao listar os empréstimos: " + e.getMessage());
        }
        return emprestimos;
    }
}
