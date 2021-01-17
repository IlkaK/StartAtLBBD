# Streams #

Ein paar generelle Informationen:

- Streams gibt es erst seit Java 8 (2014)

- ["Simply put, streams are wrappers around a data source, allowing us to operate with that data source and making bulk processing convenient and fast."](https://stackify.com/streams-guide-java-8/)

- ein Stream ist ein Umhang um eine Datenquelle, die es einfacher macht, Massenoperationen darauf auszuführen

- ein Stream speichert keine Daten und verändert nicht die darunterliegende Datenquelle

- man kann einen Stream aus einem Array, einer Liste (z.B. ArrayList), durch das Zusammenfügen einzelner Objekte oder mit dem Stream.Builder erzeugen


Stream Operationen:


|                         |                                       |                              | 
| :---------------------- |:--------------------------------------| -----------------------------| 
| Terminierende Operation | forEach()                             | iteriert über alle Elemente  |         
|                         | count()                               | liefert eine Zahl zurück     |   
|                         | min()/ max()                          | gibt ein Element zurück      |  
|                         | allMatch() / anyMatch() / noneMatch() | gibt true/false zurück       | 
|                         | findFirst()                           | gibt ein Element zurück      | 
| Erzeugt neuen Stream    | map() / mapToInt()                    |  |
|                         | filter()                              |  |   
|                         | iterate()                             |  |  
|                         | skip()                                |  |  
|                         | limit()                               |  |  
|                         | sorted()                              |  |  
|                         | peek()                                |  |  
|                         | distinct()                            |  |
|                         | flatMap()                             |  |
| Umwandlung              | collect()                             |  |   
|                         | toArray()                             |  |     


## Terminierende Operationen ##
- forEach(): ruft jedes Element einmal auf, danach ist die Operation abgeschlossen ("it is a terminal operation, which means that, after the operation is performed, the stream pipeline is considered consumed, and can no longer be used")

## Einen neuen Stream erzeugende Operationen ##

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

## Umwandlung zu collection, array etc. und vice versa ## 


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
``

## Ein einziges Element zurückgeben ##

- findFirst(): gibt ein `Optional` für den ersten Eintrag im Stream zurück, das `Optional` kann leer sein:
```
...
Stream<OrderDbo> streamOfOrderDbos = streamOfOrderIds.map(orderRepository::findById);
OrderDbo firstOrderDbo = streamOfOrderDbos.findFirst().orElse(null);
````
