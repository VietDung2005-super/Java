import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import java.awt.GridLayout;
import java.util.List;

public class Bai6 extends JFrame {
    private JButton btnLoad;
    private JButton btnCancel;
    private JProgressBar progressBar;
    private JLabel lblStatus;
    private SwingWorker<Void, Integer> worker;

    public Bai6() {
        setTitle("Bai 6 - Mo phong tai du lieu (co the huy)");
        setSize(450, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnLoad = new JButton("Tai du lieu");
        btnCancel = new JButton("Huy");
        btnCancel.setEnabled(false);
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        lblStatus = new JLabel("Chua tai du lieu");

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.add(btnLoad);
        panel.add(btnCancel);
        panel.add(progressBar);
        panel.add(lblStatus);
        add(panel);

        btnLoad.addActionListener(e -> loadData());
        btnCancel.addActionListener(e -> huyTacVu());
    }

    private void loadData() {
        btnLoad.setEnabled(false);
        btnCancel.setEnabled(true);
        progressBar.setValue(0);
        lblStatus.setText("Dang tai du lieu...");

        worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i += 10) {
                    if (isCancelled()) {
                        break;
                    }
                    publish(i);
                    Thread.sleep(1000);
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                if (isCancelled()) {
                    return;
                }
                int value = chunks.get(chunks.size() - 1);
                progressBar.setValue(value);
                lblStatus.setText("Dang tai du lieu... " + value + "%");
            }

            @Override
            protected void done() {
                if (isCancelled()) {
                    lblStatus.setText("Da huy tac vu");
                } else {
                    progressBar.setValue(100);
                    lblStatus.setText("Tai du lieu hoan tat!");
                }
                btnLoad.setEnabled(true);
                btnCancel.setEnabled(false);
            }
        };

        worker.execute();
    }

    private void huyTacVu() {
        if (worker != null && !worker.isDone()) {
            worker.cancel(true);
        }
    }

    public static void main(String[] args) {
        Bai6 frame = new Bai6();
        frame.setVisible(true);
    }
}