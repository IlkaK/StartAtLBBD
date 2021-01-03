# Streams #

Ein paar generelle Informationen:

- Streams gibt es erst seit Java 8 (2014)

- ["Simply put, streams are wrappers around a data source, allowing us to operate with that data source and making bulk processing convenient and fast."](https://stackify.com/streams-guide-java-8/)

- ein Stream ist ein Umhang um eine Datenquelle, die es einfacher macht, Massenoperationen darauf auszuführen

- ein Stream speichert keine Daten und verändert nicht die darunterliegende Datenquelle

- man kann einen Stream aus einem Array, einer Liste (z.B. ArrayList), durch das Zusammenfügen einzelner Objekte oder mit dem Stream.Builder erzeugen


Stream Operationen:

- forEach() => gibt es auch in Iterable und Map