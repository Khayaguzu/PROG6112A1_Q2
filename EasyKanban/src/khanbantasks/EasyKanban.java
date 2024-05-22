
package khanbantasks;

import javax.swing.JOptionPane;

public class EasyKanban {
    static int totalHours = 0;
    static int taskCount = 0;
    static Task[] tasks = new Task[100]; // Array to store tasks

    public static void main(String[] args) {
        // Display welcome message
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // Login
        login();

        // Menu
        int choice;
        do {
            choice = mainMenu();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    showReport();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Exiting EasyKanban");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    static void login() {
        // Dummy login function
        // For demonstration purposes, let's assume successful login
        JOptionPane.showMessageDialog(null, "Login successful!");
    }

    static int mainMenu() {
        String menu = "Choose an option:\n" + "1. Add tasks\n" + "2. Show report\n" + "3. Quit";
        String input = JOptionPane.showInputDialog(menu);
        return Integer.parseInt(input);
    }

    static void addTask() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter task description:");
            if (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                continue;
            }
            String developerDetails = JOptionPane.showInputDialog("Enter details (First Name & Last Name):");
            double taskDuration = Double.parseDouble(JOptionPane.showInputDialog("Enter task duration in hours:"));
            String taskID = createTaskID(taskName, developerDetails);
            String[] options = {"To do", "Doing", "Done"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Choose task status:", "Task Status",
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskID, taskStatus);
            tasks[taskCount] = task; // Store the task in the array
            totalHours += task.getTaskDuration();
            taskCount++;
            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }
        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }

    static String createTaskID(String taskName, String developerDetails) {
        String[] names = developerDetails.split(" ");
        String initials = taskName.substring(0, 2).toUpperCase() + ":" + taskCount + ":" + names[0].substring(0, 3).toUpperCase();
        return initials;
    }

    static void showReport() {
        JOptionPane.showMessageDialog(null, "Coming soon...", "Display", JOptionPane.INFORMATION_MESSAGE);
    }

    static void showTasks() {
        String report = "";
        for (int i = 0; i < taskCount; i++) {
            report += "Task " + (i + 1) + ":\n"; 
            
            
            report += tasks[i].printTaskDetails() + "\n";
        }
        JOptionPane.showMessageDialog(null, report);
    }
}

