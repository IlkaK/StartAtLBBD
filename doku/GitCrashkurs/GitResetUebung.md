# 3. Git-Übung zum Reset #

Das Git Reset ist immer mal wichtig, wenn man sich irgendwo im Git verliert und nicht mehr weiss, was man alles gepusht, gepullt hat und irgendwo zwischen verschiedenen Merge-Konflikten steht. Das passiert mir auch immer wieder. 

Manchmal ist es einfacher, die eigenen Dateiänderungen zwischenzuspeichern und alles zu resetten zu dem Stand, der auf dem Server gespeichert ist. 

Für die Übung können wir wieder Veränderungen an GitTest.md machen. Überprüfe vor der Übung mit `git status`, dass Dein Working Tree clean ist, also das es keine Änderungen gibt, die noch nicht gepusht wurden. Die würden sonst automatisch zurückgesetzt sind.

## Vorraussetzung ##

Die Ausgabe von `git status` sollte folgendermassen aussehen:

On branch master
Your branch is up to date with 'origin/master'.

nothing to commit, working tree clean


## Start Übung ## 

1. Verändere die Datei GitTest.md und speicher sie.

2. Was ergibt `git status` jetzt?

3. Jetzt machen wir die Änderung rückgängig: `git reset --hard`

4. Was siehst Du jetzt in `git status`?

5. Verändere die Datei GitTest.md noch einmal speicher sie und füge sie dem Index hinzu.

6. Mache die Änderung wieder rückgängig mit dem gleichen Befehl: `git reset --hard` 

7. Was steht jetzt bei `git status`?
