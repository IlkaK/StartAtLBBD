# 4. Git-Übung zum Cherry Picking #

Beim Cherry-Picking geht es darum, gezielt nur gewisse Änderungen von einem anderen Branch herauszupicken und dann auf dem eigenen Branch einzuspielen.

Jedes Commit hat eine eindeutige Id. So ist es z.B. immer möglich, innerhalb eines Branches auf ein altes Commit zu wechseln (`git reset commitId`). Beim Cherry-Picking ist die CommitId praktisch, weil man dann aus einer Vielzahl von Commits einzelne eindeutig herauspicken und auf dem eigenen Branch anwenden kann.

IntelliJ unterstützt das Cherry-Picking auch sehr schön grafisch. Aber es ist auch innerhalb der Git-Bash möglich.

Ich habe auf dem Master einen expliziten Commit zum Testen abgesetzt. Bevor Du ein Rebase Deines Branches machst, kannst Du den Commit cherry-picken.

Die Id des Commits ist: 0f84a339d5ac76e62c6c2ffebf1e3d0b9bea014e der Kommentar dazu ist "Commit zum Ueben des Cherry-Pickings"

## Start Übung ## 

1. Wechlse auf den Branch NadinesLoesungen: `git checkout NadinesLoesungen`

2. Führe den Befehl zum Cherry-Picking aus: `git cherry-pick 0f84a339d5ac76e62c6c2ffebf1e3d0b9bea014e`

3. Was zeigt das `git log` an?

4. Führe ein Rebase Deines Branches aus: `git rebase master`

5. Was zeigt `git log` jetzt an?


## Exkurs ##

Cherry-Picking geht auch auf einzelne Dateiänderungen innerhalb verschiedener Commits. Dann packt man allerdings die Änderungen wieder in einen eigenen Commit und speichert diesen auf dem eigenen Branch. Wenn ich so etwas mache, schreibe ich in den Commit-Kommentar vom neuen Commit die CommitIds, aus denen ich mich bedient habe. Die Commit-Historie kommt dann meistens auch ein wenig durcheinander, da ja später wahrscheinlich wieder ein Rebase oder Merge folgt und die Original-Commits wieder auftauchen. Daher finde ich die Commit-Kommentare an der Stelle wichtig.

Woher kommt die lange CommitId? Die CommitId ist ein SHA-1 hash, der aus dem Inhalt des Commits gebildet wird. Auch die Parent-Commits spielen in den Hash mit rein, d.h. alles was vorher commited wurde. Wenn man davon ausgeht, dass in jedem Commit etwas anderes gemacht wird oder jeder Commit zumindest unterschiedliche Parent-Commits hat, dann muss auch der Hash, der gebildet wird, immer anders sein. Dadurch wird die CommitId eindeutig. Git beschleunigt dadurch auch die Vergleiche der Commits. 

Im Stackoverflow gibt es einen guten Post dazu: [Git CommitId](https://stackoverflow.com/questions/29106996/what-is-a-git-commit-id)