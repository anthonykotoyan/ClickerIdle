import javax.swing.*;
import java.io.IOException;

public class ExtraClickUpgrade extends Upgrade {

    private int extraClicks;
    private float costMultiplier;
    private int amountUsed = 0;
    private JLabel priceLabel;
    private JLabel extraClicksLabel;
    private JLabel amountUsedLabel;

    public ExtraClickUpgrade(JPanel panel, int _extraClicks, float _costMultiplier, String label, int x, int y, int width, int height, int _price, String _description, String imgPath) {
        super(label, x, y, width, height, _price, _description, imgPath);

        extraClicks = _extraClicks;
        costMultiplier = _costMultiplier;

        // Create and position the price label
        priceLabel = new JLabel("Price: " + getPrice());
        priceLabel.setBounds(x, y + height + 5, width, 20);

        // Create and position the extra clicks label
        extraClicksLabel = new JLabel("Extra Clicks: " + extraClicks);
        extraClicksLabel.setBounds(x, y + height + 25, width, 20);

        // Create and position the amount used label
        amountUsedLabel = new JLabel("You own " + amountUsed + " of these.");
        amountUsedLabel.setBounds(x, y + height + 45, width * 2, 20);

        // Tooltip for description
        this.setToolTipText(getDescription());

        // Add the button and labels to the panel
        panel.add(this);
        panel.add(priceLabel);
        panel.add(extraClicksLabel);
        panel.add(amountUsedLabel);
    }

    @Override
    public void onClick() throws IOException {
        int currentMoney = Main.getMoney();
        if (currentMoney >= getPrice()) {
            Clicker.addMoneyPerClick(extraClicks);
            Clicker.setNumClicks(currentMoney - getPrice());

            // Update the price after the purchase
            setPrice((int) (getPrice() * costMultiplier));
            amountUsed += 1;
            updateLabels();
            updateMoneyLabel();
        } else {
            Main.displayWarning("You do not have enough money for this", "images/tobadsosad.png");
        }
    }

    private void updateLabels() {
        priceLabel.setText("Price: " + getPrice());
        extraClicksLabel.setText("Extra Clicks: " + extraClicks);
        amountUsedLabel.setText("You own " + amountUsed + " of these.");
    }

    private void updateMoneyLabel() {
        Main.getClicker().updateMoneyLabel();
    }
}
