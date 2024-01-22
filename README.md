# Precondizioni
- Essere a disposizione dei file .java delle classi sotto test e delle classi di test
- Scaricare i seguenti file:

  1. **evosuite-1.2.0.jar**
  2. **evosuite-standalone-runtime-1.2.0.jar**

- Avere maven installato

- Avere una versione di java 8

- Quando vengono importati i file .java all'interno del progetto maven, bisogna seguire la seguente struttura, es.

  - `src/main/java/ClassUnderTest/` (per le classi sotto test)
  - `src/test/java/[NomeClasseUnderTest]/[student; randoop; EvoSuiteTest]/[nomeCognomeX; level0X; Level0X]/` (per le classi di test generate da studenti o dai robot)

- Bisogna fare attenzione al nome dei package presenti nelle classi di test (essi vengono importati e il nome andrà modificato con quello corretto)

- Inoltre le classi di test devono importare correttamente la classe sotto test giusta

# Guida all'uso 
- Una volta importati i file .java nel progetto maven, la compilazione dovrebbe essere automatica (si può controllare se sono presenti i file .class appropiati all'interno di target/classes e target/test-classes). Se non sono presenti allora utilizzare il comando:
  `mvn compile`

- Far partire il main che assicura che ogni test suite presente sia eseguita, misurando in modo appropiato le metriche di line coverage e weak mutation di EvoSuite, organizzando i file contenenti i risultati in cartelle con nomi riconducibili al produttore della test suite.

# Limitazioni 
- Putroppo EvoSuite non è ancora compatibile con i test scritti utilizzando JUnit 5, ma arriva fino a JUnit 4. Questo è stato un grande problema siccome gli studenti che hanno realizzato le test suite per le classi assegnate, hanno usato l'ultima versione di JUnit; al fine di fare un analisi per confrontare chi avesse prodotto test migliori tra studenti e robot, sono stati modificati pezzi di codice degli studenti.
