import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    private static int money;
    private static Clicker guillaumeClicker;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Button Example");
        int width = 1200;
        int height = 800;

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        ExtraClickUpgrade nashUpgrade = new ExtraClickUpgrade(panel, 1, 5, "Nash", 0, 0, 100, 100, 10, "Our Beautiful Principle, adds 1 extra click", "nash.jpg");

        ExtraClickUpgrade neekuUpgrade = new ExtraClickUpgrade(panel, 5,10,"Neeku", 150, 0, 100, 100, 20, "Kinda stinky, but gives plus two money per click, costs 5x more after every purchase", "neekthegeek.jpg");

        guillaumeClicker = new Clicker(panel, width / 2 - 50, height / 2 - 50, 100, 100, "guilluame.jpg");

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void setMoney(int numClicks) {
        money = numClicks;
        guillaumeClicker.updateMoneyLabel();
    }

    public static int getMoney() {
        return money;
    }

    public static Clicker getClicker() {
        return guillaumeClicker;
    }
}
