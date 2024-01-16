package entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class InstructionCoverageUtil {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        String JACOCO_PATH = "/home/raff/IdeaProjects/ProgettoSoftwareTesting/jacocoagent.jar";

        String JACOCO_CLI_PATH = "/home/raff/IdeaProjects/ProgettoSoftwareTesting/jacococli.jar";

        String JUNIT_PATH = "/usr/share/java/junit-platform-console-standalone.jar";

        int option = 0;

        while (option != 3) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Esegui e genera le coperture con Jacoco");
            System.out.println("2. Visualizza i risultati");
            System.out.println("3. Esci dal programma");

            option = scan.nextInt();

            scan.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Inserisci il percorso per i file .class: ");
                    String CLASS_PATH = scan.nextLine();

                    System.out.println("Inserisci il percorso per la destinazione dei file di report: ");
                    String REPORT= scan.nextLine();

                    System.out.println("Eseguo i test...");
                    executeTest(JUNIT_PATH, CLASS_PATH, JACOCO_PATH);

                    System.out.println("Ottengo la copertura dei test con JaCoCo...");
                    executeReport(CLASS_PATH, JACOCO_CLI_PATH, REPORT);
                    break;
                case 2:
                    ArrayList<DataTest> tests = new ArrayList<DataTest>();

                    System.out.println("Inserisci il nome della classe sotto test: ");
                    String classUT = scan.nextLine();

                    System.out.println("Inserisci il percorso per il file di report index.html della classe: ");
                    String fileReport = scan.nextLine();

                    getRis(fileReport, tests, classUT);

                    printDataTests(tests, classUT);
                    break;
                case 3:
                    System.out.println("Stai uscendo dal programma.");
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
                    break;
            }
        }
        scan.close();
    }

    public static void executeTest(String JUNIT_PATH, String CLASS_PATH, String JACOCO_PATH) {
        try {
            String[] command = {
                    "java",
                    "-javaagent:" + JACOCO_PATH + "=destfile=jacoco.exec",
                    "-jar",
                    JUNIT_PATH,
                    "--class-path",
                    CLASS_PATH,
                    "--scan-class-path"
            };

            executeCommand(command);
        } catch (IOException | InterruptedException e) {
            //e.printStackTrace();
        }
    }

    public static void executeReport(String CLASS_PATH, String JACOCO_CLI_PATH, String REPORT) {
        try {
            String[] command = {
                    "java",
                    "-jar",
                    JACOCO_CLI_PATH,
                    "report",
                    "jacoco.exec",
                    "--classfiles",
                    CLASS_PATH,
                    "--html",
                    REPORT
            };

            executeCommand(command);
        } catch (IOException | InterruptedException e) {
            //e.printStackTrace();
        }
    }

    private static void executeCommand(String[] command) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            //System.out.println(line);
        }

        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String errorLine;
        while ((errorLine = errorReader.readLine()) != null) {
            //System.err.println(errorLine);
        }

        int exitCode = process.waitFor();
        //System.out.println("\nEsito del comando: " + exitCode);
    }

    public static void getRis(String fileReport, ArrayList<DataTest> tests, String classUT)
    {
        File input = new File(fileReport);
        try {
            Document doc = Jsoup.parse(input, "UTF-8");
            Elements rows = doc.select("tr");

            int rowIndex = 0;
            for (Element row : rows) {
                if (rowIndex++ < 2) {
                    continue;  // Salta le prime due righe
                }

                Elements columns = row.select("td");
                if (columns.size() > 0) {
                    if(!columns.get(0).text().equals("ClassUnderTest"))
                    {
                        String elementName = columns.get(0).text();
                        String coveragePercentage = columns.get(2).text();
                        double percentuale = Double.parseDouble(coveragePercentage.replaceAll("[^0-9]", ""));
                        DataTest temp = new DataTest(elementName, percentuale, 0, classUT);
                        tests.add(temp);
                    }

                }
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public static void printDataTests(ArrayList<DataTest> tests, String classUt) {
        System.out.println("Per la classe " + classUt + " sono stati ottenuti i seguenti risultati:");
        System.out.println(String.format("%30s %10s %20s %7s", "Name", "|", "InstructionCoverage (%)", "|"));
        System.out.println(String.format("%s", "-------------------------------------------------------------------------"));
        for (DataTest test : tests) {
            System.out.println(String.format("%30s %10s %20s %10s", test.getName(), "|", test.getInstructionCoverage(), "|"));
        }
        System.out.println("");
        }

    }


