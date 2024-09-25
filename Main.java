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
        Upgrade button1 = new Upgrade("Nash", 5, 50, 50, 100, 0, "Our Beautiful Principle", "nash.jpg");
        Upgrade button2 = new Upgrade("Empty Upgrade", 200, 100, 100, 40, 0, "");
        Upgrade button3 = new Upgrade();

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        frame.add(panel);
        frame.setVisible(true);

        System.out.println(button1);
    }
}
