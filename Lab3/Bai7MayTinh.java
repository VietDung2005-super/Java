import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Bai7MayTinh {
    public static void main(String[] args) {
        JFrame frame = new JFrame("May tinh mini");
        frame.setSize(400, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelNhap = new JPanel(new GridLayout(3, 2, 5, 5));

        JLabel labelA = new JLabel("So thu nhat:");
        JTextField textA = new JTextField();

        JLabel labelB = new JLabel("So thu hai:");
        JTextField textB = new JTextField();

        JPanel panelPhepTinh = new JPanel(new GridLayout(1, 5, 3, 3));
        JButton buttonCong = new JButton("+");
        JButton buttonTru = new JButton("-");
        JButton buttonNhan = new JButton("*");
        JButton buttonChia = new JButton("/");
        JButton buttonXoa = new JButton("Clear");
        panelPhepTinh.add(buttonCong);
        panelPhepTinh.add(buttonTru);
        panelPhepTinh.add(buttonNhan);
        panelPhepTinh.add(buttonChia);
        panelPhepTinh.add(buttonXoa);

        panelNhap.add(labelA);
        panelNhap.add(textA);
        panelNhap.add(labelB);
        panelNhap.add(textB);

        JPanel panelTren = new JPanel(new BorderLayout());
        panelTren.add(panelNhap, BorderLayout.NORTH);
        panelTren.add(panelPhepTinh, BorderLayout.SOUTH);

        JTextArea textAreaLichSu = new JTextArea();
        textAreaLichSu.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaLichSu);

        buttonCong.addActionListener(e -> tinhToan(frame, textA, textB, textAreaLichSu, '+'));
        buttonTru.addActionListener(e -> tinhToan(frame, textA, textB, textAreaLichSu, '-'));
        buttonNhan.addActionListener(e -> tinhToan(frame, textA, textB, textAreaLichSu, '*'));
        buttonChia.addActionListener(e -> tinhToan(frame, textA, textB, textAreaLichSu, '/'));
        buttonXoa.addActionListener(e -> {
            textA.setText("");
            textB.setText("");
            textAreaLichSu.setText("");
        });

        frame.setLayout(new BorderLayout());
        frame.add(panelTren, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void tinhToan(JFrame frame, JTextField textA, JTextField textB,
                                 JTextArea textAreaLichSu, char phepTinh) {
        try {
            double a = Double.parseDouble(textA.getText().trim());
            double b = Double.parseDouble(textB.getText().trim());
            double ketQua;

            switch (phepTinh) {
                case '+':
                    ketQua = a + b;
                    break;
                case '-':
                    ketQua = a - b;
                    break;
                case '*':
                    ketQua = a * b;
                    break;
                case '/':
                    if (b == 0) {
                        JOptionPane.showMessageDialog(frame,
                                "Khong the chia cho 0!",
                                "Loi tinh toan",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    ketQua = a / b;
                    break;
                default:
                    return;
            }

            String dongLichSu = a + " " + phepTinh + " " + b + " = " + ketQua;
            textAreaLichSu.append(dongLichSu + "\n");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame,
                    "Vui long nhap so hop le!",
                    "Loi nhap lieu",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}