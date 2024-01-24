public class CoverageJaCoCo {
    //i due valori sono presi in percentuale e arrotondati a due cifre decimali
    private double instructionCoverage;
    private double lineCoverage;

    public double getInstructionCoverage() {
        return instructionCoverage;
    }

    public void setInstructionCoverage(double instructionCoverage) {
        this.instructionCoverage = instructionCoverage;
    }

    public double getLineCoverage() {
        return lineCoverage;
    }

    public void setLineCoverage(double lineCoverage) {
        this.lineCoverage = lineCoverage;
    }

    public CoverageJaCoCo(double instructionCoverage, double lineCoverage) {
        this.instructionCoverage = instructionCoverage;
        this.lineCoverage = lineCoverage;
    }
    
}
