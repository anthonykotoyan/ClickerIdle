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

        new ExtraClickUpgrade(panel,
                1,
                "Neeku",
                0, 0,
                100, 100,
                new Price(10, "+", 10),
                "Neeku is first you will get. 1 more click, <br> but he costs 10 more after every purchase",
                "images/neekthegeek.jpeg");

        new ExtraClickUpgrade(panel,
                10,
                "Issara",
                150, 0,
                100, 100,
                new Price(50, "*", 2),
                "Issara is a little better than Neeku with 10+ clicks, <br> but costs 50 more per purchase",
                "images/verosity.jpeg");


        new AutoClicker(panel,
                "Connor H",
                2,
                300, 0,
                100,
                100,
                new Price(500, "+", 1000),
                "Connor is your fist auto clicker!<br>He clicks every 2 seconds and your <br>current moneyPerClick still applies",
                "images/connorh.jpeg");

        new EveryXClicksUpgrade(panel,
                "Test",
                2,
                100,
                450, 0,
                100, 100,
                new Price(0, "+", 0),
                "Im not sure",
                "images/tobadsosad.png");
        

        // evan mr guillaume said he will help us make it an exec file on tuesday, or do u alr know how to do that
        //new ExtraClickUpgrade(panel, 5, "Brady", 450, 0,100, 100, new Price(500, "+", 100), "Kinda bad at coding, but he gets the job done", "images/verosity.jpeg");

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
