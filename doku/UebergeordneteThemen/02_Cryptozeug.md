# Cryptozeugs mit Public und Private Key #

X möchte was an Y schicken, dabei:
- (1) möchte Y sicherstellen, dass wirklich X was geschickt hat
- (2) möchte Y sicherstellen, dass nur Y lesen kann, was X geschickt hat

Für (1) bildet X einen Hash des Inhalts. Den Hash verschlüsselt er mit seinem Private-Key (also dem Private-Key von X). Y kann die Nachricht dann mit dem Public-Key von X entschlüsseln.


Für (2) verschlüsselt X den Hash zusätzlich mit dem Public-Key von Y.
   Dann kann nur Y mit seinem Private Key die Nachricht entschlüsseln.


## Problemstellung ##
 
1) man muss den eigenen Private-Key sicher aufbewahren, so dass ihn niemand stehlen kann, und 
2) man muss sicherstellen, dass der Public-Key den man von Y hat wirklich von Y ist.


### Certificate-Stellen ###

Die Sicherstellung, dass ein Public-Key von Y wirklich von Y kommt, wird über die Certificate-Stellen gelöst. 
Anstatt dass wir den Public-Key von jedem Y verifizieren, übergeben wir diese Aufgabe einer Zertifikatsstelle. 
Dann müssen wir nur noch sicherstellen, dass wir den korrekten Public-Key dieser Zertifikatsstelle besitzen. 
Die Public-Keys aller Y werden dann von dieser Zertifikats-Stelle geprüft, und mit ihrem Private-Key signiert.

Wenn wir nun einen Public-Key von Y bekommen, dann schauen wir, ob dieser von einer Zertifikatsstelle, welcher wir vertrauen signiert wurde. 
Mittels deren Public-Key können wir das, das Prinzipt ist genau gleich. Und wenn das so ist, dann akzeptieren wir den Public-Key als gültig.

Die Public-Keys aller Zertifikatsstellen welchen wir vertrauen sind in Java der Trust-Store.

 
### Keystore ###

Im Keystore hingegen hinterlegen wir unsere eigenen Keys.
Ob es ein *.pem oder ein *.jks File ist dabei nur ein anderes Format.

 
