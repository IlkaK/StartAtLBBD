# 2. Git-Übung über Indexe, Commits und Pushes #

In dieser Git Übung gehe ich darauf ein, wie in Git Dateiänderungen registriert und gespeichert werden und wie die Änderungen dann im zentralen Repository, also bei uns im Github, landen.

Git - so wie jedes Versionskontrollsystem - loggt jede Dateiänderung. Damit wird jede Änderung verfolgbar, von wem und warum wurde die Datei verändert. Wenn viele Benutzer an einem grossen Programm arbeiten, ist das extrem hilfreich. 

## Commit ##

Eine zentrale Komponente in Git ist das Commit. Ein Commit kann verschiedene Dateiänderungen beinhalten. 

### Kleiner Exkurs ###

Git speichert bei einem Commit intern nicht die Datei an sich, sondern nur die Änderungen, die daran gemacht wurden. Damit funktioniert es anders als andere Versionskontrollsysteme (z.B. SVN). Normalerweise werden einfach die Dateien immer und immer wieder gespeichert. Git speichert nur die Dateiänderungen. Wenn man also einen aktuellen Stand einer Datei anschaut, ist das nur die Zusammensetzung vieler Commits zu dem Dateiresultat, was man dann sieht.

## Index ##

Bevor eine Dateiänderung in einem Commit landen kann, muss sie als erstes in den Index gestellt werden.
Also nach der Speicherung auf dem lokalen Dateisystem, muss die Dateiänderung dem Index hinzugefügt werden 
Der Befehl dazu ist `git add veraenderteDatei`. Um alle bis jetzt veränderten Dateien in den Index zu stellen, kann man mit `*` arbeiten, `git add *`. 

Wird danach ein Commit abgesetzt, dann werden alle im Index gesammelten Dateiänderungen in dem Commit übernommen. Bei jedem Commit, muss ein Erklärtext mitgegeben werden. Hat man also viele verschiedene Änderungen gemacht, lohnt es sich, erst einen Teil in den Index zu stellen, den Commit mit einer entsprechenden Erklärung zu versehen und dann erst die nächsten Dateiänderungen in den Index zu stellen und diese wieder zu commiten usw. So entsteht eine nachvollziehbare Commit-Historie.

## Start Übung ##

Um die Übung zu machen, würde ich empfehlen auf den eigenen Branch aus der Übung zuvor zu wechseln. [Git Branches](./GitBranchesUebung.md)

1. Um auf den eigenen Branch zu wechseln: `git checkout NadinesLoesungen`

2. Was siehst Du, wenn Du den Befehl `git log` ausführst? 
Um die Log-Ansicht zu beenden, benötigt es ein `q`. 

3. Vergleiche mit der Ansicht, der Commits im [Github](https://github.com/IlkaK/StartAtLBBD/commits/master). Gibt es Unterschiede, findest Du die Commits aus der Git-Bash hier wieder? 

4. Öffne die Datei README.md in einem Editor oder in Eclipse. Ändere den Titel des untersten Links von "Buch Java Grundkurs" zu "Fragen zum ersten Kapitel" und speicher die Datei.

5. Führe den Befehl `git status` aus. Was siehst Du in der Git-Bash?

6. Füge die Dateiänderung dem Index hinzu: `git add README.md` 

7. Was sieht man jetzt bei `git status`?

8. Jetzt wird die Änderung commitet: `git commit -m "Korrektur des Titels des Kapitellinks"`

9. Was siehst Du jetzt, wenn Du den Befehl `git log` ausführst? Um die Log-Ansicht zu beenden, benötigt es ein q. Taucht der neue Commit im Log auf?

10. Und zum Schluss wird die Änderung auf Github gepusht: `git push`

11. Was steht jetzt bei `git status`?

12. Findest Du die Änderung auf Github wieder?

