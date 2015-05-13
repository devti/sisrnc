package rnc.sismedicao.model.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {

	/**
	 * @param args
	 * @throws ParseException
	 */

	private static int calculateUtilDays(Calendar startDate, Calendar endDate) {
		return calculateDays(normalizeCalendar(startDate),
				normalizeCalendar(endDate), 0, true);
	}

	public static int calculateDays(Calendar startDate, Calendar endDate) {
		return calculateDays(normalizeCalendar(startDate),
				normalizeCalendar(endDate), 0, false);
	}

	private static int calculateDays(Calendar startDate, Calendar endDate,
			int count, boolean validateUtilDay) {
		if (startDate.compareTo(endDate) > 0) {
			return count;
		} else if (isWeekend(startDate) && validateUtilDay) {
			startDate.add(Calendar.DAY_OF_WEEK, 1);
			return calculateDays(normalizeCalendar(startDate),
					normalizeCalendar(endDate), count, validateUtilDay);
		} else {
			count += 1;
			startDate.add(Calendar.DAY_OF_WEEK, 1);
			return calculateDays(normalizeCalendar(startDate),
					normalizeCalendar(endDate), count, validateUtilDay);
		}
	}

	private static boolean isWeekend(Calendar calendar) {
		return (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || calendar
				.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY);
	}

	private static Calendar normalizeCalendar(Calendar calendar) {
		Calendar calNormalize = (Calendar) calendar.clone();
		calNormalize.set(GregorianCalendar.HOUR, 0);
		calNormalize.set(GregorianCalendar.MINUTE, 0);
		calNormalize.set(GregorianCalendar.SECOND, 0);
		calNormalize.set(GregorianCalendar.MILLISECOND, 0);
		calNormalize.set(GregorianCalendar.AM_PM, 0);
		return calNormalize;
	}

	/**
	 * CONVERTE UM NOME DO DIA DA SEMANA PARA UM VALOR INTEIRO
	 * 
	 * @param _diaSemana
	 * @return
	 */
	public int converteDiaSemana(String dia) {
		int diaSemana = 0;

		switch (dia) {

		case "Domingo": {
			diaSemana = 1;
			break;
		}
		case "Segunda": {
			diaSemana = 2;
			break;
		}
		case "Terça": {
			diaSemana = 3;
			break;
		}
		case "Quarta": {
			diaSemana = 4;
			break;
		}
		case "Quinta": {
			diaSemana = 5;
			break;
		}
		case "Sexta": {
			diaSemana = 6;
			break;
		}
		case "Sábado": {
			diaSemana = 7;
			break;
		}

		}
		return diaSemana;

	}
	
	/**
	 * converter String para Text Field
	 */
	public static String converteDataStringTextField(String data) {
		String dt, dd, mm, aaaa = null;
		dd = data.substring(8, 10);
		mm = data.substring(5, 7);
		aaaa = data.substring(0, 4);
		dt = dd + "/" + mm + "/" + aaaa;
		return dt;
	}


}