/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package khanbantasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class EasyKanbanTest {
    
    public EasyKanbanTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class EasyKanban.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        EasyKanban.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class EasyKanban.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        EasyKanban.login();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mainMenu method, of class EasyKanban.
     */
    @Test
    public void testMainMenu() {
        System.out.println("mainMenu");
        int expResult = 0;
        int result = EasyKanban.mainMenu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTask method, of class EasyKanban.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        EasyKanban.addTask();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTaskID method, of class EasyKanban.
     */
    @Test
    public void testCreateTaskID() {
        System.out.println("createTaskID");
        String taskName = "";
        String developerDetails = "";
        String expResult = "";
        String result = EasyKanban.createTaskID(taskName, developerDetails);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showReport method, of class EasyKanban.
     */
    @Test
    public void testShowReport() {
        System.out.println("showReport");
        EasyKanban.showReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showTasks method, of class EasyKanban.
     */
    @Test
    public void testShowTasks() {
        System.out.println("showTasks");
        EasyKanban.showTasks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
