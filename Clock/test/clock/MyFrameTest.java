package clock;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class MyFrameTest {

    private MyFrame frame;

    @Before
    public void setUp() {
        // Initialize the MyFrame instance
        frame = new MyFrame();
    }

    @Test
    public void testLabelInitialization() {
        // Check if the labels are properly initialized
        assertNotNull("Timetable label should not be null", frame.timetable);
        assertNotNull("Daytable label should not be null", frame.daytable);
        assertNotNull("Datetable label should not be null", frame.datetable);
    }

    @Test
    public void testLabelProperties() {
        // Check if the timetable label has the correct font and color
        Font expectedFont = new Font("Verdana", Font.PLAIN, 50);
        assertEquals("Timetable label font should be 'Verdana', PLAIN, 50", expectedFont, frame.timetable.getFont());

        // Check if the timetable label has the correct foreground color
        Color expectedColor = new Color(0x00FF00);
        assertEquals("Timetable label color should be green", expectedColor, frame.timetable.getForeground());

        // Check if the daytable and datetable labels have the correct fonts
        assertEquals("Daytable label font should be 'Ink Free', PLAIN, 35", new Font("Ink Free", Font.PLAIN, 35), frame.daytable.getFont());
        assertEquals("Datetable label font should be 'Ink Free', PLAIN, 25", new Font("Ink Free", Font.PLAIN, 25), frame.datetable.getFont());
    }

    @Test
    public void testUpdateLabels() {
        // Ensure labels are updated correctly
        frame.updateLabels();
        assertNotNull("Timetable label text should be updated", frame.timetable.getText());
        assertNotNull("Daytable label text should be updated", frame.daytable.getText());
        assertNotNull("Datetable label text should be updated", frame.datetable.getText());
    }

    @Test
    public void testUpdateLabelsWithinTime() throws InterruptedException {
        // Verify that the updateLabels method is called periodically
        frame.updateLabels();
        Thread.sleep(2000); // Sleep to allow time for label update
        String previousTime = frame.timetable.getText();
        frame.updateLabels();
        String currentTime = frame.timetable.getText();
        assertNotEquals("Time should be updated", previousTime, currentTime);
    }
}
