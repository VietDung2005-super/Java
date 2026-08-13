import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Bai5Fibonacci {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Day Fibonacci");
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelTren = new JPanel(new FlowLayout());
        JLabel labelN = new JLabel("Nhap n:");
        JTextField textN = new JTextField(10);
        JButton buttonHienThi = new JButton("Hien thi");

        panelTren.add(labelN);
        panelTren.add(textN);
        panelTren.add(buttonHienThi);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        buttonHienThi.addActionListener(e -> {
            try {
                int n = Integer.parseInt(textN.getText().trim());
                if (n <= 0) {
                    JOptionPane.showMessageDialog(frame,
                            "n phai la so nguyen duong!",
                            "Loi nhap lieu",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                long truoc = 0, sau = 1;
                StringBuilder ketQua = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    ketQua.append(truoc);
                    if (i < n - 1) {
                        ketQua.append(", ");
                    }
                    long tiep = truoc + sau;
                    truoc = sau;
                    sau = tiep;
                }
                textArea.setText(ketQua.toString());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Vui long nhap so nguyen hop le!",
                        "Loi nhap lieu",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(panelTren, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}