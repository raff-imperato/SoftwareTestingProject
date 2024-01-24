import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class DataTest {
    private String classUT; //nome della classe sotto test
    private String nomeTester; //nome del tester
    private String categoria; //nome della categoria (es. student, randoop, EvoSuiteTest)

    private CoverageEvoSuite coverageEvoSuite;
    private CoverageJaCoCo coverageJaCoCo;

    public DataTest(String classUT, String nomeTester, String categoria, CoverageEvoSuite coverageEvoSuite, CoverageJaCoCo coverageJaCoCo) {
        this.classUT = classUT;
        this.nomeTester = nomeTester;
        this.categoria = categoria;
        this.coverageEvoSuite = coverageEvoSuite;
        this.coverageJaCoCo = coverageJaCoCo;
    }

    public String getClassUT() {
        return classUT;
    }

    public void setClassUT(String classUT) {
        this.classUT = classUT;
    }

    public String getNomeTester() {
        return nomeTester;
    }

    public void setNomeTester(String nomeTester) {
        this.nomeTester = nomeTester;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public CoverageEvoSuite getCoverageEvoSuite() {
        return coverageEvoSuite;
    }

    public void setCoverageEvoSuite(CoverageEvoSuite coverageEvoSuite) {
        this.coverageEvoSuite = coverageEvoSuite;
    }

    public CoverageJaCoCo getCoverageJaCoCo() {
        return coverageJaCoCo;
    }

    public void setCoverageJaCoCo(CoverageJaCoCo coverageJaCoCo) {
        this.coverageJaCoCo = coverageJaCoCo;
    }
    
    public static void sortByWeakMutation(ArrayList<DataTest> testSuites) {
        Collections.sort(testSuites, new Comparator<DataTest>() {
            @Override
            public int compare(DataTest dt1, DataTest dt2) {
                double wm1 = dt1.getCoverageEvoSuite().getWeakMutation();
                double wm2 = dt2.getCoverageEvoSuite().getWeakMutation();
                return Double.compare(wm1, wm2);
            }
        });
    }

    public static void sortByInstructionCoverage(ArrayList<DataTest> testSuites) {
        Collections.sort(testSuites, new Comparator<DataTest>() {
            @Override
            public int compare(DataTest dt1, DataTest dt2) {
                double ic1 = dt1.getCoverageJaCoCo().getInstructionCoverage();
                double ic2 = dt2.getCoverageJaCoCo().getInstructionCoverage();
                return Double.compare(ic1, ic2);
            }
        });
    }
    
}