import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Bai2 {

    public static void main(String[]agrs) {
        JFrame frame = new JFrame("Welcome");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
         JOptionPane.showMessageDialog(frame, "Welcome to Java Swing");
 
        System.exit(0);
    }
}