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
                    "music/SneakySnitch.wav",
                    "music/How to make a Video Game in Unity - BASICS (E01).wav"
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
                1000,
                "Caden",
                600, 0,
                100, 100,
                new Price(100, "*", 2),
                "Caden Gives you 1000 per , but he gets expenive fast",
                "images/VanPelt.jpeg");

        //Jayden
        new AutoClicker(panel,
                "Jayden",
                0.1f,
                750, 0,
                100, 100,
                new Price(10000, "+", 10000),
                "Very fast auto clicker",
                "images/jden.jpeg");

        //Anthony
        new MultiplicativeUpgrade(panel,
                "Anthony",
                100, 1.25,
                900, 0,
                100, 100,
                new Price(10000, "*", 1.5),
                "One of the best programmers in the class!<br>Gain 1.25x money per 100 clicks",
                "images/antoine.jpeg");

        //Connor G
        new ExtraClickUpgrade(panel,
                100000,
                "Connor G",
                1050, 0,
                100, 100,
                new Price(1000, "*", 2),
                "Connor is gives you 100,000 extra clicks for a low price but it grows fasst",
                "images/connor2.jpeg");

        //Carti
        new ExtraClickUpgrade(panel,
                -999999999,
                "Playboy Carti",
                0, 300,
                100, 100,
                new Price(999999999, "*", 5),
                "Fwaee<br>Ijubeepoppemshengeinilii<br>WeaigobaldrohuhIongiafubounun - goat",
                "images/carti!!.jpeg");

        //Mr. Guillomes Brother
        new MultiplicativeUpgrade(panel,
                "Mr. Guillaume's Brother",
                10, 5,
                1050, 300,
                100, 100,
                new Price(10000000, "*", 5),
                "Better than everyone<br>Gain 5x money per 10 clicks",
                "images/brother.jpg");

        //Isaac
        new MultiplyPowerUp(panel,
                5,
                2,
                "Isaac",
                0, 600,
                100, 100,
                new Price(100000, "*", 5),
                "Hes so hopped up on caffeine, you get 2x money per click while he is active",
                "images/caf-fein.png");

        //Lincoln
        new MultiplyPowerUp(panel,
                5,
                3,
                "Lincoln",
                250, 600,
                100, 100,
                new Price(5000000, "*", 5),
                "Lincoln has peak effeciency. While he is active you gain 3x money per click",
                "images/abraham.jpeg");

        //Julian
        new MultiplyPowerUp(panel,
                5,
                4,
                "Julian",
                550, 600,
                100, 100,
                new Price(1000000, "*", 5),
                "Uhhh, I dont know this guy. Anthony does tho...<br>4x money per click while active",
                "images/senior.jpeg");

        //Mrs. Tormey
        new MultiplyPowerUp(panel,
                5,
                5,
                "Mrs. Tormey",
                850, 600,
                100, 100,
                new Price(500000000, "*", 5),
                "The second best AP Computer Science teacher.<br>She gives you 5x money per click while active",
                "images/tormanator.jpeg");

        //Evan
        new MultiplyPowerUp(panel,
                5,
                50,
                "Evan",
                1050, 600,
                100, 100,
                new Price(500000000, "^", 2),
                "Absolute beast of a person.<br>He gets all A's, can curl 1000 lbs, and so attractive he could pull any girl he wants.<br>While active, he is generous enough to give you 50x money per click (But he could definitely give you more if he wanted)",
                "images/evan.jpg");



        

        guillaumeClicker = new Clicker(panel, width / 2 - 100, height / 2 - 100, 200, 200, "images/guillaume.jpeg");

        frame.add(panel);
        frame.setVisible(true);

        displayWarning( "Click on Mr. Guillaume and buy upgrades \n Evan and Anthony are the best programmers in this class :)", "images/guillaume.jpeg");


        //MUSIC:
        File audioFile = new File(songs[rand.nextInt(songs.length)]); // Replace with your file path
        //File audioFile = new File("music/Adamation Screaming.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        Clip clip = (Clip) AudioSystem.getLine(info);

        clip.open(audioStream);

        clip.setLoopPoints(0, clip.getFrameLength() - 1);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
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
