/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khanbantasks;

class Task {
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private double taskDuration;
    private String taskID;
    private String taskStatus;

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskDuration(double taskDuration) {
        this.taskDuration = taskDuration;
    }
    

    public Task(String taskName, String taskDescription, String developerDetails, double taskDuration, String taskID, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" + "Developer Details: " + developerDetails + "\n" + "Task Number: " + (EasyKanban.taskCount - 1) + "\n" + "Task Name: " + taskName + "\n" + "Task Description: " + taskDescription + "\n" + "Task ID: " + taskID + "\n" + "Duration: " + taskDuration + " hours";
    }

    public double getTaskDuration() {
        return taskDuration;
    }
}
