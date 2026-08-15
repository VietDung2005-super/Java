import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import java.awt.GridLayout;

public class Bai2 extends JFrame {
    private JButton btnLoad;
    private JProgressBar progressBar;
    private JLabel lblStatus;

    public Bai2() {
        setTitle("Bai 2 - Mo phong tai du lieu");
        setSize(450, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnLoad = new JButton("Tai du lieu");
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        lblStatus = new JLabel("Chua tai du lieu");

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.add(btnLoad);
        panel.add(progressBar);
        panel.add(lblStatus);
        add(panel);

        btnLoad.addActionListener(e -> loadData());
    }

    private void loadData() {
        btnLoad.setEnabled(false);
        progressBar.setValue(0);
        lblStatus.setText("Dang tai du lieu...");

        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i += 10) {
                    publish(i);
                    Thread.sleep(1000);
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                int value = chunks.get(chunks.size() - 1);
                progressBar.setValue(value);
                lblStatus.setText("Dang tai du lieu... " + value + "%");
            }

            @Override
            protected void done() {
                progressBar.setValue(100);
                lblStatus.setText("Tai du lieu hoan tat!");
                btnLoad.setEnabled(true);
            }
        };

        worker.execute();
    }

    public static void main(String[] args) {
        Bai2 frame = new Bai2();
        frame.setVisible(true);
    }
}