import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Custom Button Example");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with null layout for absolute positioning
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Add custom buttons with specific positions
        Upgrade button1 = new Upgrade("Button 1", 50, 50, 100, 40, 0, "");
        Upgrade button2 = new Upgrade("Button 2", 200, 100, 100, 40, 0, "");

        panel.add(button1);
        panel.add(button2);

        frame.add(panel);
        frame.setVisible(true);
    }
}
