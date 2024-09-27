import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ERQueue1 {

    static class Patient {
        String name;
        boolean isCritical;

        Patient(String name, boolean isCritical) {
            this.name = name;
            this.isCritical = isCritical;
        }
    }

    public static void main(String[] args) {
        Queue<Patient> patientQueue = new LinkedList<>();
        Queue<Patient> criticalQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter patient name (or type 'exit' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Is the patient critical? (yes/no): ");
            String criticalInput = scanner.nextLine();
            boolean isCritical = criticalInput.equalsIgnoreCase("yes");

            Patient patient = new Patient(name, isCritical);

            if (isCritical) {
                criticalQueue.add(patient);
            } else {
                patientQueue.add(patient);
            }
        }

        System.out.println("Processing patients...");

        // Process critical patients first
        while (!criticalQueue.isEmpty()) {
            Patient patient = criticalQueue.poll();
            System.out.println("Attending critical patient: " + patient.name);
        }

        // Process non-critical patients
        while (!patientQueue.isEmpty()) {
            Patient patient = patientQueue.poll();
            System.out.println("Attending patient: " + patient.name);
        }

        System.out.println("All patients have been attended.");
        scanner.close();
    }
}
