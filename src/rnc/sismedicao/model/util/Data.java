package rnc.sismedicao.model.util;

import java.util.Calendar;  
import java.util.GregorianCalendar;

public class Data {  
  
    public static String getFormattedData(int dia, int mes, int ano) {  
        String strDia = null;  
        String strMes = null;  
        if (dia < 10) {  
            strDia = "0" + dia;  
        } else {  
            strDia = Integer.toString(dia);  
        }  
        if (mes < 10) {  
            strMes = "0" + mes;  
        } else {  
            strMes = Integer.toString(mes);  
        }  
        return strDia + "/" + strMes + "/" + Integer.toString(ano);  
    }  
  
    public static String getTodayDate() {  
        Calendar dataAtual = Calendar.getInstance();  
  
        Integer ano = dataAtual.get(Calendar.YEAR);  
        Integer mes = dataAtual.get(Calendar.MONTH);  
        Integer dia = dataAtual.get(Calendar.DAY_OF_MONTH);  
        mes += 1;  
  
        return getFormattedData(dia, mes, ano);  
    }  
  
    public static int getIntervalosEntreDatas(String dataInit, String dataFinish) {  
        int[] data1 = new int[3];  
        int[] data2 = new int[3];  
        int dias = 0;  
  
        //Desmembra dia, mes e ano das datas;  
        data1[0] = Integer.parseInt(dataInit.substring(0, 2)); //dia;  
        data1[1] = Integer.parseInt(dataInit.substring(3, 5)); //mes;  
        data1[2] = Integer.parseInt(dataInit.substring(6, 10)); //ano;  
  
        data2[0] = Integer.parseInt(dataFinish.substring(0, 2)); //dia;  
        data2[1] = Integer.parseInt(dataFinish.substring(3, 5)); //mes;  
        data2[2] = Integer.parseInt(dataFinish.substring(6, 10)); //ano;  
  
        int m1 = getDaysMonth(data1[1], data1[2]);  
        int m2 = getDaysMonth(data2[1], data2[2]);  
  
        if (data2[2] == data1[2]) { // Calculo para o mesmo ano;  
            if (data1[1] == data2[1]) {  
                dias = data2[0] - data1[0];  
            } else {  
                int diasMes1 = (m1 - data1[0]) + 1;     // numero de dias do primeiro mes (do dia x at� o dia 30);  
                int diasMes2 = m2 - (m2 - data2[0]);    // numero de dias do ultimo mes (do dia 1 at� o dia x);  
                int interMeses = (data2[1] - data1[1]); // quantidade de meses entre o primeiro e o ultimo mes;  
  
                if (interMeses == 0) {  
                    dias = diasMes1 + diasMes2;  
                } else {  
                    for (int i = 1; i < interMeses; i++) {  
                        dias += getDaysMonth(data1[1] + i, data1[2]);  
                    }  
                    dias += (diasMes1 + diasMes2);  
                }  
            }  
        } else {//Calculo para anos diferentes  
            int mesesAno1 = 12 - data1[1];          //Numero de Meses ate o fim do ano (O Mes1 n�o est� inclu�do);  
            int diasMes1 = m1 - data1[0];       //Numero de dias do Mes1(inicial);  
            for (int i = 0; i < mesesAno1; i++) {  
                dias += getDaysMonth(data1[1] + i, data1[2]);  
            }  
            dias += diasMes1;  
  
            int diasMes2 = m2 - (m2 - data2[0]);        //Numero de dias do ultimo mes do periodo;  
            int mesesAno2 = data2[1] - 1;               //Numero de meses do mes 1 ate o mes x do novo ano;  
            for (int i = 0; i < mesesAno2; i++) {  
                dias += getDaysMonth(data2[1], data2[2]);  
            }  
            dias += diasMes2;  
  
            if (data2[2] - data1[2] > 1) {  
                dias += 365 * (data2[2] - data1[2] - 1);    // quantidade de anos entre o primeiro e o ultimo ano;  
            }  
        }  
        return dias;  
    }  
  
    public static boolean yearIsBisext(int year) {  
        //Ano Bisexto (Regras do Calend�rio Gregoriano):  
        // 1 - Todo ano divis�vel por 4 � bissexto  
        // 2 - Todo ano divis�vel por 100 n�o � bissexto  
        // 3 - Mas se o ano for tamb�m divis�vel por 400 � bissexto  
        // FONTE: http://blog.webcalc.com.br/2006/04/29/o-que-e-ano-bissexto/  
        boolean retorno;  
        if (year % 4 == 0) {  
            if (year % 100 == 0) {  
                if (year % 400 == 0) {  
                    retorno = true;  
                } else {  
                    retorno = false;  
                }  
            } else {  
                retorno = true;  
            }  
        } else {  
            retorno = false;  
        }  
        return retorno;  
    }  
  
    public static int getDaysMonth(int month, int year) {  
        //O ano valor do ano ser� usado para verificar se o ano � bisexto  
        int[] mes = new int[12];  
  
        mes[0] = 31;  
  
        if (yearIsBisext(year)) {  
            mes[1] = 29;  
        } else {  
            mes[1] = 28;  
        }  
  
        mes[2] = 31;  
  
        mes[3] = 30;  
  
        mes[4] = 31;  
  
        mes[5] = 30;  
  
        mes[6] = 31;  
  
        mes[7] = 31;  
  
        mes[8] = 30;  
  
        mes[9] = 31;  
  
        mes[10] = 30;  
  
        mes[11] = 31;  
  
        return mes[month - 1];  
    }  
    
    /**
     * retorna do dia da semana
     * @param dia
     * @param mes
     * @param ano
     * @return
     */
    public String retornarDiaSemana(int dia, int mes, int ano)  
    {  
    
      Calendar calendario = new GregorianCalendar(ano, mes - 1, dia);  
      int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);  
    
      return pesquisarDiaSemana(diaSemana);  
    }  
    
   //faz a pesquisa, dado um inteiro de 1 a 7  
    private String pesquisarDiaSemana(int _diaSemana)  
    {  
      String diaSemana = null;  
    
      switch (_diaSemana)  
      {  
    
      case 1:  
      {  
        diaSemana = "Domingo";  
        break;  
      }  
      case 2:  
      {  
        diaSemana = "Segunda";  
        break;  
      }  
      case 3:  
      {  
        diaSemana = "Terca";  
        break;  
      }  
      case 4:  
      {  
        diaSemana = "Quarta";  
        break;  
      }  
      case 5:  
      {  
        diaSemana = "Quinta";  
        break;  
      }  
      case 6:  
      {  
        diaSemana = "Sexta";  
        break;  
      }  
      case 7:  
      {  
        diaSemana = "Sabado";  
        break;  
      }  
    
      }  
      return diaSemana;  
    
    }  
}