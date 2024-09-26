import javax.swing.*;
import java.io.IOException;

public class ExtraClickUpgrade extends Upgrade {

    private int extraClicks;
    private float costMultiplier;
    private JLabel extraClicksLabel;

    public ExtraClickUpgrade(JPanel panel, int _extraClicks, float _costMultiplier, String label, int x, int y, int width, int height, int _price, String _description, String imgPath) {
        super(label, x, y, width, height, _price, _description, imgPath);

        extraClicks = _extraClicks;
        costMultiplier = _costMultiplier;

        // Create and position the extra clicks label
        extraClicksLabel = new JLabel("Extra Clicks: " + extraClicks);
        extraClicksLabel.setBounds(x, y + height + 45, width, 20);

        // Add the button and labels to the panel
        panel.add(this);
        panel.add(getPriceLabel());
        panel.add(extraClicksLabel);
        panel.add(getAmountUsedLabel());
    }

    @Override
    public void onClick() throws IOException {
        int currentMoney = Main.getMoney();
        if (currentMoney >= getPrice()) {
            Clicker.addMoneyPerClick(extraClicks);
            Clicker.setNumClicks(currentMoney - getPrice());

            // Update the price after the purchase
            setPrice((int) (getPrice() * costMultiplier));
            setAmountUsed(getAmountUsed() + 1);
            updateLabels();
            updateMoneyLabel();
        } else {
            Main.displayWarning("You do not have enough money for this", "images/tobadsosad.png");
        }
    }

    private void updateLabels() {
        getPriceLabel().setText("Price: " + getPrice());
        extraClicksLabel.setText("Extra Clicks: " + extraClicks);
        getAmountUsedLabel().setText("You own " + getAmountUsed() + " of these.");
    }


}
