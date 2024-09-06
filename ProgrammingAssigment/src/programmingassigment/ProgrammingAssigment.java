package programmingassigment;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class for the student management application.
 */
public class ProgrammingAssigment
{
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Student> students = new ArrayList<>();

    /**
     * Main method to launch the application.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("*****************************************************");
        if (!launchMenu())
        {
            System.out.println("Exiting application!");
            System.exit(0);
        }

        while (true)
        {
            showMenu();
            int choice = getUserChoice();
            
            if (choice == -1)
            {
                continue; // Invalid choice, prompt again
            }

            switch (choice)
            {
                case 1:
                    captureNewStudent();
                    break;
                case 2:
                    searchForStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    viewStudentReport();
                    break;
                case 5:
                    System.out.println("Exiting application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Displays the main menu options.
     */
    private static void showMenu()
    {
        System.out.println("\nMenu:");
        System.out.println("1. Capture new student");
        System.out.println("2. Search for student");
        System.out.println("3. Delete student");
        System.out.println("4. View student report");
        System.out.println("5. Exit application");
    }

    /**
     * Prompts the user to enter a choice and validates the input.
     * 
     * @return the user's choice, or -1 if the input is invalid
     */
    private static int getUserChoice()
    {
        System.out.print("Enter your choice: ");
        try
        {
            return Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }

    /**
     * Prompts the user to launch the menu or exit the application.
     * 
     * @return true if the user chooses to launch the menu, false otherwise
     */
    private static boolean launchMenu()
    {
        System.out.print("ENTER (1) to launch the menu or any other key to exit: ");
        String input = scanner.nextLine();
        return input.equals("1");
    }

    /**
     * Captures a new student's details and adds them to the list.
     */
    private static void captureNewStudent()
    {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        int age = getValidAge();

        System.out.print("Enter student course: ");
        String course = scanner.nextLine();

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        Student.saveStudent(students, id, name, age, course, email);
    }

    /**
     * Gets a valid age input from the user.
     * 
     * @return the valid age
     */
    private static int getValidAge()
    {
        while (true)
        {
            System.out.print("Enter student age: ");
            try
            {
                int age = Integer.parseInt(scanner.nextLine());
                return Student.validateAge(age);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Searches for a student by ID and displays their details.
     */
    private static void searchForStudent()
    {
        System.out.print("Enter student ID to search: ");
        String id = scanner.nextLine();

        Student student = Student.searchStudent(students, id);

        if (student != null)
        {
            System.out.println("Student found:");
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Course: " + student.getCourse());
            System.out.println("Email: " + student.getEmail());
        }
        else
        {
            System.out.println("Student not found.");
        }
    }

    /**
     * Deletes a student by ID after confirmation.
     */
    private static void deleteStudent()
    {
        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine();

        System.out.print("Are you sure you want to delete this student? (yes/no): ");
        String confirmation = scanner.nextLine();

        boolean success = Student.deleteStudent(students, id, confirmation);

        if (success)
        {
            System.out.println("Student deleted successfully!");
        }
        else
        {
            System.out.println("Student deletion cancelled or failed.");
        }
    }

    /**
     * Displays a report of all students.
     */
    private static void viewStudentReport()
    {
        Student.studentReport(students);
    }
}
