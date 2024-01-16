package entity;

public class DataTest {
    private String name;
    private String instructionCoverage;
    private float weakMutation;
    private String classUT;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getInstructionCoverage() {
        return instructionCoverage;
    }
    public void setInstructionCoverage(String instructionCoverage) {
        this.instructionCoverage = instructionCoverage;
    }
    public float getWeakMutation() {
        return weakMutation;
    }
    public void setWeakMutation(float weakMutation) {
        this.weakMutation = weakMutation;
    }
    public String getClassUT() {
        return classUT;
    }
    public void setClassUT(String classUT) {
        this.classUT = classUT;
    }

    public DataTest(String name, String instructionCoverage, float weakMutation, String classUT) {
        this.name = name;
        this.instructionCoverage = instructionCoverage;
        this.weakMutation = weakMutation;
        this.classUT = classUT;
    }
}
