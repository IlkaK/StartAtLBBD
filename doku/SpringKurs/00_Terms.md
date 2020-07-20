# Begriffe / Terms #

### Gefässe und Abhängigkeiten ###

- dependencies: Abhängigkeiten, z.B. ein Objekt benötigt ein anderes, bevor es erzeugt werden kann

- container: ein Gefäss, in dem die Objekte leben, die man erzeugt hat und die sich dort kennen

- IoC Inversion of Control: der Prozess, in dem ein Objekt definiert, welche Abhängigkeiten es hat, aber diese nicht selber erstellt

- Spring IoC container: das Gefäss, in dem die Objekte leben und welches zusätzlich ihre Abhängigkeiten managt

- Spring bean: alle Objekte, die in dem Spring IoC container leben

- dependency injection: wenn der Container ein Bean erstellt, füllt/injiziert (injects) er die Abhängigkeiten (dependencies) des Beans ab

----

- leightweight: Spring ist leichtgewichtig, da es nicht als grosse ganze Einheit verwendet muss, sondern nur Teile davon verwendet werden können

-> Z.B. verwenden wir im Projekt Spring MVC mit Rest, aber andere Komponenten, wie z.B. Spring Batch dann wieder nicht.

-> Unter folgendem Link habe ich eine Variation von Antworten gefunden:
[Diskussion über leightweight](https://stackoverflow.com/questions/8117166/what-makes-the-spring-framework-a-lightweight-container#:~:text=Spring%20calls%20itself%20'lightweight'%20because,according%20to%20your%20required%20module)

-> Spring ist leichtgewichtig gegenüber EJB. Mit EJB [Java Enterprise Beans](https://de.wikipedia.org/wiki/Enterprise_JavaBeans) z.B. im Zusammenhang mit JBoss als Applikationsserver kommt relativ viele Abhängigkeiten. 

- repository: Aufbewahrung oder Depot, bei dem Stichwort geht es immer um die Persistenz von Daten, also meistens Datenbanken

- @Repository: Die @Repository Annotation bei Spring Beans beinhaltet alles, was die @Component Annotation beinhaltet. Es wird dann verwendet, wenn es um die Datenbankanbindung bzw. das Handling von Daten auf der Datenbank geht (persistence layer). Mit der @Repository Annotation wird Spring genau das gesagt: hier geht es um die Datenbankdaten. Die Annotation macht noch ein wenig mehr: sie wandelt Exceptions, die mit der Datenbank zu tun haben, in Spring-Exceptions um.

- @Component: Mit der Annotation @Component weiss Spring, dass es sich hier um ein Bean handelt, welches im Container gemanagt werden muss. Damit registriert sie Spring im Application Context.

- POJOs: Plain Old Java Objects => Das sind ganz normale Klassen mit Attributen und Get- und Set-Methoden.

- application context: ein erweiterter Spring-Container, der die Beans managt

- singleton: von einer Klasse wird nur ein einziges Objekt erzeugt, meistens darf es in dem Kontext, wo es erzeugt wird, auch nur ein einziges geben

- singleton beans: Das sind Beans, von denen nur eine einzelne Instanz im Spring Container erzeugt wird. Sämtliche andere Möglichkeiten: [bean scopes](https://docs.spring.io/spring/docs/3.0.0.M3/reference/html/ch04s04.html)

-----


- bootstrapped:

- proxys

- classpath

- working directory
