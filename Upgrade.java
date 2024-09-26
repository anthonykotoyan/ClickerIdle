import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Upgrade extends JButton {

    private int price;
    private String upgradeName;
    private String description;
    private String imgPath;


    //No argument constructor
    public Upgrade() {
        this("New Button", 0, 0, 100, 50,
                0, "New Button Description", "images/nash.jpg");
    }

    // Constructor for an upgrade with an image
    public Upgrade(String label, int x, int y, int width, int height, int _price, String _description,
                   String _imgPath) {
        super(label);

        upgradeName = label;
        price = _price;
        description = _description;
        imgPath = _imgPath;

        setIcon(imgPath, width, height);

        // Set the position and size of the button
        this.setBounds(x, y, width, height);
        // Add an action listener for button events
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    onClick();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    //Basic onCLick (Override in subclasses)
    public void onClick() throws IOException {
        int currentMoney = Main.getMoney();
        if (currentMoney >= getPrice()) {
            Main.displayWarning("", "images/guillaume.jpg");
        } else {
            Main.displayWarning("You do not have enough money for this", "images/tobadsosad.png");
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

            Image scaledImage = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);

            this.setIcon(new ImageIcon(scaledImage));

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
