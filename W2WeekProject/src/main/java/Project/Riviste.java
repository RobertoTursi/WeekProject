package Project;


public class Riviste extends OggettoLeggibile	{
	Periodicità periodicità;
	
	public Riviste( String titolo, Periodicità periodicità, int annoPubblicazione, int numeroPagine) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.periodicità = periodicità;
	}
}
