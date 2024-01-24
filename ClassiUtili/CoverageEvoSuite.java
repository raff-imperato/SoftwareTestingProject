public class CoverageEvoSuite {
    //i due valori sono presi in percentuale e arrotondati a due cifre decimali
    private double weakMutation;
    private double lineCoverage;

    public double getWeakMutation() {
        return weakMutation;
    }

    public void setWeakMutation(double weakMutation) {
        this.weakMutation = weakMutation;
    }

    public double getLineCoverage() {
        return lineCoverage;
    }

    public void setLineCoverage(double lineCoverage) {
        this.lineCoverage = lineCoverage;
    }

    public CoverageEvoSuite(double weakMutation, double lineCoverage) {
        this.weakMutation = weakMutation;
        this.lineCoverage = lineCoverage;
    }

}
