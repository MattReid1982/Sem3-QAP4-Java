package SRC.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import SRC.Model.Patient;

public class DatabaseHandler {
    private static final String URL = "jdbc:postgresql://146.190.242.141/pharmacy_db";
    private static final String USER = "mattreid";
    private static final String PASSWORD = "BTi4MwUp8x";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Insert a patient into the database
    public static void insertPatient(Patient p) {
        String sql = "INSERT INTO patients (patient_id, first_name, last_name, dob) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, p.getPatientId());
                stmt.setString(2, p.getFirstName());
                stmt.setString(3, p.getLastName());
                stmt.setString(4, p.getDob());

                stmt.executeUpdate();
                System.out.println("Patient saved to database.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    // Read all patients from the database
    public static void readPatients() {
        String sql = "SELECT * FROM patients";
        try (Connection con = connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
                System.out.println("Patient List:");
                while (rs.next()) {
                    System.out.println(
                        rs.getInt("patient_id") + " | " + 
                        rs.getString("first_name") + " | " +
                        rs.getString("last_name") + " | " +
                        rs.getString("dob")
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
