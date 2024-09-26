import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    private static int money;
    private static Clicker guillaumeClicker;
    private static JPanel panel;

    private static String title = "Clicker";

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame(title);
        int width = 1200;
        int height = 800;

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        ExtraClickUpgrade nashUpgrade = new ExtraClickUpgrade(panel, 1, 5, "Nash", 0, 0, 100, 100, 10, "Our Beautiful Principle, adds 1 extra click", "images/nash.jpg");

        ExtraClickUpgrade neekuUpgrade = new ExtraClickUpgrade(panel, 5,10,"Neeku", 150, 0, 100, 100, 20, "Kinda stinky, but gives plus two money per click, costs 5x more after every purchase", "images/neekthegeek.jpg");

        guillaumeClicker = new Clicker(panel, width / 2 - 50, height / 2 - 50, 100, 100, "images/guillaume.jpg");

        frame.add(panel);
        frame.setVisible(true);

        displayWarning( "Click on Mr. Guillaume and buy upgrades \n Evan and Anthony are the best programmers in this class :)", "images/guillaume.jpg");
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

    public static void displayWarning(String content, String imgPath) throws IOException {
        BufferedImage img = ImageIO.read(new File(imgPath));

        Image scaledImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);
        JOptionPane.showMessageDialog(panel, content, title, JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
