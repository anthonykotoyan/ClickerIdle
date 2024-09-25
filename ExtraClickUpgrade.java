import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExtraClickUpgrade extends JButton {

    private int price;
    private String upgradeName;
    private String description;
    private int extraClicks;




    // Constructor for an upgrade with an image
    public ExtraClickUpgrade(JPanel panel, int _extraClicks, String label, int x, int y, int width, int height, int _price, String _description,
                             String imgPath) {
        super(label);

        upgradeName = label;
        price = _price;
        description = _description;
        extraClicks = _extraClicks;

        setIcon(imgPath, width, height);



        // Set the position and size of the button
        this.setBounds(x, y, width, height);
        // Add an action listener for button events
        this.addActionListener(e -> onClick());
        panel.add(this);
    }

    // Constructor for an upgrade without an image
    public ExtraClickUpgrade(JPanel panel, int extraClicks, String label, int x, int y, int width, int height, int _price, String _description) {
        super(label);

        upgradeName = label;
        price = _price;
        description = _description;



        // Set the position and size of the button
        this.setBounds(x, y, width, height);
        // Add an action listener for button events
        this.addActionListener(e -> onClick());
        panel.add(this);
    }

    //Basic onCLick (Override in subclasses)
    public void onClick(){
        int currentMoney = Main.getMoney();
        if (currentMoney>=price){
            Clicker.addMoneyPerClick(extraClicks);
            Clicker.setNumClicks(currentMoney-price);

        } else{
            System.out.println("You do not have enough money for the " + upgradeName + " Upgrade!");
        }
    }

    @Override
    public String toString() {
        return "Upgrade{" +
                "price=" + price +
                ", upgradeName='" + upgradeName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpgradeName() {
        return upgradeName;
    }

    public void setUpgradeName(String upgradeName) {
        this.upgradeName = upgradeName;
    }

    //Sets icon of the Button
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
