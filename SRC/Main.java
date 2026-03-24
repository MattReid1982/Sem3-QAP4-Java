package SRC;

import java.util.Scanner;
import SRC.Model.Drug;
import SRC.Model.Patient;
import SRC.db.DatabaseHandler;
import SRC.file.FileHandler;
public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int choice;

        do{
            System.out.println("\n--- Menu ---");
            System.out.println("1. Save Drug to File");
            System.out.println("2. Read Drugs from File");
            System.out.println("3. Save Patient to Database");
            System.out.println("4. Read Patients from Database");
            System.out.println("0. Exit");
            System.out.println("Enter Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Drug ID: "); // Must be an integer not a string.
                    int dId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Drug Name: "); 
                    String dName = scanner.nextLine();

                    System.out.print("Enter Drug Cost: ");
                    double dCost = scanner.nextDouble();
                    scanner.nextLine();

                    if (dCost < 0) {
                        System.out.println("Cost cannot be a negative value.");
                        break;
                    }

                    System.out.print("Enter Dosage: ");
                    String dosage = scanner.nextLine();

                    Drug drug = new Drug(dId, dName, dCost, dosage);
                    FileHandler.saveDrug(drug);
                    break;

                case 2:
                    FileHandler.readDrugs();
                    break;
                
                case 3: 
                    System.out.print("Enter Patient ID: ");
                    int pId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter First Name: ");
                    String first = scanner.nextLine();

                    System.out.print("Enter Last Name: ");
                    String last = scanner.nextLine();

                    System.out.print("Enter DOB: ");
                    String dob = scanner.nextLine();
                    
                    Patient patient = new Patient(pId, first, last, dob);
                    DatabaseHandler.insertPatient(patient);
                    break;

                case 4:
                    DatabaseHandler.readPatients();
                    break;
                
                case 0: 
                    System.out.println("Exiting Program...");
                    break;
                
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
        } while (choice != 0);

        scanner.close();
    }
}
