import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class Bai4TamGiac {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Kiem tra va phan loai tam giac");
        frame.setSize(400, 260);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

        JLabel labelA = new JLabel("Canh a:");
        JTextField textA = new JTextField();

        JLabel labelB = new JLabel("Canh b:");
        JTextField textB = new JTextField();

        JLabel labelC = new JLabel("Canh c:");
        JTextField textC = new JTextField();

        JButton buttonKiemTra = new JButton("Kiem tra");
        JLabel labelKetQua = new JLabel("Ket qua:");

        panel.add(labelA);
        panel.add(textA);
        panel.add(labelB);
        panel.add(textB);
        panel.add(labelC);
        panel.add(textC);
        panel.add(buttonKiemTra);
        panel.add(new JLabel());
        panel.add(labelKetQua);

        buttonKiemTra.addActionListener(e -> {
            try {
                double a = Double.parseDouble(textA.getText().trim());
                double b = Double.parseDouble(textB.getText().trim());
                double c = Double.parseDouble(textC.getText().trim());

                if (!laTamGiac(a, b, c)) {
                    labelKetQua.setText("Ket qua: Khong tao thanh tam giac");
                } else {
                    labelKetQua.setText("Ket qua: " + phanLoaiTamGiac(a, b, c));
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

    public static boolean laTamGiac(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0
                && a + b > c
                && a + c > b
                && b + c > a;
    }

    public static String phanLoaiTamGiac(double a, double b, double c) {
        boolean vuong = kiemTraVuong(a, b, c);
        boolean deu = (a == b) && (b == c);
        boolean can = (a == b) || (b == c) || (a == c);

        if (deu) {
            return "Tam giac deu";
        }
        if (vuong && can) {
            return "Tam giac vuong can";
        }
        if (vuong) {
            return "Tam giac vuong";
        }
        if (can) {
            return "Tam giac can";
        }
        return "Tam giac thuong";
    }

    public static boolean kiemTraVuong(double a, double b, double c) {
        double max = Math.max(a, Math.max(b, c));
        double sumSqOther = a * a + b * b + c * c - max * max;
        return Math.abs(max * max - sumSqOther) < 1e-9;
    }
}