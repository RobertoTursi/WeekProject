package Project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class OggettoLeggibile {
	
	String codiceISBN = dropISBN();
	String titolo;
	int annoPubblicazione;
	int numeroPagine;
	static int counter = -1;

	public OggettoLeggibile(String titolo, int annoPubblicazione, int numeroPagine) {
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
		
	}

	public String dropISBN() {
		counter++;
		return  "ABC" + counter;
		
		
	}
	
	
}


