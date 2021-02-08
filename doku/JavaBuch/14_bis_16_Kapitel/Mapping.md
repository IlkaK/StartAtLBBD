# Mapping mit MapStruct #

In den Projekten verwenden wir jeweils das Mapping mit MapStruct. Wie man MapStruct verwendet, wird auf der [Webseite von Mapstruct](https://mapstruct.org/) gut erklärt "MapStruct in 2 Minutes" bzw. "Using den Mapper". Aber wahrscheinlich ist das schon kalter Kaffee für dich. ;)

Ein typisches Problem ist, DBOs (persistence backend entites) auf DTOs zu mappen. Manuelle Bean-Mapper zu definieren ist zeitaufwändig und kann - wie bei allen manuellen Eingriffen - eher zu Fehlern führen. Deswegen hat damals Patrick das MapStruct eingeführt.
Mit MapStruct werden nur Interfaces definiert. Die MapStruct Library generiert dann die Beans zu den Interfaces automatisch. (Entlehnt der Erklärung von [Baeldung](https://www.baeldung.com/mapstruct))

Auf der MapStruct Webseite steht unter dem Punkt "What is it?": "mappings between Java bean types based on a convention over configuration approach". 
Konvention geht also vor Konfiguration. Das bedeutet, dass man nicht viel einrichten bzw. konfigurieren muss und MapStruct nach gängigen Konventionen funktioniert.
(Entlehnt von [Konvention vor Konfiguration auf Wikipedia](https://de.wikipedia.org/wiki/Konvention_vor_Konfiguration))

Danach wird es interessanter: "The generated mapping code uses plain method invocations". ["During compilation, MapStruct will generate an implementation of this interface. This implementation uses plain Java method invocations for mapping between source and target objects, i.e. no reflection or similar."](https://mapstruct.org/documentation/stable/reference/html/)

Mit "plain Java method invocation" ist gemeint, dass mit MapStruct Interfaces definiert werden, dessen Methoden dann bereits während des Kompilierens durch die generierten Beans ersetzt werden.

["When the Java virtual machine invokes a class method, it selects the method to invoke based on the type of the object reference, which is always known at compile-time. On the other hand, when the virtual machine invokes an instance method, it selects the method to invoke based on the actual class of the object, which may only be known at run time."](https://www.artima.com/underthehood/invocation.html) Wir haben es bei MapStruct mit "class methods" zu tun, nicht mit "instance methods". 

Das beschreibt auch folgender Satz auf der MapStruct: "In contrast to other mapping frameworks MapStruct generates bean mappings at compile-time". Die Beans werden bereits während dem Kompilieren generiert und ersetzen damit die Interfaces.

Damit erklärt sich folgender Vorteil: [MapStruct generates mapping code at build time, resulting in type-safe mappings which don't require any dependencies at runtime"](https://stackoverflow.com/questions/374302/how-to-map-different-java-bean-structures-onto-one-another)
Schon beim Kompilieren würde sich herausstellen, wenn zwei Felder nicht zueinander gemappt werden können.