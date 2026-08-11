import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class Bai2Lab3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tinh tong hai so");
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        JLabel labelA = new JLabel("So thu nhat:");
        JTextField textA = new JTextField();

        JLabel labelB = new JLabel("So thu hai:");
        JTextField textB = new JTextField();

        JButton buttonTinh = new JButton("Tinh tong");
        JLabel labelKetQua = new JLabel("Ket qua:");

        panel.add(labelA);
        panel.add(textA);
        panel.add(labelB);
        panel.add(textB);
        panel.add(buttonTinh);
        panel.add(new JLabel());
        panel.add(labelKetQua);

        buttonTinh.addActionListener(e -> {
            try {
                double a = Double.parseDouble(textA.getText().trim());
                double b = Double.parseDouble(textB.getText().trim());
                double tong = a + b;
                labelKetQua.setText("Ket qua: " + tong);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Vui long nhap so hop le!",
                        "Loi nhap lieu",
                        JOptionPane.ERROR_MESSAGE);
                labelKetQua.setText("Ket qua:");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}