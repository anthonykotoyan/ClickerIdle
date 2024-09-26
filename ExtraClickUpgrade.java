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
    private  float costMultiplier;
    private int amountUsed=0;
    private JLabel priceLabel;
    private JLabel extraClicksLabel;
    private JLabel amountUsedLabel;

    public ExtraClickUpgrade(JPanel panel, int _extraClicks, float _costMultiplier, String label, int x, int y, int width, int height, int _price, String _description, String imgPath) {
        super(label);

        upgradeName = label;
        price = _price;
        description = _description;
        extraClicks = _extraClicks;
        costMultiplier = _costMultiplier;

        setIcon(imgPath, width, height);

        // Set the position and size of the button
        this.setBounds(x, y, width, height);

        // Create and position the price label
        priceLabel = new JLabel("Price: " + price);
        priceLabel.setBounds(x, y + height + 5, width, 20);

        // Create and position the extra clicks label
        extraClicksLabel = new JLabel("Extra Clicks: " + extraClicks);
        extraClicksLabel.setBounds(x, y + height + 25, width, 20);

        // Create and position the cost multiplier label
        amountUsedLabel = new JLabel("You own " +amountUsed+ " of these.");
        amountUsedLabel.setBounds(x, y + height + 45, width*2, 20);

        // Tooltip for description
        this.setToolTipText(description);

        // Add the button and labels to the panel
        panel.add(this);
        panel.add(priceLabel);
        panel.add(extraClicksLabel);
        panel.add(amountUsedLabel);

        // Add an action listener for button events
        this.addActionListener(e -> onClick());
    }

    public void onClick() {
        int currentMoney = Main.getMoney();
        if (currentMoney >= price) {
            Clicker.addMoneyPerClick(extraClicks);
            Clicker.setNumClicks(currentMoney - price);

            // Update the price after the purchase
            price *= costMultiplier;
            amountUsed+=1;
            updateLabels();
            updateMoneyLabel();
        } else {
            System.out.println("You do not have enough money for the " + upgradeName + " Upgrade!");
        }
    }

    private void updateLabels() {
        priceLabel.setText("Price: " + price);
        extraClicksLabel.setText("Extra Clicks: " + extraClicks);
        amountUsedLabel.setText("You own " + amountUsed + " of these.");
    }

    private void updateMoneyLabel() {
        Main.getClicker().updateMoneyLabel();
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
