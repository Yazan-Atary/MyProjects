import java.util.Stack;

public class Sort {
    public static int calculateDays(double newDose, Stack<Double> doseStack) {
        if (newDose <= 0) {
            return 0;
        } else {
            doseStack.push(newDose);
            int days = 1 + calculateDays(newDose - 0.35 * 700, doseStack);
            double poppedDose = doseStack.pop();
            System.out.println("Popped dose: " + poppedDose);
            return days;
        }
    }

    public static void main(String[] args) {
        Stack<Double> doseStack = new Stack<>();
        System.out.println("Total number of days required to kill bacteria is " + calculateDays(700, doseStack));
    }
}
