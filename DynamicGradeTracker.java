import java.util.ArrayList;
import java.util.Scanner;

public class DynamicGradeTracker {
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Grade Tracker!");
        System.out.println("Enter grades one by one. Type '-1' to finish.");

        while (true) {
            System.out.print("Enter grade (0-100 or -1 to stop): ");
            try {
                int grade = Integer.parseInt(scanner.nextLine());

                if (grade == -1) {
                    break;
                } else if (grade >= 0 && grade <= 100) {
                    grades.add(grade);
                } else {
                    System.out.println("Invalid grade! Please enter a number between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades were entered.");
            return;
        }

    
        int sum = 0, max = grades.get(0), min = grades.get(0);
        for (int grade : grades) {
            sum += grade;
            if (grade > max) max = grade;
            if (grade < min) min = grade;
        }

        double average = (double) sum / grades.size();

        System.out.println("\nGrade Statistics:");
        System.out.println("Number of grades: " + grades.size());
        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + max);
        System.out.println("Lowest grade: " + min);
    }
}
