package module.biblioteca.service;

import module.biblioteca.exception.ErroFormatarDataException;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatarData {

    private LocalDate dataFormatada;

    public LocalDate formatarLocalDate(String dataString) throws ErroFormatarDataException{

           try{
               // Formato padrão da data
               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

               // Converter a String para LocalDate
               dataFormatada = LocalDate.parse(dataString, formatter);
               return dataFormatada;

           }catch(ErroFormatarDataException e){
               throw new ErroFormatarDataException();
           }

    }

    public Date converterDataSql(LocalDate data){
        try{
            // Convertendo o tipo LocalDate para o tipo Datesql
            Date sqldate = Date.valueOf(data);
            return sqldate;

        } catch (ErroFormatarDataException e){
            throw new ErroFormatarDataException();
        }

    }
}
