import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ERQueue2 {

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
        processQueue(criticalQueue, "critical");

        // Process non-critical patients
        processQueue(patientQueue, "non-critical");

        System.out.println("All patients have been attended.");
        scanner.close();
    }

    public static void processQueue(Queue<Patient> queue, String type) {
        while (true) {
            if (queue.isEmpty()) {
                System.out.println("No more " + type + " patients in the queue.");
                break;
            } else {
                Patient patient = queue.poll();
                System.out.println("Attending " + type + " patient: " + patient.name);
            }
        }
    }
}
