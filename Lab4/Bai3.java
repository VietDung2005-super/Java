import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.awt.GridLayout;

public class Bai3 extends JFrame {
    private JTextField txtN;
    private JButton btnCalculate;
    private JLabel lblResult;
    private JProgressBar progressBar;

    public Bai3() {
        setTitle("Bai 3 - Tinh tong cac so nguyen to nho hon N");
        setSize(450, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        txtN = new JTextField(10);
        btnCalculate = new JButton("Tinh");
        lblResult = new JLabel("Ket qua: ");
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.add(txtN);
        panel.add(btnCalculate);
        panel.add(progressBar);
        panel.add(lblResult);
        add(panel);

        btnCalculate.addActionListener(e -> calculatePrimeSum());
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private void calculatePrimeSum() {
        int n;
        try {
            n = Integer.parseInt(txtN.getText().trim());
            if (n <= 2) {
                JOptionPane.showMessageDialog(this, "N phai lon hon 2");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui long nhap so nguyen hop le!");
            return;
        }

        btnCalculate.setEnabled(false);
        progressBar.setValue(0);
        lblResult.setText("Dang tinh...");

        SwingWorker<Long, Void> worker = new SwingWorker<Long, Void>() {
            @Override
            protected Long doInBackground() throws Exception {
                long tong = 0;
                for (int i = 2; i < n; i++) {
                    if (isPrime(i)) {
                        tong += i;
                    }
                    int phanTram = (int) ((i * 100.0) / (n - 1));
                    setProgress(Math.min(phanTram, 100));
                }
                return tong;
            }

            @Override
            protected void done() {
                try {
                    long tong = get();
                    lblResult.setText("Ket qua: " + tong);
                } catch (Exception ex) {
                    lblResult.setText("Ket qua: Co loi xay ra");
                }
                progressBar.setValue(100);
                btnCalculate.setEnabled(true);
            }
        };

        worker.addPropertyChangeListener(evt -> {
            if ("progress".equals(evt.getPropertyName())) {
                progressBar.setValue((Integer) evt.getNewValue());
            }
        });

        worker.execute();
    }

    public static void main(String[] args) {
        Bai3 frame = new Bai3();
        frame.setVisible(true);
    }
}