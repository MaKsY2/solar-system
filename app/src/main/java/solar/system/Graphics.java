package solar.system;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Graphics {
    public void run() {
        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 500, 500);
        frame.setDefaultCloseOperation(3);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
    }
}
