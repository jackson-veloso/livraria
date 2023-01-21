package br.com.letscode.livraria.utilitaria;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilitaria {
        private static final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    public static boolean isMaiorIdade(Date data){
        Date dataAtual = new Date();
        data.setYear(data.getYear()+18);
        return data.equals(dataAtual) || data.before(dataAtual);
    }

    public static boolean isMaiorIdade(String data) throws ParseException {
        return isMaiorIdade(parseDate(data));
    }

    public static Date parseDate(String data) throws ParseException {
        Date dataLocal = formato.parse(data);
        return dataLocal;
    }
}
