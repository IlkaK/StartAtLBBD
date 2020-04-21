# Logging mit Log4J 2 #

In der folgenden Übung können wir die GgT-Übung als Grundlage nehmen und sie mit einem umfangreichen Logging-Konzept versehen.
Dabei geht es darum, Log4J 2 einzubinden und kennenzulernen. Ich denke, wir streifen damit relativ viele Themen bis und mit Kapitel 11.

Ein kurzer Hinweis, falls Du Dir Hilfe zum Log4J 2 googelst: verwende besser das Stichwort "Log4J 2", denn die ältere Version Log4J 1 ist in gewissen Teilen doch sehr anders als Log4J 2, z.B. was die Syntax der XML Configuration betrifft. [Migration von Log4J 1 auf 2](https://logging.apache.org/log4j/log4j-2.2/manual/migration.html)

Mit dem neuesten Rebase sind zwei neue Dateien mitgekommen. Einmal die Klasse LearningLog4J.java als Beispiel-Klasse. Sobald die bei Dir läuft, kannst Du mit der Ggt-Erweiterung anfangen. Zum Aufsetzen habe ich hier neue Infos zu Eclipse hinzugefügt: [Aufsetzen von Log4J 2](../../Eclipse/Addlog4jLib.md)

Die zweite Datei ist log4j2.xml. Dort wird definiert, wie welche Art von Log zu behandeln ist.

Einer oder mehrere Appenders können definiert werden. Die Appenders bestimmen, wohin das Log gehen soll und welche Informationen im Log stehen sollen. In dem von mir erstellen log4j2.xml gibt es einen Appender für ein File und einen für die Console. Für jeden Appender wird ein Name festgelegt, der später in den Loggers referenziert wird. Nähere Informationen zu Appendern sind hier zu finden: [Appender im Log4J 2](https://logging.apache.org/log4j/2.x/manual/appenders.html)

Bei beiden Appendern wird ein Pattern-Layout festgelegt. Umfangreich beschrieben findet man die [Pattern-Layouts hier](https://logging.apache.org/log4j/2.x/manual/layouts.html).

Danach werden die [Logger definiert](https://logging.apache.org/log4j/2.x/manual/configuration.html#Loggers).
Es kann einen oder keinen Logger geben, aber es muss immer einen Root geben.
Beim Logger wird ein Level bestimmt: TRACE, DEBUG, INFO, WARN, ERROR, ALL or OFF. Wenn keiner bestimmt wird, ist der Default ERROR.
Mit AppenderRef wird bestimmt, wohin und wie der Logger-Level ausgegeben werden soll, es wird auf einen zuvor erstellten Appender referenziert.


## Übungsbeschreibung ##

Die Übung besteht daraus, die GgT-Klasse zu erweitern, so dass die einzelnen Schritte geloggt werden. 

- Die Eingabe-Parameter sollen als Info-Logs geschrieben werden.
- Wenn ein Benutzer mehr als zwei Zahlen eingegeben hat, soll nur mit zwei Zahlen gerechnet werden, aber eine Warnung in das Log geschrieben werden.
- Falsche Eingaben, z.B. ein String statt eine Zahl, soll ins Error-Log geschrieben werden.
- Auch allfällige Exceptions sollen ins Error-Log geschrieben werden.

- Die Logs für Debug und Info sollen nur in ein File weitergeleitet werden und nicht auf der Console ausgegeben werden.
- Die Logs für Warning und Error sollen in der Console ausgegeben und in ein File umgeleitet werden.
- Falls Dir danach noch langweilig ist, kannst Du ausprobieren, ob es geht, alle Error zusätzlich über einen SMTPAppender als Mail zu verschicken. Kannst ruhig meine Mail-Adresse zum Testen verwenden, wenn Du eine zweite brauchst.

- Zu allen Logs sollen Datum und Uhrzeit erfasst werden (entweder über das Pattern-Layout im XML oder in der Log-Message selber. 


Falls Du das Pattern-Layout für Datum und Uhrzeit verwendest, sollen die Logs so aussehen:

`[Logging-Level] Datum und Uhrzeit - Logger-Klasse.Methode: Log Message`

also z.B. `[ERROR] 20.04.2020 15:30:22.000 - main.java.ch.start.uebung.LearningLog4J.main: hier steht die Log-Message`

Falls Du Datum und Uhrzeit innerhalb der Log-Meldung ausgibst, soll das Log folgendermassen aussehen:

`[Logging-Level] Logger-Klasse.Methode: Datum und Uhrzeit - Log Message`

also z.B. `[ERROR] main.java.ch.start.uebung.LearningLog4J.main: 20.04.2020 15:30:22.000 - hier steht die Log-Message`

Wichtig ist, dass die Log-Messages einigermassen einheitlich sind. Danach können wir dann noch das Einbinden des Stacktrace genauer anschauen, so dass der mit ausgegeben wird.
