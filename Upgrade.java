import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
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
                0, "New Button Description", "nash.jpg");
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
                onClick();
            }
        });

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON3) { // Right-click
                    try {
                        onRightClick();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    private void onRightClick() throws IOException {
        displayDesc();
    }

    private void displayDesc() throws IOException {
        BufferedImage img = ImageIO.read(new File(imgPath));

        Image scaledImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);
        JOptionPane.showMessageDialog(this, description, upgradeName, JOptionPane.INFORMATION_MESSAGE, icon);
    }

    //Basic onCLick (Override in subclasses)
    public void onClick(){
        System.out.println(upgradeName + " clicked!");
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
