# Streams #

Ein paar generelle Informationen:

- Streams gibt es erst seit Java 8 (2014)

- ["Simply put, streams are wrappers around a data source, allowing us to operate with that data source and making bulk processing convenient and fast."](https://stackify.com/streams-guide-java-8/)

- ein Stream ist ein Umhang um eine Datenquelle, die es einfacher macht, Massenoperationen darauf auszuführen

- ein Stream speichert keine Daten und verändert nicht die darunterliegende Datenquelle

- man kann einen Stream aus einem Array, einer Liste (z.B. ArrayList), durch das Zusammenfügen einzelner Objekte oder mit dem Stream.Builder erzeugen


Stream Operationen:

- forEach(): ruft jedes Element einmal auf, danach ist die Operation abgeschlossen ("it is a terminal operation, which means that, after the operation is performed, the stream pipeline is considered consumed, and can no longer be used")

- map(): auf jedes Element im Stream wird eine Funktion ausgeführt, die wieder ein Element zurückgibt, welches in einem neuen Stream gespeichert wird. 
Die Funktion kann auch einen anderen Typ zurückgeben, so dass ein neuer Stream eines anderen Typs entsteht. Ein Beispiel ist folgendes:

```
Integer[] orderIds = { 1, 2, 3 };
Stream<Integer> streamOfOrderIds = Stream.of(orderIds);
Stream<OrderDbo> streamOfOrderDbos = streamOfOrderIds.map(orderRepository::findById);
```

- collect(): damit holen wir aus dem Stream die Elemente wieder raus und fügen sie wieder einer Collection hinzu, mit der wir weiterarbeiten können (z.B. List oder Map).
Das ist eine typische Operation, nachdem auf den Elementen (z.B. via der Operation map) eine Funktion ausgeführt wurde.

```
...
Stream<OrderDbo> streamOfOrderDbos = streamOfOrderIds.map(orderRepository::findById);
List<OrderDbo> listOfOrderDbos = streamOfOrderDbos.collect(Collectors.toList());
```