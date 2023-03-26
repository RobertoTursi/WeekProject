package Project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

public class CatalogoBibliotecario {
	static Scanner s = new Scanner(System.in);
	static List<OggettoLeggibile> catalogo = new ArrayList<OggettoLeggibile>();
	
	public static void main(String[] args) {
		
		// - IMPOSTAZIONE
		
		Libri l1 = new Libri("1984", "George Orwell", "Romanzo Distopico", 1949, 320);
		Libri l2 = new Libri("Arancia Meccanica", "Steven Burgess", "Romanzo Fantapolitico", 1962, 240);
		Libri l3 = new Libri("Psico Cibernetica", "Maxwell Maltz", "Sviluppo Personale", 1960, 252);
		
		Riviste r1 = new Riviste("Le Scienze", Periodicità.Mensile, 1968, 100);
		Riviste r2 = new Riviste("Focus", Periodicità.Mensile, 1992, 321);
		
		
		catalogo.add(l1);
		catalogo.add(l2);
		catalogo.add(l3);
		catalogo.add(r1);
		catalogo.add(r2);
		
		
//		aggiungiElemento(catalogo, creaOggettoLeggibile());
//		stampaArray(catalogo); 
//		System.out.println();
//		rimuoviElementoIsbn(catalogo, "ABC3");
//		stampaArray(catalogo); 
//		
//		ricercaIsbn(catalogo, "ABC1");
		
//		ricercaAnnoPubblicazione(catalogo, 1992);
		
		ricercaAutore(catalogo, "George Orwell");
	}

	

	
		// - METODI
	
		
		public static void writeFile(List catalogo) throws IOException {
			File listaLibri = new File("Catalogo.txt");
			FileWriter myFw = new FileWriter(listaLibri);
			PrintWriter myPw = new PrintWriter(myFw);
			myPw.print(catalogo);
			myPw.close();
		}
		
		public static void readFile(List catalogo) throws IOException {
			File file1 = new File("Catalogo.txt");
			String readString = FileUtils.readFileToString(file1, "UTF-8");
			System.out.println(readString);
		}
	
		public static void ricercaAutore(List<OggettoLeggibile> lista, String autore) {
			lista.stream().filter(obj -> (obj instanceof Libri)).filter(obj -> ((Libri) obj).getAutore().equals(autore)).forEach(obj -> System.out.println(obj));
			
			
			//Senza stream
//			for(int i = 0; i < lista.size(); i++) {
//				if(lista.get(i) instanceof Libri) {
//					if(((Libri) lista.get(i)).getAutore().equals(autore)) {
//						System.out.println(lista.get(i));
//					}
//				}
//			}
			
		}
		
		
		
		
		
		
		public static void ricercaAnnoPubblicazione(List<OggettoLeggibile> lista, int anno) {
			lista.stream().filter(obj -> (obj.getAnnoPubblicazione() == anno)).forEach(elem -> System.out.println(elem));
		}
	
		public static void ricercaIsbn(List<OggettoLeggibile> lista, String id) {
			List<OggettoLeggibile> elem = lista.stream().filter(obj -> (obj.getCodiceISBN().equals(id))).collect(Collectors.toList());
			System.out.println(elem);
		}
		
	
		public static void rimuoviElementoIsbn(List<OggettoLeggibile> lista, String id) {
			//Senza Stream:
			
//			for(int i = 0; i < lista.size(); i++) {
//				if(lista.get(i).getCodiceISBN().equals(id)) {
//					lista.remove(lista.get(i));
//				}
//			}
			
			//Con Stream:
			
			catalogo = lista.stream().filter(obj -> (!obj.getCodiceISBN().equals(id))).collect(Collectors.toList());
			
		}
	
		public static void aggiungiElemento(List lista, OggettoLeggibile elem) {
			lista.add(elem);
		}
		
		public static OggettoLeggibile creaOggettoLeggibile() {
			OggettoLeggibile oggettoLeggibile = null;
			System.out.println("Specifica che tipo di oggetto leggibile che vuoi aggiungere ('libro' o 'rivista')");
			String tipologia = s.nextLine();
			if(tipologia.equals("libro")) {
				System.out.println("Inserisci il titolo");
				String titolo = s.nextLine();
				System.out.println("Inserisci l'autore");
				String autore = s.nextLine();
				System.out.println("Inserisci il genere");
				String genere = s.nextLine();
				System.out.println("Inserisci l'anno d'uscita");
				int anno = s.nextInt();
				System.out.println("Inserisci il numero di pagine");
				int pagine = s.nextInt();
				
				oggettoLeggibile = new Libri(titolo, autore, genere, anno, pagine);
				
			} else if (tipologia.equals("rivista")) {
				System.out.println("Inserisci il titolo");
				String titolo = s.nextLine();
				System.out.println("Inserisci la periodicità ('settimanale', 'mensile', o 'semestrale");
				String p = s.nextLine();
				System.out.println("Inserisci l'anno d'uscita");
				int anno = s.nextInt();
				System.out.println("Inserisci il numero di pagine");
				int pagine = s.nextInt();
				
				Periodicità periodicità = null;
				if(p == "settimanale") {
					periodicità = Periodicità.Settimanale;
				}else if(p == "mansile") {
					periodicità = Periodicità.Mensile;
				}else if(p == "semestrale") {
					periodicità = Periodicità.Semestrale;
				}
				
				oggettoLeggibile = new Riviste(titolo, periodicità, anno, pagine);
				
			}
			return oggettoLeggibile;
		}
		
		public static void stampaArray(List arr) {
			for(int i = 0; i < arr.size(); i++) {
				System.out.println(arr.get(i));
			}
		}

}
