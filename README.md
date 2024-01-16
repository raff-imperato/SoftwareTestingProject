# Scopo del progetto

Lo scopo del progetto è di confrontare diverse classi di test. In particolare, per ogni classe si possono avere a disposizione:

- da una a tre classi di test generate da Randoop;
- da una a tre classi di test generate da Evosuite;
- da una a quattro classi di test generate da studenti.

Dall'analisi dei report sulla copertura, per ora soltanto ottenuta dalla metrica Instruction Coverage di JaCoCo, viene valutato se gli studenti si sono comportati meglio dei singoli test di Randoop o Evosuite.

# Configurazione

- Il sistema operativo utilizzato per sviluppare tale progetto è Ubuntu nella versione 22.04 LTS;
- per Java è stata utilizzata la versione 21 del JDK;
- per JUnit è stata utilizzata la versione 5;
- come IDE è stato utilizzato IntelliJ Idea;
- sono stati scaricati dalla libreria di JaCoCo i file .jar di jacocoagent e jacococli;
- inoltre è stata utilizzata la libreria di Jsoup che è stata aggiunta al classpath del progetto (utilizzata per leggere il file di report "index.html").

# Per il funzionamento

Bisogna avere a disposizione la directory contenente i file .class della classe e delle classi di test (organizzati in cartelle possibilmente).
Si genera un file .jar con il contenuto della directory citata, il comando ubuntu utilizzato è il seguente:

`jar cvf NomeClasseUnderTest.jar *`

Una volta fatto questo si può avviare il main di "InstructionCoverageUtil.java" che presenta un menù che consente di fare tre operazioni:

1) Eseguire e generare le coperture con JaCoCO;
2) Visualizzare i risultati sotto forma di tabella;
3) Uscire dal programma.

Al programma vanno forniti i percorsi relativi a:

- jacocoagent.jar
- jacococli.jar
- junit-platform-console-standalone.jar
- percorso del progetto contentente i .class e il file .jar contentente i .class (stessa directory)
- percorso per il file di report index.html

# Esempio con video

https://github.com/raff-imperato/SoftwareTestingProject/assets/115695791/05acef24-1ac2-4c86-8822-1ee3518f9fb7





