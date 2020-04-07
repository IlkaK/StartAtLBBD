# 3. Git-Übung zu Rebase, Merge und CherryPicking #

In dieser Git Übung gehe ich darauf ein, wie zwei auseinandergelaufene Branches wieder zusammengefasst werden können. Typischerweise gibt es einen Feature-Branch, dessen Änderungen wieder in den Master-Branch überführt werden sollen. Bei uns ist der Feature-Branch Dein Branch NadinesLoesungen.

Wenn Du die Commit-Historie betrachtest, siehst Du, dass der Branch NadinesLoesungen die neueren Commits vom Master nicht enthält. Da aber keine zusätzlichen Änderungen auf dem Branch gemacht wurden, kann er einfach rebased werden. Mit dem Befehl `git rebase` würden die neueren Commits aus dem Master einfach übernommen.

Wichtig beim Rebase ist, von welchem Branch zu welchem Branch rebased wird. Also auf welchen Branch möchte ich die Commits eines anderen Branches bringen. In unserem Fall möchten wir die Commits des Masters auf den NadinesLoesungen kopieren. Man muss jeweils auf dem Branch sein, auf den man die Commits eines anderen Branches kopieren möchte.

## Git-Übung ##

1. Wechsel auf den Master Branch: `git checkout master`

2. Wann wurde das letzte Commit gemacht: `git log`

3. Wechsel auf den Branch NadinesLoesungen: `git NadinesLoesungen`

4. Wann wurde das letzte Commit hier gemacht: `git log`

5. Welche Meldung ergibt `git status`? 

6. Führe den Befehl `git rebase master` aus.

7. Welches ist jetzt das letzte Commit: `git log`
