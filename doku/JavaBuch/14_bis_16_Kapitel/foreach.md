# forEach() #

## Collection.stream.forEach () vs. Collection.forEach() ##

Auf einer Collection wird ein Iterator definiert, der die Reihenfolge in Loops vorgibt. Wird forEach() direkt auf der Collection angewandt, dann wird dieser Iterator angezogen. [JavaDoc zur Collection](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html)
Ein Beispiel einer Implementation des Collection-Interfaces ist die [ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) mit dem [ListIterator](https://docs.oracle.com/javase/8/docs/api/java/util/ListIterator.html).

Die Reihenfolge des Loops bei einem Stream ist hingegen undefiniert.

[Collection.forEach() uses the collection's iterator (if one is specified). That means that the processing order of the items is defined. In contrast, the processing order of Collection.stream().forEach() is undefined.](https://www.baeldung.com/java-collection-stream-foreach#:~:text=Custom%20Iterators&text=The%20reason%20for%20the%20different,the%20list%2C%20ignoring%20the%20iterator.)

In dem oben genannten Beispiel von Baeldung wird eine ReverseList implementiert, die von der ArrayList ableitet, aber den Iterator überschreibt, so dass er die Elemente in umgekehrter Reihenfolge zurückgibt. In seinem Beispiel zeigt er dann, dass bei dem forEach direkt auf der Collection der ReverseIterator angezogen wird, beim forEach auf dem Stream jedoch nicht: ["while stream().forEach() simply takes elements one by one from the list, ignoring the iterator."](https://www.baeldung.com/java-collection-stream-foreach#:~:text=Custom%20Iterators&text=The%20reason%20for%20the%20different,the%20list%2C%20ignoring%20the%20iterator.)

Sobald forEach mit Streams verwendet wird, verändert sich die Performance (bei grossen Mengen, die häufig durchloopt werden müssen). [Tests auf Stackoverflow](https://stackoverflow.com/questions/23218874/what-is-difference-between-collection-stream-foreach-and-collection-foreach#:~:text=forEach%20is%20iterating%20over%20a%20synchronized%20collection.&text=forEach%20takes%20the%20collection's%20lock,prevailing%20rule%20of%20non%2Dinterference.)
