# Einbinden von Log4J 2 ins Projekt mit Eclipse #

Die Libraries, die verwendet werden, sind im Verzeichnis libs untergebracht. Sie werden im pom.xml referenziert. Damit auch Eclipse weiss, wo es die Libraries findet, musste ich sie noch in den Classpath des Projekts eintragen.

Project -> Properties -> Java Build Path -> Classpath und dann den Classpath markieren.

Danach wird der Button "Add Jars" aktiv und mit einem Klick darauf kann zu den beiden Libriaries navigiert werden.

![image](./log4jInClasspath.png)

Danach sollte es möglich sein, auf das pom.xml via Rechtsklick -> Run as -> Maven install 

und danach -> Maven build aufzurufen.

Bei Maven build kommt manchmal noch ein Fenster, was u.A. einen Namen anfordert. Dort hat "Test" bei mir gereicht.

Danach konnte ich die LearningLog4J Klasse als Java Application ausführen.
