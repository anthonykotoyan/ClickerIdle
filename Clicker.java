import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Clicker extends JButton {
    private static int moneyPerClick = 1;
    private static int numClicks = 0;

    // Constructor for the button class
    public Clicker(JPanel panel, int x, int y, int width, int height, String imgPath) {
        super("Clicker");




        // Set the position and size of the button
        this.setBounds(x, y, width, height);
        setIcon(imgPath, width, height);

        // Add an action listener for button events
        this.addActionListener(e -> onClick());
        panel.add(this);
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
    public void onClick(){

        numClicks += moneyPerClick;
        Main.setMoney(numClicks);
    }
    public int getNumClicks(){
        return numClicks;
    }
    public static void setNumClicks(int newNumClicks){
        numClicks =  newNumClicks;
    }
    public static void addMoneyPerClick(int extraClicks){
        moneyPerClick += extraClicks;
    }


}
