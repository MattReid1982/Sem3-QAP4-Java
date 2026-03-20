package SRC.Model;

public class Patient {
    private int patientId;
    private String firstName;
    private String lastName;
    private String dob;

    public Patient(int patientId, String firstName, String lastName, String dob) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    // Getters 
    public int getPatientId() { return patientId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDob() { return dob; }
}
