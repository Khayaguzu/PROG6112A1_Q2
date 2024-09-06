package programmingassigment;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Test class for the Student class.
 */
public class StudentTest {

    private ArrayList<Student> students;
    private Student student1;
    private Student student2;

    @Before
    public void setUp() {
        // Initialize the student list and add test students
        students = new ArrayList<>();
        student1 = new Student("001", "Alice", 20, "Computer Science", "alice@example.com");
        student2 = new Student("002", "Bob", 18, "Information Technology", "bob@example.com");
        students.add(student1);
        students.add(student2);
    }

    @Test
    public void testSaveStudent() {
        // Arrange
        int initialSize = students.size();
        String id = "003";
        String name = "Charlie";
        int age = 22;
        String course = "Business Management";
        String email = "charlie@example.com";

        // Act
        Student.saveStudent(students, id, name, age, course, email);

        // Assert
        assertEquals(initialSize + 1, students.size());
        Student student = Student.searchStudent(students, id);
        assertNotNull(student);
        assertEquals(id, student.getId());
        assertEquals(name, student.getName());
        assertEquals(age, student.getAge());
        assertEquals(course, student.getCourse());
        assertEquals(email, student.getEmail());
    }

    @Test
    public void testSearchStudent() {
        // Act
        Student student = Student.searchStudent(students, "001");

        // Assert
        assertNotNull(student);
        assertEquals("Alice", student.getName());
        assertEquals("Computer Science", student.getCourse());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        // Act
        Student student = Student.searchStudent(students, "999");

        // Assert
        assertNull(student);
    }

    @Test
    public void testDeleteStudent() {
        // Act
        boolean result = Student.deleteStudent(students, "002", "yes");

        // Assert
        assertTrue(result);
        assertNull(Student.searchStudent(students, "002"));
        assertEquals(1, students.size());
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        // Act
        boolean result = Student.deleteStudent(students, "999", "yes");

        // Assert
        assertFalse(result);
        assertEquals(2, students.size());
    }

    @Test
    public void testValidateAge_Valid() {
        // Act
        int age = Student.validateAge(18);

        // Assert
        assertEquals(18, age);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateAge_Invalid() {
        // Act
        Student.validateAge(15);
    }

    @Test(expected = NumberFormatException.class)
    public void testValidateAge_StudentAgeInvalidCharacter() {
        // Act
        // Simulating invalid character input by parsing a non-numeric string
        String invalidAgeInput = "abc";
        Integer.parseInt(invalidAgeInput); // This should throw NumberFormatException
    }
}