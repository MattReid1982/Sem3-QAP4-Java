package SRC.Model;
public class Drug {
    private int drugId;
    private String drugName;
    private double drugCost;
    private String dosage;

    public Drug(int drugId, String drugName, double drugCost, String dosage) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugCost = drugCost;
        this.dosage = dosage;
    }

    public String toFileString() {
        return drugId + "," + drugName + "," + drugCost + "," + dosage;
    }

    public static Drug fromString(String line) {
        String[] parts = line.split(",");
        return new Drug(Integer.parseInt(parts[0]),
        parts[1], 
        Double.parseDouble(parts[2]),
        parts[3]
        );
    }

    @Override
    public String toString() {
        return "Drug ID: " + drugId + ", Name: " + drugName + ", Cost: $" + drugCost + ", Dosage: " + dosage;
    }
}
