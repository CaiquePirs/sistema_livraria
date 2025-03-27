package module.biblioteca.service;

import module.biblioteca.exception.ErroFormatarDataException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatarData {

    private LocalDate dataFormatada;

    public LocalDate formatarData(String dataString) throws ErroFormatarDataException{

            // Definir o formato do padrão da data
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            // Converter a String para LocalDate
            dataFormatada = LocalDate.parse(dataString, formatter);

            return dataFormatada;

    }
    }
