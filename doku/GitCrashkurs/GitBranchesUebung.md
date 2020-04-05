# 1. Git-Übung zum Kennenlernen der Branches #

In dieser Git-Übung erstellst Du einen eigenen Branch. Der leere Branch wird auf Github gepusht und Du wechselst in den neuen Branch. Dann werde ich noch ein wenig auf die Hintergründe von Remote-Branches eingehen, da dies eins der Schlüsselkonzepte von Git ist.

Ich sende Dir die Fragen noch via Mail, dann kannst Du die Antworten bzw. die Git-Bash-Ausgaben in einer Rückantwort senden. Wenn Du magst, kannst Du die Antworten auch direkt ins Github posten, aber Du kannst sie mir anfangs auch noch per Mail senden.

## Vorbedingungen ##
Öffnen der Git-Bash im Verzeichnis StartAtLBBD, bzw. wechsel mit `cd StartAtLBBD` in das Verzeichnis. Falls Du noch nicht geklont hast, führe noch den [Git Start](./GitStart.md) aus. Falls Du nicht siehst, in welchem Verzeichnis Du gerade bist, verwende den Befehl `ls`. 

## Erstellen eines Branches ##

1. Was siehst Du zurzeit, wenn Du `git branch -a` ausführst?

2. Erstelle einen eigenen Branch mit dem Befehl: `git branch "NadinesLoesungen"`

3. Was siehst Du jetzt, wenn Du `git branch -a` ausführst?

4. Wechsle in den neuen Branch `git checkout NadinesLoesungen`

5. Was siehst Du jetzt, wenn Du `git branch -a` ausführst?

6. Speicher den neuen Branch im Github mit dem Befehl `git push -u origin HEAD`

7. Welche Ausgabe bekommst Du dabei in der Git-Bash?

8. Was siehst Du jetzt, wenn Du `git branch -a` ausführst?

9. Schau unter https://github.com/IlkaK/StartAtLBBD unter dem Punkt "branches" (neben "commits").
Findest Du dort Deinen neuen Branch?

## Hintergrund ##

Warum sehen wir den neuen Branch mit git branch -a jetzt zwei Mal? Also NadinesLoesungen und remotes/origin/NadinesLoesungen?

Git legt beim Klonen jeden Branch mit dem Prefix remotes/origin an. Wenn man via checkout das erste Mal in den Branch wechselt, kopiert Git den Branch noch mal und lässt dabei den Prefix weg. 

Der remotes/origin/NadinesLoesungen-Branch ist die Verbindung zum selben Branch auf Github. Bei einem Fetch bekommt remotes/origin/NadinesLoesungen alle Änderungen, die auf dem Github-Server im selben Branch gespeichert wurden. Das ist wichtig, sobald mehr als eine Person an einem Branch arbeitet und alle einen zentralen Server zum Austausch des Codes verwenden.

Die Änderungen, die Du bisher nur lokal vorgenommen und gespeichert hast, werden im NadinesLoesungen-Branch gespeichert. Dieser läuft erstmal neben remotes/origin/NadinesLoesungen her. 

Allerdings wollen wir Änderungen vom Server ja mit unseren lokalen Änderungen zusammenführen. Dafür gibt es den Befehl merge. Mit dem werden die Änderungen aus remotes/origin/NadinesLoesungen in den Branch NadinesLoesungen überführt. Um fetch und merge abzukürzen, verwende ich gerne den Befehl pull. Darauf basiert die nächste Übung.

Theoretisch wäre es möglich, dass Du auch mehrere remotes/origin/NadinesLoesungen-Branches hast, welche nicht nur auf Github zeigen, sondern auch auf andere Servern. Das ist ein Vorteil von Git gegenüber anderen Versionskontrollsystemen. Es ist ein verteiltes Versionskontrollsystem. Man kann dasselbe Repository mit verschiedenen Servern synchronisieren. Dabei den Überblick zu behalten, ist wieder eine ganz andere Herausforderung...

Bei uns ist es einfach, wir haben unser zentrales Repository auf Github liegen. Auch unser Arbeitgeber verwendet nur einen Server für den Austausch der Repositories. Auf dieses Pushen wir unsere Änderungen und Pullen wieder Änderungen zurück auf unseren Rechner.