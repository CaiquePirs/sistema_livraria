package module.biblioteca.view;

import java.sql.Date;
import java.util.InputMismatchException;

import module.cliente.model.Cliente;
import module.cliente.service.ClienteService;

public class MenuCliente extends MenuPrincipal {
    private ClienteService service = new ClienteService();

    public void menu() {
        int opcao;

        while (true) {
            System.out.println("\nMenu cliente");
            System.out.println("(1) - Cadastrar cliente");
            System.out.println("(2) - Atualizar cliente");
            System.out.println("(3) - Excluir cliente");
            System.out.println("(4) - Pesquisar cliente");
            System.out.println("(5) - Voltar ao menu principal");
            System.out.println("(6) - Encerrar");
            System.out.print("Opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarCliente();
                        break;
                    case 2:
                        atualizarCliente();
                        break;
                    case 3:
                        excluirCliente();
                        break;
                    case 4:
                        pesquisarCliente();
                        break;
                    case 5:
                        menuInicial();
                        return;
                    case 6:
                        System.out.println("Encerrando...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine();
            }
        }
    }

    private void cadastrarCliente() {
        System.out.println("\t\n------Cadastrar Cliente------");
        try {
            System.out.print("Informe o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Informe o email: ");
            String email = scanner.nextLine();

            System.out.print("Informe o CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Informe a data de nascimento (Formato: yyyy-MM-dd): ");
            String dataNascimentoString = scanner.nextLine();
            Date dataNascimento = Date.valueOf(dataNascimentoString);

            service.cadastrar(nome, email, cpf, dataNascimento);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar cliente. Verifique os dados e tente novamente.");
        }
    }

    private void atualizarCliente() {
        System.out.println("\t\n------Atualizar Cliente------");
        try {
            System.out.print("Informe o ID do cliente: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Informe o novo nome: ");
            String nomeNovo = scanner.nextLine();

            System.out.print("Informe o novo email: ");
            String emailNovo = scanner.nextLine();

            System.out.print("Informe o novo CPF: ");
            String cpfNovo = scanner.nextLine();

            System.out.print("Informe a nova data de nascimento (Formato: yyyy-MM-dd): ");
            String dataString = scanner.nextLine();
            Date dataNascimentoNova = Date.valueOf(dataString);

            service.atualizar(id, nomeNovo, emailNovo, cpfNovo, dataNascimentoNova);

        } catch (InputMismatchException e) {
            System.out.println("ID inválido. Insira um número inteiro.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: Verifique os dados e tente novamente.");
        }
    }

    private void excluirCliente() {
        System.out.println("\t\n------Excluir Cliente------");
        try {
            System.out.print("Informe o ID do cliente: ");
            int idCliente = scanner.nextInt();
            scanner.nextLine();

            service.excluir(idCliente);

        } catch (InputMismatchException e) {
            System.out.println("ID inválido. Insira um número inteiro.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao excluir cliente. Verifique o ID.");
        }
    }

    private void pesquisarCliente() {
        System.out.println("\t\n------Pesquisar Cliente------");
        try {
            System.out.print("Informe o ID do cliente: ");
            int id_cliente = scanner.nextInt();
            scanner.nextLine();

            Cliente cliente = service.pesquisar(id_cliente);
            System.out.println(cliente.dados());

        } catch (InputMismatchException e) {
            System.out.println("ID inválido. Insira um número inteiro.");
            scanner.nextLine();
        }
    }
}
