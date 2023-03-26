package Project;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Libri extends OggettoLeggibile{
	
	String autore;
	String genere;
	
	public Libri( String titolo, String autore, String genere, int annoPubblicazione, int numeroPagine) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}
}
