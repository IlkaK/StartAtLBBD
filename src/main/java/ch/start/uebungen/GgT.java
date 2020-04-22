package ch.start.uebungen;

import java.util.Scanner;

public class GgT {
	
	static public final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int ersteZahl; //erste Zahl die eingelesen wird
		int zweiteZahl; //zweite Zahl die eingelesen wird
		int kleineZahl; //kleinere der beiden Zahlen
		int grosseZahl; //grössere der beiden Zahlen
		int resultat = 0;
		
		System.out.println("------ Start der Berechnung des GgTs -------");		
		
//		System.out.println("Welche Argumente haben wir: ");
//		for(int i=0; i<args.length; i++) {
//			System.out.println(i+": "+args[i]);
//		}
				
		if(args.length>0) {
			GgTMethod methodToUse = GgTMethod.valueOf(args[0]); //klassisch [0], modern [1]
			System.out.println("Verwende: " + methodToUse);
			
			System.out.println("\nUm den GgT auszurechnen, gib zwei Zahlen an.");

//			Einlesen erste Zahl
			System.out.println("\nErste Zahl: ");
			ersteZahl = Integer.parseInt(scanner.nextLine());
			
//			Einlesen zweite Zahl, so lange bis zweite Zahl nicht gleich erste Zahl		
			do {
				System.out.println("\nZweite Zahl: ");
				zweiteZahl = Integer.parseInt(scanner.nextLine());
				if (ersteZahl == zweiteZahl) {
					System.out.println("\nDie Zahlen sind identisch. Probiere es erneut.");				
				}
				
			}while (zweiteZahl == ersteZahl);
			
//			Herausfinden welche Zahl ist kleiner/grösse
			if (ersteZahl > zweiteZahl) {
				grosseZahl = ersteZahl;
				kleineZahl = zweiteZahl;
			}else {
				grosseZahl = zweiteZahl;
				kleineZahl = ersteZahl;
			}
			
//			Überprüfen, welche methode verwendet wird
			switch(methodToUse) {
			  case KLASSISCHER_EUKLIDES:
				//berechnet den ggt
				while(grosseZahl > kleineZahl) {
					resultat = grosseZahl - kleineZahl;
					grosseZahl = resultat;
				}
			    break;
			  case MODERNER_EUKLIDES:
				while(grosseZahl > kleineZahl) {
					resultat = grosseZahl % kleineZahl;
					grosseZahl = resultat;
				}
			    break;
			}
			
//			zweite Möglichkeit
//			if(methodToUse == GgTMethod.KLASSISCHER_EUKLIDES){				
//			} 
			
			System.out.println("\nDer grösste gemeinsame Teiler lautet: " + resultat);
			
		}
		
		
		System.out.println("------ Ende der Berechnung des GgTs -------");
	}

}
