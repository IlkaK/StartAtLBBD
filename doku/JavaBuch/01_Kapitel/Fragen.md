1. Was ist der Unterschied zwischen JRE (Java Runtime Environment) und JDK (Java Development Kit)

`JRE ist die virtuelle Maschine auf der Java läuft. Es ist ein Plugin. JDK ist das Kit mit allen Features, inklusive JRE, die Tools um Programme zu programmieren und Kompiler.`

2. Auf welchen Betriebssystemen kann Java entwickelt werden? (Windows, MacOS oder Linux)

`Auf allen.`

3. Welche gängigen Entwicklungsumgebungen (Integrated Development Environment kurz IDE) kennst Du? Falls Du eine verwendest, welche? Und warum gefällt sie Dir?

`Ich beschäftige mich mit Eclipse. Es ist die einzige Entwicklungsumgebung die ich bis jetzt kennengelernt habe.`

4. Wofür sind die .class-Files?

`Ist ein File das Java Bytecode beinhaltet. Werden generiert nachdem ein .java file kompiliert wurde und kann von JVM ausgeführt werden.`

5. Was macht die Java Virtual Machine (JVM)?

`Sie erlaubt es dem Computer Java Programme durchzuführen.`

6. Unter https://www.rheinwerk-verlag.de/java_4877/ unter dem Menüpunkt «Materialien» kann man die Aufgaben und Lösungen zum Buch herunterladen (978-3-8362-6958-2.zip (2,1 MB)).

Dort findet sich unter intellij/kap01-helloworld/src die Klasse «HelloWorld.java»
```
public class HelloWorld {
   public static void main(String[] args) {
      System.out.println("Hello World!");
      var s = "Hello Java 11!";
      System.out.println(s);
  }
}
```
Was macht die Klasse, wenn die Methode main ausgeführt wird? Was bedeuten die Stichworte «public» und «static»?

`Sie gibt Hallo Java 11! aus.
static bedeutet es ist von allen Klassen aus aufrufbar, ohne das ein Objekt des Klasse instanziert werden muss. Bei public muss ein Objekt der Klasse instanziert werden um daruaf zugreifen zu können.`

7. Was sind Klassen, Methoden und Objekte? Welche Beziehung haben die drei Sachen zueinander?

`Klassen: Aus Klassen können Objekte erzeugt werden. Sie sind die Vorlage für ein Objekt
Methoden: Bestimmen das Verhalten von Objekten. Sie arbeiten mit Daten(Variablen) von Objekten.
Objekte: SInd die Instanzen von Klassen. Werden erzeugt indem ein Konstruktor der Klasse aufgerufen wird.`
