import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class Bai6dangnhap {
    public static void main(String[] args) {
        String taiKhoanDung = "admin";
        String matKhauDung = "123456";

        JFrame frame = new JFrame("Form dang nhap");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));

        JLabel labelTaiKhoan = new JLabel("Tai khoan:");
        JTextField textTaiKhoan = new JTextField();

        JLabel labelMatKhau = new JLabel("Mat khau:");
        JPasswordField textMatKhau = new JPasswordField();

        JLabel labelVaiTro = new JLabel("Vai tro:");
        String[] danhSachVaiTro = {"Nguoi dung", "Quan tri vien"};
        JComboBox<String> comboVaiTro = new JComboBox<>(danhSachVaiTro);

        JLabel labelGhiNho = new JLabel("Ghi nho dang nhap:");
        JCheckBox checkGhiNho = new JCheckBox();

        JButton buttonDangNhap = new JButton("Dang nhap");
        JLabel labelKetQua = new JLabel("Trang thai:");

        panel.add(labelTaiKhoan);
        panel.add(textTaiKhoan);
        panel.add(labelMatKhau);
        panel.add(textMatKhau);
        panel.add(labelVaiTro);
        panel.add(comboVaiTro);
        panel.add(labelGhiNho);
        panel.add(checkGhiNho);
        panel.add(buttonDangNhap);
        panel.add(new JLabel());
        panel.add(labelKetQua);

        buttonDangNhap.addActionListener(e -> {
            String taiKhoan = textTaiKhoan.getText().trim();
            String matKhau = new String(textMatKhau.getPassword()).trim();
            String vaiTro = (String) comboVaiTro.getSelectedItem();
            boolean ghiNho = checkGhiNho.isSelected();

            if (taiKhoan.isEmpty() || matKhau.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "Vui long nhap day du tai khoan va mat khau!",
                        "Loi nhap lieu",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (taiKhoan.equals(taiKhoanDung) && matKhau.equals(matKhauDung)) {
                String thongTin = "Dang nhap thanh cong! Vai tro: " + vaiTro
                        + (ghiNho ? " (co ghi nho)" : "");
                labelKetQua.setText("Trang thai: Thanh cong");
                JOptionPane.showMessageDialog(frame, thongTin);
            } else {
                labelKetQua.setText("Trang thai: Sai tai khoan hoac mat khau");
                JOptionPane.showMessageDialog(frame,
                        "Sai tai khoan hoac mat khau!",
                        "Dang nhap that bai",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}