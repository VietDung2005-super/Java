import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Bai4 {
    public static void main(String[] args) {
        String duongDanAnh = "image.jpg";

        ImageIcon icon = new ImageIcon(duongDanAnh);
        JLabel label = new JLabel(icon);

        JFrame frame = new JFrame("Image Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}