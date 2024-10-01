import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.*;


public class Main {
    private static int money;
    private static Clicker guillaumeClicker;
    private static JPanel panel;

    private static String title = "Clicker";

    private static Random rand = new Random();

    private static String[] songs =
            new String[]{
                    "music/OMFG-Hello.mp3.wav",
                    "music/Kendrick Lamar-Not Like Us(BRAZILIAN PHONK REMIX)[Clean Version for PE Teachers].wav",
                    "music/RUSHE.wav",
                    "music/SneakySnitch.wav"
            };

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        JFrame frame = new JFrame(title);
        int width = 1200;
        int height = 800;

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BufferedImage img = ImageIO.read(new File("images/guillaume.jpeg"));
        Image scaledImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        frame.setIconImage(scaledImage);

        panel = new JPanel();
        panel.setLayout(null);

        //Neeku
        new ExtraClickUpgrade(panel,
                1,
                "Neeku",
                0, 0,
                100, 100,
                new Price(10, "+", 10),
                "Neeku is first you will get. 1 more click, <br> but he costs 10 more after every purchase",
                "images/neekthegeek.jpeg");

        //Issara
        new ExtraClickUpgrade(panel,
                10,
                "Issara",
                150, 0,
                100, 100,
                new Price(50, "*", 2),
                "Issara is a little better than Neeku with 10+ clicks, <br> but costs 50 more per purchase",
                "images/verosity.jpeg");


        //Connor H
        new AutoClicker(panel,
                "Connor H",
                2,
                300, 0,
                100,
                100,
                new Price(500, "+", 1000),
                "Connor is your fist auto clicker!<br>He clicks every 2 seconds and your <br>current moneyPerClick still applies",
                "images/connorh.jpeg");

        //Brady
        new EveryXClicksUpgrade(panel,
                "Brady O'Keefe",
                100,
                1000,
                450, 0,
                100, 100,
                new Price(200, "*", 2),
                "He will give you a large boost ($1000 per Brady) every 100 clicks",
                "images/nart.jpeg");

        //Caden
        new ExtraClickUpgrade(panel,
                10,
                "Caden",
                600, 0,
                100, 100,
                new Price(50, "*", 2),
                "placeholder",
                "images/VanPelt.jpeg");

        //Jayden
        new ExtraClickUpgrade(panel,
                10,
                "Jayden",
                750, 0,
                100, 100,
                new Price(50, "*", 2),
                "placeholder",
                "images/jden.jpeg");

        //Anthony
        new ExtraClickUpgrade(panel,
                10,
                "Issara",
                900, 0,
                100, 100,
                new Price(50, "*", 2),
                "placeholder",
                "images/antoine.jpeg");

        //Connor G
        new ExtraClickUpgrade(panel,
                10,
                "Issara",
                1050, 0,
                100, 100,
                new Price(50, "*", 2),
                "placeholder",
                "images/connor2.jpeg");

        //Carti
        new ExtraClickUpgrade(panel,
                10,
                "Issara",
                0, 300,
                100, 100,
                new Price(50, "*", 2),
                "placeholder",
                "images/carti!!.jpeg");

        //Mr. Guillomes Brother
        new ExtraClickUpgrade(panel,
                10,
                "Issara",
                1050, 300,
                100, 100,
                new Price(50, "*", 2),
                "placeholder",
                "images/brother.jpg");

        //Isaac
        new MultiplyPowerUp(panel,
                5,
                2,
                "Isaac",
                0, 600,
                100, 100,
                new Price(),
                "placeholder",
                "images/caf-fein.png");

        //Lincoln
        new MultiplyPowerUp(panel,
                5,
                3,
                "Lincoln",
                250, 600,
                100, 100,
                new Price(),
                "placeholder",
                "images/abraham.jpeg");

        //Julian
        new MultiplyPowerUp(panel,
                5,
                4,
                "Julian",
                550, 600,
                100, 100,
                new Price(),
                "placeholder",
                "images/senior.jpeg");

        //Evan
        new MultiplyPowerUp(panel,
                5,
                5,
                "Evan",
                850, 600,
                100, 100,
                new Price(),
                "placeholder",
                "images/evan.jpg");

        //Mrs. Tormey
        new MultiplyPowerUp(panel,
                5,
                3,
                "Mrs. Tormey",
                1050, 600,
                100, 100,
                new Price(),
                "placeholder",
                "images/a.jpeg");

        

        guillaumeClicker = new Clicker(panel, width / 2 - 100, height / 2 - 100, 200, 200, "images/guillaume.jpeg");

        frame.add(panel);
        frame.setVisible(true);

        displayWarning( "Click on Mr. Guillaume and buy upgrades \n Evan and Anthony are the best programmers in this class :)", "images/guillaume.jpeg");


        //MUSIC:
        File audioFile = new File(songs[rand.nextInt(songs.length)]); // Replace with your file path
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        Clip clip = (Clip) AudioSystem.getLine(info);

        clip.open(audioStream);
        clip.start();

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
