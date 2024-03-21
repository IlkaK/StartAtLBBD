# Begriffe / Terms #

## Gefässe und Abhängigkeiten ##

- dependencies: Abhängigkeiten, z.B. ein Objekt benötigt ein anderes, bevor es erzeugt werden kann

- container: ein Gefäss, in dem die Objekte leben, die man erzeugt hat und die sich dort kennen

- Inversion of Control (IoC): der Prozess, in dem ein Objekt definiert, welche Abhängigkeiten es hat, aber diese nicht selber erstellt

- Spring IoC Container: das Gefäss, in dem die Objekte leben und welches zusätzlich ihre Abhängigkeiten managt

- Spring bean: alle Objekte, die in dem Spring IoC container leben

- dependency injection: wenn der Container ein Bean erstellt, füllt/injiziert (injects) er die Abhängigkeiten (dependencies) des Beans ab

-----

## Leichtgewichtig ##

- leightweight: Spring ist leichtgewichtig, da es nicht als grosse ganze Einheit verwendet muss, sondern nur Teile davon verwendet werden können

Z.B. verwenden wir im Projekt Spring MVC mit Rest, aber andere Komponenten, wie z.B. Spring Batch dann wieder nicht.
Unter folgendem Link habe ich eine Variation von Antworten gefunden:
[Diskussion über leightweight](https://stackoverflow.com/questions/8117166/what-makes-the-spring-framework-a-lightweight-container#:~:text=Spring%20calls%20itself%20'lightweight'%20because,according%20to%20your%20required%20module).

Spring ist leichtgewichtig gegenüber EJB. Mit EJB [Java Enterprise Beans](https://de.wikipedia.org/wiki/Enterprise_JavaBeans) z.B. im Zusammenhang mit JBoss als Applikationsserver kommen viele Abhängigkeiten, die Spring nicht hat.

-----

## Components ##

- @Component: Mit der Annotation @Component weiss Spring, dass es sich hier um ein Bean handelt, welches im Container gemanagt werden muss. Mit der Annotation registriert Spring Container im Application Context.

- POJOs: Plain Old Java Objects => Das sind ganz normale Klassen mit Attributen und Get- und Set-Methoden.

- singleton: von einer Klasse wird nur ein einziges Objekt erzeugt, meistens darf es in dem Kontext, wo es erzeugt wird, auch nur ein einziges geben

- singleton beans: Das sind Beans, von denen nur eine einzelne Instanz im Spring Container erzeugt wird. Sämtliche andere Möglichkeiten: [bean scopes](https://docs.spring.io/spring/docs/3.0.0.M3/reference/html/ch04s04.html)

### Component: Repository ###

- repository: Aufbewahrung oder Depot, bei dem Stichwort geht es immer um die Persistenz von Daten, also meistens Datenbanken

- @Repository: Die @Repository Annotation bei Spring Beans beinhaltet alles, was die @Component Annotation beinhaltet. Es wird dann verwendet, wenn es um die Datenbankanbindung bzw. das Handling von Daten auf der Datenbank geht (persistence layer). Mit der @Repository Annotation wird Spring genau das gesagt: hier geht es um die Datenbankdaten. Die Annotation macht noch ein wenig mehr: sie wandelt Exceptions, die mit der Datenbank zu tun haben, in Spring-Exceptions um.

-----

## Application Context ##

Das ApplicationContext Interface und das BeanFactory Interface repräsentieren den Spring IoC Container.

- Bean Factory: das zugrunde liegende Interface, welches auf den Container zugreift und die Basisfunktionalitäten zum Managen der Beans bereitstellt.

- Application Context: ist ein von der Bean Factory abgeleitetes Interface (also ein Sub-Interface), welches alle Funktionalitäten der Bean Factory beinhaltet und noch zusätzliche enthält.

Es gibt verschiedene Implementationen vom Application Context, z.B. AnnotationConfigApplicationContext.
Eine Übersicht ist z.B. [hier](https://www.baeldung.com/spring-application-context) zu finden.

Falls man mehrere Application Contexts hat, sind sie isoliert voneinander, wie [hier](https://stackoverflow.com/questions/29862681/java-spring-multiple-applicationcontext) in der ersten Antwort beschrieben wird. In der zweiten Antwort wird beschrieben, dass das in MVC Spring nicht unüblich ist.

-----

## Bootstrapping ##

- bootstrapping: wird häufig verwendet als Synonym für booting oder initialisieren und bedeutet eine Kette von Ereignissen, um z.B. einen PC zu starten, wobei dann das Betriebssystem jeweils das Aufstarten der Programme übernimmt

[Bootstrapping, Abschnitt Applications, Software Development](https://en.wikipedia.org/wiki/Bootstrapping)

Wenn vom Bootstrapping in Spring geredet wird, ist damit die Abfolge von Prozessen gemeint, bis die effektive Spring-Applikation gestartet ist, [Bootstrapping in Spring](https://stackoverflow.com/questions/21714290/how-is-spring-actually-bootstrap)

-----

## Classpath ##

- classpath: der Pfad, wo die Applikation nach Benutzerklassen suchen soll

[Hier](https://stackoverflow.com/questions/2396493/what-is-a-classpath-and-how-do-i-set-it) wird recht gut erklärt, wie die Zusammenhänge zwischen .class, .jar und Classpath sind.

- working directory: `System.getProperty("user.dir")`

-----

## Proxy ##

- proxys: ein Proxy ist ein Platzhalter für ein Objekt, welches aufgerufen wird, und leitet dann weiter an das Objekt. Es sitzt quasi zwischen dem Objekt und dem Aufrufer (Caller)


Proxys erklärt im Spring Blog, im ersten Abschnitt: [What are proxys and why do we use them?](https://spring.io/blog/2007/07/19/debunking-myths-proxies-impact-performance/)