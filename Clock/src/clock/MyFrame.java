/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clock;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * MyFrame is a JFrame subclass that displays the current time, day, and date.
 * The time is updated every second.
 */
public class MyFrame extends JFrame {

    private Calendar calendar;
    private SimpleDateFormat timeFormat;
    private SimpleDateFormat dayFormat;
    private SimpleDateFormat dateFormat;
    private JLabel timetable;
    private JLabel daytable;
    private JLabel datetable;

    /**
     * Constructor to set up the frame.
     */
    public MyFrame() {
        // Frame setup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
        this.setResizable(false);

        // Initialize date formats
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd MMMMM yyyy");

        // Set up labels
        timetable = new JLabel();
        timetable.setFont(new Font("Verdana", Font.PLAIN, 50));
        timetable.setForeground(new Color(0x00FF00)); // Light green color
        timetable.setBackground(Color.black);
        timetable.setOpaque(true);

        daytable = new JLabel();
        daytable.setFont(new Font("Ink Free", Font.PLAIN, 35));

        datetable = new JLabel();
        datetable.setFont(new Font("Ink Free", Font.PLAIN, 25));

        // Add labels to frame
        this.add(timetable);
        this.add(daytable);
        this.add(datetable);

        // Make frame visible
        this.setVisible(true);

        // Start the time updating thread
        startTimeUpdating();
    }

    /**
     * Starts a thread that updates the time, day, and date every second.
     */
    private void startTimeUpdating() {
        // Create a new thread to handle time updates
        Thread timeUpdater = new Thread(() -> {
            while (true) {
                // Get current time, day, and date
                String time = timeFormat.format(Calendar.getInstance().getTime());
                String day = dayFormat.format(Calendar.getInstance().getTime());
                String date = dateFormat.format(Calendar.getInstance().getTime());

                // Update labels with current time, day, and date
                timetable.setText(time);
                daytable.setText(day);
                datetable.setText(date);

                // Sleep for 1 second before updating again
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Start the time updating thread
        timeUpdater.start();
    }
}
