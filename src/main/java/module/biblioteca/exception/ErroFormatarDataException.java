package module.biblioteca.exception;

public class ErroFormatarDataException extends RuntimeException{
    public String ErroFormatarDataException(String menssagem){
        return "Erro ao formatar a data";
    }
}
