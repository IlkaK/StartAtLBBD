package ch.start.uebungen;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GgT {
	
	static public final Scanner scanner = new Scanner(System.in);
	static public final Logger logger = LogManager.getLogger(GgT.class);
	
	//Methode um int eingebe zu �berpr�fen, Input darf nicht negativ oder ein String sein.
	public int eingebenInt() {
		try {
			int zahl;
		    do { //Loop bis Input korrekt ist
		    	System.out.println("Nur positive Zahlen sind erlaubt.");
			    while (!scanner.hasNextInt()){ //�berpr�ft Datentyp
			    	System.out.println("\nDas ist keine Zahl. Versuche es erneut.");
			    	logger.error("Input ist keine Zahl");
			    	scanner.next();
			    	}
			    zahl = scanner.nextInt(); //insert Data
			    if (zahl <= 0) {
			    	logger.error("Input ist eine negative Zahl: " + zahl);
			    }
		    } while (zahl <= 0); //�berpr�ft ob Zahl negativ ist
			return zahl;
		}catch(Exception e) {
	    	logger.error("Es ist ein Fehler beim Input aufgetreten.");
		}
		return 0;
	}
	
	int steinischerAlg(int grosseZahl, int kleineZahl) {
	    if (grosseZahl == 0) {
	        return kleineZahl;
	    } 
	    if (kleineZahl == 0) {
	        return grosseZahl;
	    }
	 
	    int n;
	    for (n = 0; ((grosseZahl | kleineZahl) & 1) == 0; n++) {
	        grosseZahl >>= 1;
	        kleineZahl >>= 1;
	    }
	 
	    while ((grosseZahl & 1) == 0) {
	        grosseZahl >>= 1;
	    }
	 
	    do {
	        while ((kleineZahl & 1) == 0) {
	            kleineZahl >>= 1;
	        }
	 
	        if (grosseZahl > kleineZahl) {
	            int temp = grosseZahl;
	            grosseZahl = kleineZahl;
	            kleineZahl = temp;
	        }
	        kleineZahl = (kleineZahl - grosseZahl);
	    } while (kleineZahl != 0);
	    return grosseZahl << n;
	}
	

	public static void main(String[] args) {
		GgT ggt = new GgT();
		int ersteZahl; //erste Zahl die eingelesen wird
		int zweiteZahl; //zweite Zahl die eingelesen wird
		int kleineZahl; //kleinere der beiden Zahlen
		int grosseZahl; //gr�ssere der beiden Zahlen
		int resultat = 0;

		System.out.println("------ Start der Berechnung des GgTs -------");		
		
//		System.out.println("Welche Argumente haben wir: ");
//		for(int i=0; i<args.length; i++) {
//			System.out.println(i+": "+args[i]);
//		}
				
		if(args.length>0) {
			GgTMethod methodToUse = GgTMethod.valueOf(args[2]); //klassisch [0], modern [1], STEINSCH_ALGORITHMUS [2]
			System.out.println("Verwende: " + methodToUse);
			
			System.out.println("\nUm den GgT auszurechnen, gib zwei Zahlen an.");

//			Einlesen erste Zahl
			System.out.println("\nErste Zahl: ");
			ersteZahl = ggt.eingebenInt();
		    logger.info("Eingegebene erste Zahl: " + ersteZahl);
			
//			Einlesen zweite Zahl, so lange bis zweite Zahl nicht gleich erste Zahl		
			do {
				System.out.println("\nZweite Zahl: ");
				zweiteZahl = ggt.eingebenInt();
				if (ersteZahl == zweiteZahl) {
					System.out.println("\nDie Zahlen sind identisch. Probiere es erneut.");	
				    logger.warn("Zahl identisch mit erster Zahl: " + zweiteZahl);
				}
				
			}while (zweiteZahl == ersteZahl);
		    logger.info("Eingegebene zweite Zahl: " + zweiteZahl);
			
//			Herausfinden welche Zahl ist kleiner/gr�sse
			if (ersteZahl > zweiteZahl) {
				grosseZahl = ersteZahl;
				kleineZahl = zweiteZahl;
			}else {
				grosseZahl = zweiteZahl;
				kleineZahl = ersteZahl;
			}
			logger.info("kleine Zahl: " + kleineZahl + " - grosse Zahl: " + grosseZahl);
			
//			�berpr�fen, welche methode verwendet wird
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
			  case STEINSCH_ALGORITHMUS:
				ggt.steinischerAlg(grosseZahl, kleineZahl);
			}
			
			System.out.println("\nDer gr�sste gemeinsame Teiler lautet: " + resultat);
			
		}
		
		
		System.out.println("------ Ende der Berechnung des GgTs -------");
	}

}
