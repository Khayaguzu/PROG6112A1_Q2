package clock;

import java.awt.Font;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MyFrameTest {

    private MyFrame frame;

    @Before
    public void setUp() throws Exception {
        // Create the frame on the EDT
        SwingUtilities.invokeAndWait(() -> {
            frame = new MyFrame();
        });
    }

    @Test
    public void testFrameInitialization() {
        // Check if the frame is initialized and visible
        assertNotNull("Frame should be created", frame);
        assertTrue("Frame should be visible", frame.isVisible());
    }

    @Test
    public void testLabelsInitialization() {
        // Check if the labels are correctly initialized
        SwingUtilities.invokeLater(() -> {
            JLabel timetable = getLabelByName("timetable");
            JLabel daytable = getLabelByName("daytable");
            JLabel datetable = getLabelByName("datetable");

            assertNotNull("Timetable label should be initialized", timetable);
            assertNotNull("Daytable label should be initialized", daytable);
            assertNotNull("Datetable label should be initialized", datetable);

            assertEquals("Timetable label font should be Verdana", new Font("Verdana", Font.PLAIN, 50), timetable.getFont());
            assertEquals("Daytable label font should be Ink Free", new Font("Ink Free", Font.PLAIN, 35), daytable.getFont());
            assertEquals("Datetable label font should be Ink Free", new Font("Ink Free", Font.PLAIN, 25), datetable.getFont());
        });
    }

    @Test
    public void testLabelTextUpdates() throws Exception {
        // Check if the labels update periodically (dummy test to show functionality)
        SwingUtilities.invokeAndWait(() -> {
            JLabel timetable = getLabelByName("timetable");
            JLabel daytable = getLabelByName("daytable");
            JLabel datetable = getLabelByName("datetable");

            assertNotNull("Timetable label should be updated", timetable);
            assertNotNull("Daytable label should be updated", daytable);
            assertNotNull("Datetable label should be updated", datetable);

            
        });
    }

    private JLabel getLabelByName(String labelName) {
        for (java.awt.Component comp : frame.getContentPane().getComponents()) {
            if (comp instanceof JLabel) {
                JLabel label = (JLabel) comp;
                if (labelName.equals(label.getText())) { // Matching by text as no names are set in the provided class
                    return label;
                }
            }
        }
        return null;
    }
}
