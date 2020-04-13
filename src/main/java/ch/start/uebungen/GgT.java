package main.java.ch.start.uebungen;

public class GgT {

	public static void main(String[] args) {
		System.out.println("------ Start der Berechnung des GgTs -------");
		
//		System.out.println("Welche Argumente haben wir: ");
//		for(int i=0; i<args.length; i++) {
//			System.out.println(i+": "+args[i]);
//		}
		
		if(args.length>0) {
			GgTMethod methodToUse = GgTMethod.valueOf(args[0]);
			System.out.println("Verwende: " + methodToUse);
			
		}
		

		
		System.out.println("------ Ende der Berechnung des GgTs -------");
	}

}
