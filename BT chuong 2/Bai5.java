import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Bai5 {
    public static void main(String[] args) {
        LocalDateTime thoiGianHienTai = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String chuoiThoiGian = thoiGianHienTai.format(formatter);

        JLabel label = new JLabel(chuoiThoiGian, SwingConstants.CENTER);

        JFrame frame = new JFrame("Digital Clock");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        frame.setVisible(true);
    }
}