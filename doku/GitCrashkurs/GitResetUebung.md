# 3. Git-Übung zum Reset #

Das Git Reset ist immer mal wichtig, wenn man sich irgendwo im Git verliert und nicht mehr weiss, was man alles gepusht, gepullt hat und irgendwo zwischen verschiedenen Merge-Konflikten steht. Git status zeigt einem komische Sachen an und man will eigentlich nur wieder zurück.  Das passiert mir auch immer mal wieder. 

Wichtig ist beim Git Reset zu wissen, dass man sämtliche Änderungen im lokalen Git damit löschen kann. Aber man ändert dabei erst mal keine gepushten Commits auf dem Github. Egal wie viel man lokal löscht, man kann sich immer wieder den Stand vom Github als Grundlage zurückholen (so lange man selber noch nicht gepusht hat).

Manchmal ist es einfacher, die eigenen Dateiänderungen zwischenzuspeichern und alles zu resetten zu dem Stand, der auf dem Github gespeichert ist. 

Für die folgende Übung können wir wieder Veränderungen an GitTest.md machen. Überprüfe vor der Übung mit `git status`, dass Dein Working Tree clean ist, also das es keine Änderungen gibt, die noch nicht gepusht wurden. Die würden sonst mit der Übung automatisch zurückgesetzt werden.

## Vorraussetzung ##

Die Ausgabe von `git status` sollte folgendermassen aussehen:

On branch master
Your branch is up to date with 'origin/master'.

nothing to commit, working tree clean


## Übung zum Reset lokaler Änderung und Index ## 

1. Verändere die Datei GitTest.md und speicher sie.

2. Was ergibt `git status` jetzt?

3. Jetzt machen wir die Änderung im GitTest.md rückgängig: `git reset --hard`

4. Was siehst Du jetzt in `git status`?

5. Verändere die Datei GitTest.md noch einmal, speichere sie und füge sie dem Index hinzu.

6. Mache die Änderung wieder rückgängig mit dem gleichen Befehl: `git reset --hard` 

7. Was steht jetzt bei `git status`?

### Exkurs ###

Git Reset Hard ist ein mächtiger Befehl. Er macht ein Reset auf alle Änderungen, die noch nicht im Index sind und alle, die bereits im Index sind. Es gibt auch noch veschiedene weniger harte Varianten davon (z.B. `git reset --soft`), die helfen mir bei Problemen aber selten weiter. Hier gibt es eine kleine Übersicht zu den Varianten: [Git Reset Optionen](https://git-scm.com/docs/git-reset)

Aber es geht noch mehr.

## Übung zum Reset von Commits ##

8. Mache noch mal eine Änderung im GitTest.md, speicher sie, füge sie dem Index hinzu und commite sie, aber nicht pushen.

9. Was sieht Du bei `git status`?

10. Jetzt machen wir das Commit wieder rückgängig mit dem Befehl: `git reset --hard HEAD~1`

11. Was ergibt `git status` jetzt?

### Exkurs ###

Die Befehle `git reset --hard` und `git reset --hard HEAD` sind äquivalent. Beide gehen auf den letzten Stand des HEADs vom jeweiligen Branch zurück. HEAD ist der letzte Commit auf dem Branch. Möchten wir jetzt auf einen Commit davor springen, also auf den vorletzten, dann verwenden wir ~1 nach dem HEAD. Wir können auch noch weitere Commits zurückgehen. Statt 1 geben wir einfach die Anzahl der Commits, die wir zurückspringen möchten.

Es ist auch möglich, dass wir auf ein spezifisches Commit zurückspringen möchten. Hier kommt die CommitId wieder ins Spiel. Statt HEAD geben wir die CommitId an, z.B. `git reset --hard 0d1d7fc32`.