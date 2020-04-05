# Nützliche Git Befehle #

## git status ## 

Mit `git status` siehst Du Folgendes:

```
On branch master

 Your branch is up to date with 'origin/master'.

 nothing to commit, working tree clean
 ```
Git status hilft mir immer, wenn ich nicht weiss, auf welchem Branch ich gerade bin und welche Dateien ich alle angepasst habe. Hier bist Du auf dem Branch `master`. Der Teil `Your branch is up to date with origin/master` bezieht sich auf die Beziehung zwischen der Veränderung vom Remote-Branch, welcher origin/master heisst und dem aktuellen Branch (master - ohne origin), auf dem Du gerade arbeitest.

Wenn eine Datei verändert wurde, sieht es so aus:

```
On branch master
Your branch is up to date with 'origin/master'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

	modified:   doku/GitCrashkurs/GitStart.md

no changes added to commit (use "git add" and/or "git commit -a")
 ```

Die Datei `GitStart.md` hat sich verändert, aber die Veränderung wird von Git noch ignoriert, da sie nicht markiert ist, dass sie beim nächsten Commit im Git gespeichert wird (not staged for commit).

## git branch -a ##
 
Mit `git branch -a` siehst Du alle Branches, die es bei Dir im Git gibt.

```
* master
  remotes/origin/master
```

Der Eintrag mit * bezieht sich auf den Branch, auf dem Du gerade arbeitest. Der Branch `origin/master` ist ein Remote-Branch. 



## git pull ##

Mit `git pull` holst Du Dir alle Änderungen, die auf Github gespeichert wurden.


## git add * ##

Mit `git add *` fügst Du alle Änderungen, die Du bisher nur in Dateien gespeichert hast, in den Git Index hinzu.


## git commit -m "Hier steht eine Commit-Message" ## 

Mit `git commit -m "Hier steht eine Commit-Message"`commitest Du alle Änderungen, die bisher im Index waren. Bei jeder Ausführung von `git commit` wird ein neuer Commit erstellt. 

## git push ##

Mit `git push` speicherst Du alle Änderungen, die Du commitet hast auf Github.
