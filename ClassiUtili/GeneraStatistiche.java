import java.util.ArrayList;

public class GeneraStatistiche {
    

    public static void printIC(ArrayList<DataTest> dataTests, String classUT) {
        DataTest.sortByInstructionCoverage(dataTests);
        System.out.printf("%-20s %-20s %-20s%n", "Categoria", "NomeTester", "InstructionCoverage");
        for(DataTest d : dataTests) {
            if(d.getClassUT().equals(classUT)) {
                System.out.printf("%-20s %-20s %-20.2f%n", d.getCategoria() , " " + d.getNomeTester() , " " , d.getCoverageJaCoCo().getInstructionCoverage());
            }
        }
    }

    public static void printWM(ArrayList<DataTest> dataTests, String classUT) {
        DataTest.sortByWeakMutation(dataTests);
        System.out.printf("%-20s %-20s %-20s%n", "Categoria", "NomeTester", "WeakMutation");
        for(DataTest d : dataTests) {
            if(d.getClassUT().equals(classUT)) {
                System.out.printf("%-20s %-20s %-20.2f%n", d.getCategoria() , " " + d.getNomeTester() , " " , d.getCoverageEvoSuite().getWeakMutation());
            }
        }
    }

    public static void printLC(ArrayList<DataTest> dataTests, String classUT) {
        System.out.printf("%-20s %-20s %-20s %-20s%n", "Categoria", "NomeTester", "LineCoverageJaCoCo", "LineCoverageEvoSuite");
        for(DataTest d : dataTests) {
            if(d.getClassUT().equals(classUT)) {
                System.out.printf("%-20s %-20s %-20.2f %-20.2f%n", d.getCategoria(), d.getNomeTester(), d.getCoverageJaCoCo().getLineCoverage(), d.getCoverageEvoSuite().getLineCoverage());
            }
        }
    }
    
}
