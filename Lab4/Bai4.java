import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.awt.GridLayout;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Bai4 extends JFrame {
    private JTextField txtN;
    private JButton btnFind;
    private JLabel lblResult;
    private JProgressBar progressBar;

    public Bai4() {
        setTitle("Bai 4 - Tim so Fibonacci thu N");
        setSize(450, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        txtN = new JTextField(10);
        btnFind = new JButton("Tim");
        lblResult = new JLabel("Ket qua: ");
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.add(txtN);
        panel.add(btnFind);
        panel.add(progressBar);
        panel.add(lblResult);
        add(panel);

        btnFind.addActionListener(e -> timFibonacci());
    }

    private BigInteger fibonacci(int n, Map<Integer, BigInteger> memo) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        BigInteger value = fibonacci(n - 1, memo).add(fibonacci(n - 2, memo));
        memo.put(n, value);
        return value;
    }

    private void timFibonacci() {
        int n;
        try {
            n = Integer.parseInt(txtN.getText().trim());
            if (n < 0) {
                JOptionPane.showMessageDialog(this, "N phai la so khong am");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui long nhap so nguyen hop le!");
            return;
        }

        btnFind.setEnabled(false);
        lblResult.setText("Dang tinh...");
        progressBar.setIndeterminate(true);

        SwingWorker<BigInteger, Void> worker = new SwingWorker<BigInteger, Void>() {
            @Override
            protected BigInteger doInBackground() throws Exception {
                Map<Integer, BigInteger> memo = new HashMap<>();
                return fibonacci(n, memo);
            }

            @Override
            protected void done() {
                try {
                    BigInteger ketQua = get();
                    lblResult.setText("Ket qua: " + ketQua);
                } catch (Exception ex) {
                    lblResult.setText("Ket qua: Co loi xay ra");
                }
                progressBar.setIndeterminate(false);
                progressBar.setValue(100);
                btnFind.setEnabled(true);
            }
        };

        worker.execute();
    }

    public static void main(String[] args) {
        Bai4 frame = new Bai4();
        frame.setVisible(true);
    }
}