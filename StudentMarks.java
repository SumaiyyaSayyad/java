import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentMarks {
    private ArrayList<Double> grades = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Enter student grades (0-100). Type 'done' to finish:");
        collectGrades();
        displayResults();
    }

    private void collectGrades() {
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                double grade = scanner.nextDouble();
                if (grade >= 0 && grade <= 100) {
                    grades.add(grade);
                } else {
                    System.out.println("Invalid grade. Please enter a number between 0 and 100.");
                }
            } else {
                String input = scanner.next();
                if ("done".equalsIgnoreCase(input)) {
                    break;
                } else {
                    System.out.println("Invalid input. Type 'done' to finish or enter another grade.");
                }
            }
        }
    }

    private void displayResults() {
        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
            return;
        }
        Collections.sort(grades, Collections.reverseOrder());
        System.out.println("Grades from highest to lowest:");
        grades.forEach(grade -> System.out.printf("%.2f\n", grade));
        double average = grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        System.out.printf("Average grade: %.2f\n", average);
    }

    public static void main(String[] args) {
        new StudentMarks().run();
    }
}
