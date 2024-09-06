




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
 *
 * @author RC_Student_lab
 */
public class MyFrame extends JFrame {
    
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timetable;
    JLabel daytable;
    JLabel datetable;
    String time;
    String day;
    String date;
    public MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(350,200);
        this.setResizable(false);
        this.setVisible(true);
        
         timeFormat= new SimpleDateFormat("hh:mm:ss a");
         dayFormat= new SimpleDateFormat("EEEE");
         dateFormat= new SimpleDateFormat("dd MMMMM yyyy");
        
        timetable = new JLabel();
        timetable.setFont(new Font("Verdana", Font.PLAIN,50));
        timetable.setForeground(new Color(0x00FF00));
        timetable.setBackground(Color.black);
        timetable.setOpaque(true);
        
        time = timeFormat.format(Calendar.getInstance().getTime());
        timetable.setText(time);
        
        daytable = new JLabel();
        daytable.setFont(new Font("Ink Free", Font.PLAIN,35));
        
        datetable = new JLabel();
        daytable.setFont(new Font("Ink Free", Font.PLAIN,25));
        
        
        
        this.add(timetable);
        this.add(daytable);
        this.add(datetable);
        this.setVisible(true);
        setTime();
    }
    public void setTime(){
        while(true){
        time = timeFormat.format(Calendar.getInstance().getTime());
        timetable.setText(time);   
        
        day = dayFormat.format(Calendar.getInstance().getTime());
        daytable.setText(day);
        
        date = dateFormat.format(Calendar.getInstance().getTime());
        datetable.setText(date);   
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
}


