# 4. Git-Übung zum Cherry Picking #

Beim Cherry-Picking geht es darum, gezielt nur gewisse Änderungen von einem anderen Branch herauszupicken und dann auf dem eigenen Branch einzuspielen.

Jedes Commit hat eine eindeutige Id. So ist es z.B. immer möglich, innerhalb eines Branches auf ein altes Commit zu wechseln (`git reset commitId`). Beim Cherry-Picking ist die CommitId praktisch, weil man dann aus einer Vielzahl von Commits einzelne eindeutig herauspicken und auf dem eigenen Branch anwenden kann.

IntelliJ unterstützt das Cherry-Picking auch sehr schön grafisch. Aber es ist auch innerhalb der Git-Bash möglich.

Ich habe auf dem Master einen expliziten Commit zum Testen abgesetzt. Bevor Du ein Rebase Deines Branches machst, kannst Du den Commit cherry-picken.

Die Id des Commits ist: 0f84a339d5ac76e62c6c2ffebf1e3d0b9bea014e der Kommentar dazu ist "Commit zum Ueben des Cherry-Pickings"

## Start Übung ## 

1. Wechlse auf den Branch NadinesLoesungen(`git checkout NadinesLoesungen`)

2. Führe den Befehl zum Cherry-Picking aus: `git cherry-pick 0f84a339d5ac76e62c6c2ffebf1e3d0b9bea014e`

3. Was zeigt das `git log` jetzt an?