import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Bai5 extends JFrame {
    private JButton btnChonFile;
    private JButton btnDemDong;
    private JLabel lblDuongDan;
    private JLabel lblSoDong;
    private JProgressBar progressBar;
    private File fileDaChon;

    public Bai5() {
        setTitle("Bai 5 - Doc file lon va dem so dong");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnChonFile = new JButton("Chon file");
        btnDemDong = new JButton("Dem dong");
        btnDemDong.setEnabled(false);
        lblDuongDan = new JLabel("Chua chon file");
        lblSoDong = new JLabel("So dong: ");
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.add(btnChonFile);
        panel.add(lblDuongDan);
        panel.add(btnDemDong);
        panel.add(progressBar);
        panel.add(lblSoDong);
        add(panel);

        btnChonFile.addActionListener(e -> chonFile());
        btnDemDong.addActionListener(e -> demSoDong());
    }

    private void chonFile() {
        JFileChooser fileChooser = new JFileChooser();
        int ketQua = fileChooser.showOpenDialog(this);

        if (ketQua == JFileChooser.APPROVE_OPTION) {
            fileDaChon = fileChooser.getSelectedFile();
            lblDuongDan.setText(fileDaChon.getAbsolutePath());
            lblSoDong.setText("So dong: ");
            progressBar.setValue(0);
            btnDemDong.setEnabled(true);
        }
    }

    private void demSoDong() {
        if (fileDaChon == null) {
            JOptionPane.showMessageDialog(this, "Vui long chon file truoc!");
            return;
        }

        btnChonFile.setEnabled(false);
        btnDemDong.setEnabled(false);
        lblSoDong.setText("Dang dem...");
        progressBar.setValue(0);

        SwingWorker<Long, Integer> worker = new SwingWorker<Long, Integer>() {
            @Override
            protected Long doInBackground() throws Exception {
                long tongKichThuoc = fileDaChon.length();
                long daDoc = 0;
                long soDong = 0;

                try (BufferedReader reader = Files.newBufferedReader(
                        fileDaChon.toPath(), StandardCharsets.UTF_8)) {
                    String dong;
                    while ((dong = reader.readLine()) != null) {
                        soDong++;
                        daDoc += dong.getBytes(StandardCharsets.UTF_8).length + 1;

                        if (tongKichThuoc > 0) {
                            int phanTram = (int) Math.min(100, (daDoc * 100) / tongKichThuoc);
                            publish(phanTram);
                        }
                    }
                }

                return soDong;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                int value = chunks.get(chunks.size() - 1);
                progressBar.setValue(value);
            }

            @Override
            protected void done() {
                try {
                    long soDong = get();
                    lblSoDong.setText("So dong: " + soDong);
                } catch (Exception ex) {
                    lblSoDong.setText("So dong: Co loi khi doc file");
                    JOptionPane.showMessageDialog(Bai5.this,
                            "Khong the doc file: " + ex.getMessage());
                }
                progressBar.setValue(100);
                btnChonFile.setEnabled(true);
                btnDemDong.setEnabled(true);
            }
        };

        worker.execute();
    }

    public static void main(String[] args) {
        Bai5 frame = new Bai5();
        frame.setVisible(true);
    }
}