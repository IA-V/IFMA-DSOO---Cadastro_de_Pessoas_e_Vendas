package validação;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;

public class ValidaData {
	public static int calculaIdade(String dataNasc) {
		int idade = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataNascimento = sdf.parse(dataNasc);
			Calendar dtNascimento = Calendar.getInstance();  
			dtNascimento.setTime(dataNascimento); 
			Calendar hoje = Calendar.getInstance();  
			idade = hoje.get(Calendar.YEAR) - dtNascimento.get(Calendar.YEAR); 
			if (hoje.get(Calendar.MONTH) < dtNascimento.get(Calendar.MONTH)) {
				idade--;  
			}else{ 
				if (hoje.get(Calendar.MONTH) == dtNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dtNascimento.get(Calendar.DAY_OF_MONTH)) {
					idade--; 
			    }
			}
		}catch(ParseException p) {
			System.out.println(p.getMessage());
		}
	    return idade;
	}
}
