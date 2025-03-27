package service.BibliotecaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatarData {

    private String dataString;
    private LocalDate dataFormatada;

    public LocalDate formatarData(String dataString){

            // Definir o formato do padrão da data
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            // Converter a String para LocalDate
            dataFormatada = LocalDate.parse(dataString, formatter);

            return dataFormatada;
    }
}
