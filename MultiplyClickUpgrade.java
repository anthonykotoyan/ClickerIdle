import javax.swing.*;
import java.io.IOException;

public class MultiplyClickUpgrade extends Upgrade {

    private float multiplyClicks;

    private JLabel multiplyClicksLabel;

    public MultiplyClickUpgrade(JPanel panel, float _multiplyClicks, String label, int x, int y, int width, int height, Price _price, String _description, String imgPath) {
        super(label, x, y, width, height, _price, _description, imgPath);

        multiplyClicks = _multiplyClicks;


        // Create and position the extra clicks label
        multiplyClicksLabel = new JLabel("Clicks Multiplied: " + multiplyClicks);
        multiplyClicksLabel.setBounds(x, y + height + 45, width, 20);

        // Add the button and labels to the panel
        panel.add(this);
        panel.add(getPriceLabel());
        panel.add(multiplyClicksLabel);
        panel.add(getAmountUsedLabel());
    }

    @Override
    public void onClick() throws IOException {
        int currentMoney = Main.getMoney();
        if (currentMoney >= getPrice().getPrice()) {
            Clicker.addMultiplyPerClick(multiplyClicks);
            Clicker.setNumClicks(currentMoney - getPrice().getPrice());

            // Update the price after the purchase
            getPrice().updatePrice();
            setAmountUsed(getAmountUsed() + 1);
            updateLabels();
            updateMoneyLabel();
        } else {
            Main.displayWarning("You do not have enough money for this", "images/tobadsosad.png");
        }
    }

    private void updateLabels() {
        getPriceLabel().setText("Price: " + getPrice().getPrice());
        multiplyClicksLabel.setText("Clicks Multiplied: " + multiplyClicks);
        getAmountUsedLabel().setText("You own " + getAmountUsed() + " of these.");
    }


}
