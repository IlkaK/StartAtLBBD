# Dateiverarbeitung und Lambda #

In dieser Aufgabe habe ich Kapitel 16 (Dateien und Verzeichniss) und 14 (Lambda-Ausdrücke) etwas näher angeschaut.

In vielen Applikationen und Programmen werden grosse Dateien (z.B. cvs) ausgelesen. Die Daten daraus gilt es in eine nachvollziehbare Klassenstruktur zu bringen und das ganze auf der Datenbank zu speichern.

Ich habe mit dem File ``positions.csv`` eine kleine Beispieldatei angelegt. Strukturell ähnlich kommt sie auch bei unserem Arbeitgeber vor.

Zurzeit wird sie im ``LearningLambda.java`` in die Klasse FileEntry umgewandelt. Eine Zeile ergibt ein Objekt. Aber so ist es in der Realität selten und macht auch bei FileEntry wenig Sinn. 

Häufig gibt es einen Scheduler, der automatisiert Dateien einliest und dann in ein Archiv verschiebt. 
Wenn man dann einen Fehler bei der Verarbeitung der Datei finden muss und da nicht mehr so einfach dran kommt und erstmal nur das Log durchforsten kann, können Details zur Datei weiterhelfen. Daher ist es wichtig, möglichst viele relevante Informationen bei der Dateiverarbeitung zu loggen. 

Die Übung besteht also darin:

1. Aufsetzen einer Klassenstruktur anhand der Daten im ``positions.csv``

2. Umwandlung der Loops, Logs und Abfragen innerhalb LearningLambda in Lambda-Ausdrücke (wo es Sinn macht).

3. Welche Informationen über Dateien bietet uns die Path-Klasse an und könnten mit ins Log wandern?