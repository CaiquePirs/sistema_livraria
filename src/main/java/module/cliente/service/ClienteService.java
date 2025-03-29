package module.cliente.service;

import module.biblioteca.service.FormatarData;
import module.cliente.model.Cliente;

import java.time.LocalDate;

public class ClienteService {
    public void criar(int id, String nome,String email, String dataString){

        LocalDate dataNascimento;
        Cliente cliente = null;
        FormatarData formatarData = null;

        dataNascimento = formatarData.formatar(dataString);

        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setDataNascimento(dataNascimento);

    }

    public void editar(){

    }

    public void excluir(){

    }

}
