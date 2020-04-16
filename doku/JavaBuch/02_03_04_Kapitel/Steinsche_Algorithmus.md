# Der steinsche Algorithmus zur Berechnung des grössten gemeinsamen Teilers #

Ich versuche mal den steinschen Algorithmus zu erklären. Meine Grundlage ist dafür die Wikipedia Seite zum [steinschen Algorithmus](https://de.wikipedia.org/wiki/Steinscher_Algorithmus). Auch der Link zur [Hochschule Flensburg](https://www.inf.hs-flensburg.de/lang/krypto/algo/ggt-stein-algorithmus.htm) hat mir geholfen. Nach Danach der Erklärung und den zwei Beispielen gehe ich noch auf die Erklärungen von [GeeksForGeeks](https://www.geeksforgeeks.org/steins-algorithm-for-finding-gcd) ein.

Der Steinsche Algorithmus wird auch binärer euklidischer Algorithmus genannt. Binär deutet daraufhin, dass die Zahl 2 eine wichtige Rolle spielt. Am Anfang wird viel durch 2 geteilt, später wird wieder mit 2 multipliziert. Das kann man vielleicht im Hinterkopf behalten.

Bei den beiden euklidischen Algorithmen ist jede Methodenabfolge gleich und die beiden Zahlen werden immer nach demselben Muster behandelt.

Beim steinschen Algorithmus wird nicht jede Zahl gleich behandelt. Dadurch wird er komplexer. Der grosse Unterschied besteht darin, ungerade und gerade Zahlen anders zu behandeln. Bei mir ist die erste Zahl a, die zweite Zahl b. Was passiert jetzt im Algorithmus:

1. Fall: a ist gerade und b ist gerade => Dann werden beide Zahlen durch 2 geteilt, damit gibt es ein neues a und ein neues b.
2. Fall: a ist gerade und b ist ungerade => Dann wird a durch 2 geteilt, damit gibt es ein neues a, b bleibt, wie es ist.
3. Fall: a ist ungerade und b ist ungerade => Dann wird b von a abgezogen (a-b), damit gibt es eine gerade Zahl als Ergebnis. Die Zahl wird wieder durch 2 geteilt wird. Das Ergebnis davon ist wieder das neue a, b bleibt bestehen.

Im 3. Fall muss beachtet werden, dass jeweils die kleinere Zahl von der grösseren abgezogen werden muss. D.h. a und b werden vertauscht, sobald a nicht mehr grösser ist als b.

Für das Endergebnis wird gezählt, wie oft der 1. Zahl eingetreten ist. Das ist unser k. Jetzt zu den Beispielen:

## Beispiel mit 42 und 36 ##

1. Schritt: 1. Fall tritt auf, denn 42 ist gerade und 36 ist gerade => 42:2=21 (neues a), 36:2=18 (neues b)

2. Schritt: 2. Fall tritt auf, denn 21 ist nicht gerade, 18 ist gerade => 21 bleibt bestehen (neues a), 18:2=9 (neues b)

3. Schritt: 3. Fall tritt auf, denn 21 ist ungerade, 9 ist ungerade => 21-9=12, 12:2=6 (neues a), 9 bleibt bestehen (neues b)

4. Schritt: 2. Fall tritt auf, denn 6 ist gerade, 9 ist ungerade => 6:2=3 (neues a), 9 bleibt bestehen (neues b)

5. Schritt: 3. Fall tritt auf, denn 3 ist ungerade, 9 ist ungerade => da 3 kleiner ist als 9, werden 3 und 9 vertauscht
Damit wird gerechnet 9-3=6 und danach 6:2=3 (neues a), die 3 von vorher (neues a aus 4. Schritt) bleibt bestehen und wird neues b

6. Schritt: 3. Fall tritt auf, beide 3 sind ungerade => 3-3=0 => endlich fertig

Jetzt müssen wir die 3 noch weiterbearbeiten.

Laut steinschem Algorithmus, muss das Ergebnis noch mit 2 hoch k multipliziert werden. 
Das k ergibt sich dabei, wie oft durch den Fall 1 gelaufen wurde. Bei uns ist das 1 Mal.
Also müssen wir 2 hoch 1 berechnen = 2.
2 * 3 ergibt 6. Der grösste gemeinsame Teiler ist also 6 von 42 und 36.


## Nächstes Beispiel mit 40 und 13 ## 

1. Schritt: 2. Fall tritt auf, denn 40 ist gerade, 13 ist ungerade => 40:2=20 (neues a), 13 bleibt bestehen (neues b)

2. Schritt: 2. Fall tritt auf, denn 20 ist gerade, 13 ist ungerade => 20:2=10 (neues a), 13 bleibt bestehen (neues b)

3. Schritt: 2. Fall tritt auf, denn 10 ist gerade, 13 ist ungerade => 10:2=5 (neues a), 13 bleibt bestehen (neues b)

4. Schritt: 3. Fall tritt auf, denn 5 ist ungerade, 13 ist ungerade => a und b werden vertauscht, 13-5=8, 8:2=4 (neues a), 5 (neues b)

5. Schritt: 2. Fall tritt auf, denn 4 ist gerade, 5 ist ungerade => 4:2=2 (neues a), 5 bleibt bestehen (neues b)

6. Schritt: 2. Fall tritt auf, denn 2 ist gerade, 5 ist ungerade => 2:2=1 (neues a), 5 bleibt bestehen (neues b)

7. Schritt: 3. Fall tritt auf, denn 1 ist ungerade, 5 ist ungerade => a und b werden vertauscht, 5-1=4, 4:2=2 (neues a), 1 (neues b)

8. Schritt: 3. Fall tritt auf, denn 2 ist gerade, 1 ist ungerade => 2-1=1, keine Division mehr möglich

Am Ende bleibt also dieses Mal die 1. Da wir niemals den 1. Fall hatten, wird auch nicht multipliziert. 1 ist also der grösste gemeinsame Teiler von 40 und 13.

Du kannst es auch gerne auf einem Blatt Papier selber durchspielen.

## GeeksForGeeks ##
 
In der Beschreibung des steinschen Algorithmus von GeeksForGeeks sind unsere Fälle 1 bis 3 bei ihnen die Steps 3 bis 5. |a-b| bedeutet dabei, die Differenz zwischen a und b als Betrag, also am Ende ein positives Ergebnis. Sobald a kleiner ist als b, wird a von b abgezogen und nicht mehr umgekehrt, so wie wir es auch gemacht haben.

In der iterativen Java-Version, die auf GeeksForGeeks gepostet wird, werden verschiedene Schritte zusammengefasst.
Am Anfang wird ausgeschlossen, dass mit 0 gearbeitet wird. Schön und gut.

In der ersten for-Schleife, wird k direkt ausgerechnet, indem die Bits von a und b geschiftet werden.

Dabei bedeuten die Operanden folgendes:

`a|b` bedeutet dabei: bitweises "oder", produziert eine 1, sobald einer seiner Operanden eine 1 ist

`&` 	bitweises "und", wenn beide Operanden 1 sind, wird ebenfalls eine 1 produziert, ansonsten eine 0

`>>`	Arithmetischer Rechtsshift: alle Bits des Operanden werden um eine Stelle nach rechts verschoben, stand ganz links eine 1 wird mit einer 1 aufgefüllt, bei 0 wird mit 0 aufgefüllt

1101 >> 1 = 1110

1111 >> 1 = 1111

0111 >> 1 = 1011

0001 >> 1 = 1000

Jede 1 oder 0 wird um eins nach rechts verschoben, ist am Ende eine 1, kommt an erster Stelle wieder eine 1, ist am Ende eine 0 kommt am Ende wieder eine 0.

`=` direkt hinter `>>` führt dazu, dass das neue Ergebnis a und b gleich wieder zugewiesen wird.

Die Infos habe ich wieder von [Wikipedia](https://de.wikibooks.org/wiki/Java_Standard:_Operatoren), sie sind mir auch nicht so geläufig.

Danach kommen die Fälle 1, 2 und 3, um die kleinste Zahl herauszufinden - ohne dabei noch k herausfinden zu müssen.

Das Programm hier möchte den Vorteil nutzen, warum eigentlich der Steinsche Algorithmus entstanden ist, nämlich möglichst schnell mit binären Berechnungen den grössten gemeinsamen Teiler herauszufinden. Computer sind darauf spezialisiert, einfach Bits hin- und herzuschieben und machen das unglaublich schnell. Auch der Switch von 0 auf 1 oder umgekehrt geht sehr viel schneller, als aufwändige Divisionen mit Rest zu berechnen. 

