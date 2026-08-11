import javax.swing.JButton;
import javax.swing.JFrame;

public class Bai3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exit Button App");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));

        frame.add(exitButton);
        frame.setVisible(true);
    }
}