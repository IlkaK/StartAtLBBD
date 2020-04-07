# 3. Git-Übung zu Rebase, Merge und CherryPicking #

In dieser Git Übung gehe ich darauf ein, wie zwei auseinandergelaufene Branches wieder zusammengefasst werden können. Typischerweise gibt es einen Feature-Branch, dessen Änderungen wieder in den Master-Branch überführt werden sollen. Bei uns ist der Feature-Branch Dein Branch NadinesLoesungen.

Wenn Du die Commit-Historie betrachtest, siehst Du, dass der Branch NadinesLoesungen die neueren Commits vom Master nicht enthält. Da aber keine zusätzlichen Änderungen auf dem Branch gemacht wurden, kann er einfach rebased werden. Mit dem Befehl `git rebase` würden die neueren Commits aus dem Master einfach übernommen.

Wichtig beim Rebase ist, von welchem Branch zu welchem Branch rebased wird. Also auf welchen Branch möchte ich die Commits eines anderen Branches bringen. In unserem Fall möchten wir die Commits des Masters auf den NadinesLoesungen kopieren. Man muss jeweils auf dem Branch sein, auf den man die Commits eines anderen Branches kopieren möchte.

## Git-Übung zum Rebase ##

1. Wechsel auf den Master Branch: `git checkout master`

2. Wann wurde das letzte Commit gemacht: `git log`

`Author: Ilka Kokemor <ikokemor@gmail.com>
Date:   Tue Apr 7 12:09:33 2020 +0200
Aenderung am Git-Testfile`

`Author: Ilka Kokemor <ikokemor@gmail.com>
Date:   Tue Apr 7 12:09:33 2020 +0200
Aenderung am Git-Testfile`

3. Wechsel auf den Branch NadinesLoesungen: `git checkout NadinesLoesungen`

4. Wann wurde das letzte Commit hier gemacht: `git log`

`Author: Ilka Kokemor <ikokemor@gmail.com>
Date:   Mon Mar 30 22:41:26 2020 +0200
    Mehr Infos zu Git`

`Author: Ilka Kokemor <ikokemor@gmail.com>
Date:   Mon Mar 30 22:41:26 2020 +0200
    Mehr Infos zu Git`

5. Welche Meldung ergibt `git status`? 

`Your branch is up to date with 'origin/NadinesLoesungen'.
nothing to commit, working tree clean`

`Your branch is up to date with 'origin/NadinesLoesungen'.
nothing to commit, working tree clean`

6. Führe den Befehl `git rebase master` aus.

7. Welches ist jetzt das letzte Commit: `git log`

`Author: Ilka Kokemor <ikokemor@gmail.com>
Date:   Tue Apr 7 12:09:33 2020 +0200
Aenderung am Git-Testfile`

## Git-Übung zum Merge ##

Ein häufiges Vorgehen ist, dass man auf einem Feature-Branch entwickelt hat und diesen dann mit einem Rebase wieder auf den aktuellen Stand des Master-Branches gebracht hat. Jetzt möchte man die Änderungen aus dem Feature-Branch in den Master überführen. Dafür wird der Befehl `git merge` verwendet.

1. Wechsel auf den Branch NadinesLoesungen.

2. Verändere das Testfile GitTest.md => [Link zum Testfile zum Git Merge ueben](./GitTest.md)

3. Füge die Änderung dem Index hinzu und commite sie. 

4. Wechsel auf den Branch master: `git checkout master` (auch hier gilt, auf den Branch wechseln, der die Änderung des anderen Branches übernehmen soll)

5. Führe den Befehl zum Merge aus: `git merge NadinesLoesungen`

6. Was siehst Du jetzt mit `git log`?

`Author: unknown <nadineeisenring@bluewin.ch>
Date:   Tue Apr 7 12:55:51 2020 +0200 Aenderung zum testen`


## Exkurs ##

Merging versus Rebasing. Aus der bisherigen Beschreibung sieht beides sehr ähnlich aus. 
Unter dem folgenden Link wird auf die Unterschiede von Merging und Rebasing eingegangen. 
[Merge vs. Rebase](https://www.atlassian.com/de/git/tutorials/merging-vs-rebasing)

Merging wird auch hier gut erklärt mit ein paar hilfreichen Grafiken [Git Merge](https://git-scm.com/book/de/v2/Git-Branching-Einfaches-Branching-und-Merging#_basic_merging)
