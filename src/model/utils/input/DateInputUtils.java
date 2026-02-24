/* Classe responsável pela leitura e validação de datas e horários.
   garantindo uso de formatos padronizados nas operações do sistema. */

package model.utils.input;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public final class DateInputUtils {
	
	// Definição do formato de data.
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	
	// Método responsável pela leitura e validação de datas.
	public static LocalDate readDate(String msg, Scanner sc) {
		while(true) {
			try {
				System.out.print(msg);
				LocalDate value = LocalDate.parse(sc.nextLine().trim(), fmt);
				return value;
			}
			catch(DateTimeException e) {
				System.out.printf("Formato de data inválido, tente novamente usando o seguinte formato: dd/MM/yyyy.%n%n");
			}
		}
	}
		
	// Método responsável pela captura atual de data/hora no formato dd/MM/yyyy HH:mm:ss.
	public static LocalDateTime getCurrentDateTime() {
		LocalDateTime value = LocalDateTime.now();
		return value;
	}
	
}
