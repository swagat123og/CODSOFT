package CODESOFT;
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Take number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // 2. Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
                int mark = scanner.nextInt();

                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    totalMarks += mark;
                    break;
                } else {
                    System.out.println("⚠️ Invalid input! Marks should be between 0 and 100.");
                }
            }
        }

        // 3. Calculate average percentage
        double average = (double) totalMarks / numSubjects;

        // 4. Determine grade
        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else if (average >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // 5. Display results
        System.out.println("\n📋--- RESULT ---");
        System.out.println("Total Marks: " + totalMarks + " / " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

