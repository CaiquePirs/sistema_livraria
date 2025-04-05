package module.biblioteca.Menu;

import module.cliente.model.Cliente;
import module.cliente.service.ClienteService;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCliente extends MenuPrincipal {
    private Scanner scanner = new Scanner(System.in);
    private ClienteService service = new ClienteService();

    public void menuCliente(){
        System.out.println("\nMenu Cliente");
        System.out.println("(1) - Cadastrar cliente");
        System.out.println("(2) - Atualizar cliente");
        System.out.println("(3) - Excluir cliente");
        System.out.println("(4) - Pesquisar cliente");
        System.out.println("(5) - Voltar ao menu principal");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        while (opcao != 5) {
            switch (opcao) {
                case 1:
                    System.out.println("\t\n------Cadastrar Cliente------");
                   try {
                       System.out.print("Informe o nome: ");
                       String nome = scanner.nextLine();

                       System.out.print("Informe o email: ");
                       String email = scanner.nextLine();

                       System.out.print("Informe o cpf: ");
                       String cpf = scanner.nextLine();

                       System.out.print("Informe a data de nascimento Formato: (yyyy-MM-dd): ");
                       String dataNascimentoString = scanner.nextLine();
                       Date dataNascimento = Date.valueOf(dataNascimentoString); // Converte a data String para Date

                       // Realiza o cadastro do cliente no banco de dados
                       service.Cadastrar(nome, email, cpf, dataNascimento);
                       menuCliente(); // Volta para o menu cliente

                   } catch (InputMismatchException | IllegalArgumentException e){
                       System.out.println("Entrada invalida, digite o valor válido!");
                   }
                    break;

                case 2:
                    System.out.println("\t\n------Atualizar Cliente------");
                try {
                    System.out.print("Informe o ID do cliente: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Informe o novo nome: ");
                    String nomeNovo = scanner.nextLine();

                    System.out.print("Informe o novo email: ");
                    String emailNovo = scanner.nextLine();

                    System.out.print("Informe o novo cpf: ");
                    String cpfNovo = scanner.nextLine();

                    System.out.print("Informe a nova data de nascimento Formato (yyyy-MM-dd): ");
                    String dataString = scanner.nextLine();
                    Date dataNascimentoNova = Date.valueOf(dataString); // Converte a data String para Date

                    // Realiza a atualização dos dados do cliente no banco de dados
                    service.atualizar(id, nomeNovo, emailNovo, cpfNovo, dataNascimentoNova);
                    menuCliente(); // retoma ao menu do cliente

            } catch (InputMismatchException | IllegalArgumentException e){
                    System.out.println("Entrada invalida, digite o valor válido!\n");
                }
                    break;

                case 3:
                    System.out.println("\t\n------Excluir Cliente------");
                    try {
                        System.out.print("Informe o ID do cliente: ");
                        int idCliente = scanner.nextInt();
                        service.excluir(idCliente); // Realiza a exclusão do cliente no banco de dados
                        menuCliente(); // Volta para o menu Cliente

                    } catch (InputMismatchException | IllegalArgumentException e){
                        System.out.println("Entrada invalida, digite o valor válido!");
                    }
                    break;

                case 4:
                    System.out.println("\t\n------Pesquisar Cliente------");
                 try {
                    System.out.print("Informe o ID do cliente: ");
                    int id_cliente = scanner.nextInt();

                    // Retorna os dados do cliente Cadastrado
                    Cliente cliente = service.pesquisar(id_cliente);
                    System.out.println(cliente.dados()); // Exibe os dados do cliente
                    menuCliente(); // Volta para o menu Cliente

            } catch (InputMismatchException | IllegalArgumentException e){
                     System.out.println("Entrada invalida, digite o valor válido!");
                 }
                    break;


                case 5:
                    menuPrincipal();
                    break;

                default:
                    System.out.println("Insira a opção do menu válida.");
                    break;
            }
        }

    }
}
