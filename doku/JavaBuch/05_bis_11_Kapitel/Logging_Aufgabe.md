# Logging mit Log4J 2 #

In der folgenden Übung können wir die GgT-Übung als Grundlage nehmen und sie mit einem umfangreichen Logging-Konzept versehen.
Dabei geht es darum, Log4J 2 einzubinden und kennenzulernen. Ich denke, wir streifen damit relativ viele Themen bis und mit Kapitel 11.

Ein kurzer Hinweis, falls Du Dir Hilfe zum Log4J 2 googelst: verwendende besser das Stichwort "Log4J 2", denn die ältere Version Log4J 1 ist in gewissen Teilen doch sehr anders als Log4J 2, z.B. was die Syntax von den XML Configuration betrifft. [Migration von Log4J 1 auf 2](https://logging.apache.org/log4j/log4j-2.2/manual/migration.html)

Mit dem neuesten Rebase sind zwei neue Dateien mitgekommen. Einmal die Klasse LearningLog4J.java als Beispiel-Klasse. Sobald die bei Dir läuft, kannst Du mit der Ggt-Erweiterung anfangen. Zum Aufsetzen habe ich Eclipse-Teil neue Infos hinzugefügt: [Aufsetzen von Log4J 2](../../Eclipse/Addlog4jLib.md)

Die zweite Datei ist log4j2.xml. Dort wird definiert, wie welche Art von Log zu behandeln ist.

Dort drin können ein oder mehrere Appenders definiert werden. Die Appenders bestimmt, wohin das Log gehen soll und welche Informationen im Log stehen sollen. In der Vorgabe gibt es einen Appender für File und einen für die Console. Für jeden Appender wird ein Name festgelegt, der später in den Loggers referenziert wird. Es gibt aber auch Unterschiede zwischen den Appendern. Beim File-Appender muss z.B. im Unterschied zur Console ein Filename angegeben werden. [Appender im Log4J 2](https://logging.apache.org/log4j/2.x/manual/appenders.html)

Bei beiden Appendern wird ein Pattern-Layout festgelegt. Umfangreich beschrieben findet man die [Pattern-Layouts hier](https://logging.apache.org/log4j/2.x/manual/layouts.html).

Danach werden die [Logger definiert](https://logging.apache.org/log4j/2.x/manual/configuration.html#Loggers).
Es kann einen oder keinen Logger geben, aber es muss immer einen Root geben.
Beim Logger wird ein Level bestimmt: TRACE, DEBUG, INFO, WARN, ERROR, ALL or OFF. Wenn keiner bestimmt wird, ist der Default ERROR.
Mit AppenderRef wird bestimmt, wohin und wie der Logger-Level ausgegeben werden soll.


## Übungsbeschreibung ##

Es geht darum, die GgT-Klasse zu erweitern, so dass die einzelnen Schritte geloggt werden. 

- Die Eingabe-Parameter sollen als Info-Logs geschrieben werden.
- Wenn ein Benutzer mehr als zwei Zahlen eingegeben hat, soll nur mit zwei Zahlen gerechnet werden, aber eine Warnung in das Log geschrieben werden.
- Falsche Eingaben, z.B. ein String statt eine Zahl, soll aber ins Error-Log geschrieben werden.
- Auch allfällige Exceptions sollen ins Error-Log geschrieben werden.

- Die Logs für Debug und Info sollen nur in ein File weitergeleitet werden.
- Die Logs für Warning und Error sollen in der Console ausgegeben und in ein File umgeleitet werden.
- Falls Dir danach noch langweilig ist, kannst Du ausprobieren, ob es geht, alle Error zusätzlich über einen SMTPAppender als Mail zu verschicken

- Zu allen Logs sollen Datum und Uhrzeit erfasst werden (entweder über das Pattern-Layout im XML oder in der Log-Message selber 


Falls über das Pattern-Layout sollen die Logs folgendermassen aussehen:

`[Logging-Level] Datum und Uhrzeit - die Logger-Klasse mit Methode: Log Message`

also z.B. `[ERROR] 20.04.2020 15:30:22.000 - main.java.ch.start.uebung.LearningLog4J.main: hier steht die Log-Message`

Falls Datum und Uhrzeit innerhalb der Log-Meldung sind, soll das Log folgendermassen aussehen:

`[Logging-Level] die Logger-Klasse mit Methode: Datum und Uhrzeit - Log Message`

also z.B. `[ERROR] main.java.ch.start.uebung.LearningLog4J.main: 20.04.2020 15:30:22.000 - hier steht die Log-Message`



