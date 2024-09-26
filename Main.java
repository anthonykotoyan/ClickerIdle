import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main {
    private static int money;
    private static Clicker guillaumeClicker;
    private static JPanel panel;

    private static String title = "Clicker";
    private static Random random;

    public static void main(String[] args) throws IOException {
        random = new Random();
        JFrame frame = new JFrame(title);
        int width = 1200;
        int height = 800;

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BufferedImage img = ImageIO.read(new File("images/guillaume.jpg"));
        Image scaledImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        frame.setIconImage(scaledImage);

        panel = new JPanel();
        panel.setLayout(null);
        Price nashPrice = new Price(10, "+", 10);
        ExtraClickUpgrade nashUpgrade = new ExtraClickUpgrade(panel, 1, 5, "Mr. Nash", 0, 0, 100, 100, nashPrice, "Our Beautiful Principle, get 1 extra dollar per click", "images/nash.jpg");

        Price neekuPrice = new Price(20, "*", 5);
        ExtraClickUpgrade neekuUpgrade = new ExtraClickUpgrade(panel, 5,10,"Neeku", 150, 0, 100, 100, neekuPrice, "Kinda stinky, but gives 2 extra dollars per click, costs 10x more after every purchase", "images/neekthegeek.jpg");

        Price isaacPrice = new Price(100, "+", 100);
        AutoClicker issacUpgrade = new AutoClicker(panel, "Isaac", 1, 2,300, 0, 100, 100, isaacPrice, "So hopped up on caffeine he just clicks once every 3s", "images/caf-fein.png");

        Price issaraPrice = new Price(0, "+", 0);
        MultiplyPowerUp issaraPowerUp = new MultiplyPowerUp(panel, 5, 100,"Issara", 450, 0,100, 100, issaraPrice, "Kinda bad at coding, but he gets the job done", "images/verosity.jpeg");

        guillaumeClicker = new Clicker(panel, width / 2 - 100, height / 2 - 100, 200, 200, "images/guillaume.jpg");

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
