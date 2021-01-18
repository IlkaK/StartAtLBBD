# Streams #

Ein paar generelle Informationen:

- Streams gibt es erst seit Java 8 (2014)

- ["Simply put, streams are wrappers around a data source, allowing us to operate with that data source and making bulk processing convenient and fast."](https://stackify.com/streams-guide-java-8/)

- ein Stream ist ein Umhang um eine Datenquelle, die es einfacher macht, Massenoperationen darauf auszuführen

- ein Stream speichert keine Daten und verändert nicht die darunterliegende Datenquelle

- man kann einen Stream aus einem Array, einer Liste (z.B. ArrayList), durch das Zusammenfügen einzelner Objekte oder mit dem Stream.Builder erzeugen


Stream Operationen:


|  Art der Operation      |  Methode                              | Beschreibung                   | Rückgabewert
| :---------------------- |:--------------------------------------| -------------------------------| -----------------------------|
| Terminierende Operation | forEach()                             | iteriert über alle Elemente    | keinen |       
|                         | count()                               | zählt alle Elemente            | Zahl | 
|                         | min()/ max()                          | sucht das minimale oder maximale Element basierend auf dem Comparator heraus | eines der Elemente |  
|                         | allMatch()                            | prüft, ob ein Boolescher Ausdruck für alle Elemente im Stream gilt       | true oder false |
|                         | anyMatch()                            | prüft, ob ein Boolescher Ausdruck für eines der Elemente im Stream gilt  | true oder false |
|                         | noneMatch()                           | prüft, ob ein Boolescher Ausdruck für keines der Elemente im Stream gilt | true oder false |
|                         | findFirst()                           | sucht das erste Element heraus | eines der Elemente | eines der Elemente | 
|                         | collect()                             | wandelt den Stream in eine Collection um            | eine Collection  | 
|                         | toArray()                             | wandelt den Stream in einen Array um                | ein Array vom Typ der Elemente | 

| Intermediate Operation  | map() / mapToInt()                    | wendet eine Funktion auf jedes Element im Stream an | ein neuer Stream vom Typ des Funktionsrückgabetyps | 
| (auf bestehende Streams)| filter()                              | wendet einen Filter auf jedes Element im Stream an  | Stream vom selben Elemententyp  | 
|                         | skip()                                | die gegebene Anzahl an ersten Elementen wird gelöscht      | Stream vom selben Elemententyp  | 
|                         | limit()                               | beschränkt die Anzahl der Elemente auf die gegebene Anzahl | Stream vom selben Elemententyp  | 
|                         | sorted()                              | anhand des angegebenen Comporatators werden alle Elemente sortiert  | Stream vom selben Elemententyp | 
|                         | peek()                                | führt eine Methode (void) auf die Elemente im Stream aus | Stream vom selben Elemententyp | 
|                         | distinct()                            | filtert doppelte Elemente aus dem Stream raus | Stream vom selben Elemententyp | 
|                         | flatMap()                             | eine Liste in einem Stream wird flachgedrückt auf ihre Elemente | Stream vom Elementtyp der Liste  | 

| Intermediate Operation  | iterate()                             | erzeugt anhand einer Funktion und eines Startelements einen Stream | Stream vom Elementtyp des Funktionsrückgabetyps | 
| (ohne bestehende        | Stream.of()                           | erzeugt neuen Stream aus einem Array | Stream vom Elementtyp des Arrays  | 
| Streams basieren)       | stream()                              | erzeugt einen Strean aus einer Liste | Stream vom Elementtyp der Liste   | 


## Terminierende Operationen ##
- nach dem Ausführen der Operation, ist diese abgeschlossen("it is a terminal operation, which means that, after the operation is performed, the stream pipeline is considered consumed, and can no longer be used")

- collect(): damit holen wir aus dem Stream die Elemente wieder raus und fügen sie wieder einer Collection hinzu, mit der wir weiterarbeiten können (z.B. List oder Map).
Das ist eine typische Operation, nachdem auf den Elementen (z.B. via der Operation map) eine Funktion ausgeführt wurde.

```
...
Stream<OrderDbo> streamOfOrderDbos = streamOfOrderIds.map(orderRepository::findById);
List<OrderDbo> listOfOrderDbos = streamOfOrderDbos.collect(Collectors.toList());
```

- toArray(): wandelt den Stream in einen Array um

```
...
Stream<OrderDbo> streamOfOrderDbos = streamOfOrderIds.map(orderRepository::findById);
OrderDb[] arrayOfOrderDbos = streamOfOrderDbos.toArray();
```

- findFirst(): gibt ein `Optional` für den ersten Eintrag im Stream zurück, das `Optional` kann leer sein:

```
...
Stream<OrderDbo> streamOfOrderDbos = streamOfOrderIds.map(orderRepository::findById);
OrderDbo firstOrderDbo = streamOfOrderDbos.findFirst().orElse(null);
```

- allMatch(), anyMatch(), noneMatch(): benötigt ein Predicte (= Booleschen Ausdruck) und überprüft anhand dessen die Elemente im Stream, bei anyMatch wird abgebrochen, sobald eines der Elemente auf das Predicate passt, also der boolesche Ausdruck wahr wird


## Intermediate Operations ##
- eine intermediate Operation gibt wieder einen Stream zurück, womit man wieder weitere intermediate Operationen ausführen kann ("Intermediate operations such as filter() return a new stream on which further processing can be done.")

- map(): erzeugt einen neuen Stream
Auf jedes Element im Stream wird eine Funktion ausgeführt, die wieder ein Element zurückgibt, welches in dem neuen Stream gespeichert wird.
Der neue Stream kann einen anderen Typ haben als der alte Stream. Welcher Typ entscheidet der Rückgabetyp der Funktion. Ein Beispiel ist Folgendes:

```
Integer[] orderIds = { 1, 2, 3 };
Stream<Integer> streamOfOrderIds = Stream.of(orderIds);
Stream<OrderDbo> streamOfOrderDbos = streamOfOrderIds.map(orderRepository::findById);
```

- filter(): erzeugt einen neuen Stream mit den Elementen, die durch den Filter passen 

```
Stream<OrderDbo> streamOfNotNullOrderDbos = streamOfOrderIds.map(orderRepository::findById).filter(o -> o != null);
```

Auch mehrere Filter hintereinander sind möglich.

```
Stream<OrderDbo> stremOfNotNullAndHighIdOrderDbos = streamOfOrderIds.map(orderRepository::findById).filter(o -> o != null).filter(o -> o.orderId > 2);
```

- iterate(): auf einem Startwert (seed) wird eine sich immer wieder wiederholende Funktion ausgeführt und das Resultat wieder als Start genommen (Rekursion)
Das Verhalten ist unendlich, wenn nicht abgebrochen oder abgekürzt, mit z.B. limit()

```
Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);
```

