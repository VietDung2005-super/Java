import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class Bai3PhuongTrinh {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Giai phuong trinh bac nhat");
        frame.setSize(400, 220);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        JLabel labelA = new JLabel("Nhap a:");
        JTextField textA = new JTextField();

        JLabel labelB = new JLabel("Nhap b:");
        JTextField textB = new JTextField();

        JButton buttonGiai = new JButton("Giai phuong trinh");
        JLabel labelKetQua = new JLabel("Ket qua:");

        panel.add(labelA);
        panel.add(textA);
        panel.add(labelB);
        panel.add(textB);
        panel.add(buttonGiai);
        panel.add(new JLabel());
        panel.add(labelKetQua);

        buttonGiai.addActionListener(e -> {
            try {
                double a = Double.parseDouble(textA.getText().trim());
                double b = Double.parseDouble(textB.getText().trim());

                if (a == 0 && b == 0) {
                    labelKetQua.setText("Ket qua: Phuong trinh co vo so nghiem");
                } else if (a == 0 && b != 0) {
                    labelKetQua.setText("Ket qua: Phuong trinh vo nghiem");
                } else {
                    double x = -b / a;
                    labelKetQua.setText("Ket qua: x = " + x);
                }
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