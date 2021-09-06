package br.com.alelo.utils;

public class FormatarData {

    public static String dataUS(String data){

        String dataFormatada = data.substring(0,4)+"/"+data.substring(4,6)+"/"+data.substring(6,8);

        return dataFormatada;
    }

    public String dataBR(String data){
        return data.substring(0,2)+"/"+data.substring(2,4)+"/"+data.substring(4,8);
    }
}
