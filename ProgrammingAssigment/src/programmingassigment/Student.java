package programmingassigment;

import java.util.ArrayList;

/**
 * Class representing a student with various details. Includes methods for
 * managing student records.
 */
public class Student
{
    // Private member variables to store student details
    private String id;
    private String name;
    private int age;
    private String course;
    private String email;

    // Constructor to initialize a Student object with provided details
    public Student(String id, String name, int age, String course, String email)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
    }

    // Getters for student details
    public String getEmail()
    {
        return email;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getCourse()
    {
        return course;
    }

    // Setters for student details
    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }

    /**
     * Method to add a new student to the list.
     *
     * @param students the list of students to which the new student will be added
     * @param id       the student's ID
     * @param name     the student's name
     * @param age      the student's age
     * @param course   the course the student is enrolled in
     * @param email    the student's email address
     */
    public static void saveStudent(ArrayList<Student> students, String id, String name, int age, String course, String email)
    {
        students.add(new Student(id, name, age, course, email));
        System.out.println("Student details saved successfully!");
    }

    /**
     * Method to search for a student by ID.
     *
     * @param students the list of students to search in
     * @param id       the ID of the student to search for
     * @return the student with the given ID, or null if not found
     */
    public static Student searchStudent(ArrayList<Student> students, String id)
    {
        for (Student student : students)
        {
            if (student.getId().equals(id))
            {
                return student;
            }
        }

        return null;
    }

    /**
     * Method to delete a student by ID.
     *
     * @param students the list of students from which the student will be deleted
     * @param id       the ID of the student to delete
     * @param confirmation confirmation to delete the student
     */
    public static boolean deleteStudent(ArrayList<Student> students, String id, String confirmation)
    {
        Student studentToRemove = null;

        for (Student student : students)
        {
            if (student.getId().equals(id))
            {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null)
        {
            if (confirmation.equalsIgnoreCase("yes"))
            {
                students.remove(studentToRemove);
                System.out.println("Student deleted successfully!");
                return true;
            }
            else
            {
                System.out.println("Student deletion cancelled.");
                return false;
            }
        }
        else
        {
            System.out.println("Student not found.");
            return false;
        }
    }

    /**
     * Method to generate a report of all students.
     *
     * @param students the list of students to generate the report for
     */
    public static void studentReport(ArrayList<Student> students)
    {
        System.out.println("Student Report:");
        int count = 1;

        for (Student student : students)
        {
            System.out.println();
            System.out.println("STUDENT " + count);
            System.out.println("-------------------------------------------");
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Course: " + student.getCourse());
            System.out.println("Email: " + student.getEmail());
            System.out.println("-------------------------------------------");
            count++;
        }
    }

    /**
     * Method to exit the application.
     */
    public static void exitStudentApplication()
    {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }

    /**
     * Helper method to get and validate student age.
     *
     * @param age the age of the student
     * @return a valid student age (16 or above)
     */
    public static int validateAge(int age)
    {
        if (age >= 16)
        {
            return age;
        }
        else
        {
            throw new IllegalArgumentException("Invalid age. Please enter a valid age (16 or above) >>");
        }
    }
}
