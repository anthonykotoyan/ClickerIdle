import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Clicker extends JButton {
    private static int moneyPerClick = 1;
    private static int numClicks = 0;
    private static float moneyMultiplier = 1;
    private static JLabel moneyLabel;

    private static Subscriber[] subscribers;

    public Clicker(JPanel panel, int x, int y, int width, int height, String imgPath) {
        super("Clicker");

        this.setBounds(x, y, width, height);
        setIcon(imgPath, width, height);

        moneyLabel = new JLabel("Money: " + numClicks);
        moneyLabel.setBounds(x, y + height + 5, width, 20);
        panel.add(moneyLabel);

        this.addActionListener(e -> onClick());
        panel.add(this);
    }

    public static int getMoneyPerClick() {
        return moneyPerClick;
    }

    private void setIcon(String path, int w, int h) {
        try {
            BufferedImage img = ImageIO.read(new File(path));
            java.awt.Image scaledImage = img.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
            this.setIcon(new javax.swing.ImageIcon(scaledImage));
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void onClick() {
        numClicks += (int)moneyPerClick*moneyMultiplier;
        Main.setMoney(numClicks);
        updateMoneyLabel();


        if (subscribers != null) {
            for (Subscriber subscriber : subscribers) {
                subscriber.ping();
            }
        }
    }

    public static void updateMoneyLabel() {
        moneyLabel.setText("Money: " + numClicks);
    }

    public static int getNumClicks() {
        return numClicks;
    }

    public static void setNumClicks(int newNumClicks) {
        numClicks = newNumClicks;
        Main.setMoney(numClicks);
    }

    public static void addMoneyPerClick(int extraClicks) {
        moneyPerClick += extraClicks;
    }
    public static void addMultiplyPerClick(float _moneyMultiplier) {
        moneyMultiplier += _moneyMultiplier;
    }

    public JLabel getMoneyLabel() {
        return moneyLabel;
    }

    public static void setMoneyPerClick(int moneyPerClick) {
        Clicker.moneyPerClick = moneyPerClick;
    }
    
    public static void subscribe(Subscriber s){
        
        if (subscribers == null) {
            subscribers = new Subscriber[1];
            subscribers[0] = s;
        } else {
            Subscriber[] newSubscribers = new Subscriber[subscribers.length + 1];
            System.arraycopy(subscribers, 0, newSubscribers, 0, subscribers.length);
            newSubscribers[subscribers.length] = s;
            subscribers = newSubscribers;
        }
    }
}
