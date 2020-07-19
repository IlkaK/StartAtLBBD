# Begriffe / Terms #

### Gefässe und Abhängigkeiten ###

- dependencies: Abhängigkeiten, z.B. ein Objekt benötigt ein anderes, bevor es erzeugt werden kann

- container: ein Gefäss, in dem die Objekte leben, die man erzeugt hat und die sich dort kennen

- IoC Inversion of Control: der Prozess, in dem ein Objekt definiert, welche Abhängigkeiten es hat, aber diese nicht selber erstellt

- Spring IoC container: das Gefäss, in dem die Objekte leben und welches zusätzlich ihre Abhängigkeiten managt

- Spring bean: alle Objekte, die in dem Spring IoC container leben

- dependency injection: wenn der Container ein Bean erstellt, füllt/injiziert (injects) er die Abhängigkeiten (dependencies) des Beans ab