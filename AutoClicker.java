import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AutoClicker extends Upgrade {

    private JLabel cpsLabel;
    private float delay;
    private int costMultiplier;

    // No-argument constructor
    public AutoClicker() {
        super("AutoClicker", 0, 0, 100, 50, new Price() , "Increases your clicks per second.", "images/caf-fein.png");
    }

    // Constructor with specific parameters
    public AutoClicker(JPanel panel, String label, float _delay, int x, int y, int width, int height, Price _price, String _description, String _imgPath) {
        super(label, x, y, width, height, _price, _description, _imgPath);



        panel.add(this);
        panel.add(getPriceLabel());
        panel.add(getAmountUsedLabel());

        delay = _delay;


        cpsLabel = new JLabel(delay + "s: $0");
        cpsLabel.setBounds(x, y + height + 45, width, 20);

        Timer timer = new Timer((int)(_delay * 1000), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autoClickersClick();
            }
        });

        timer.start();

        panel.add(cpsLabel);
    }

    private void autoClickersClick() {
        updateLabels();
        for (int i = 0; i < getAmountUsed(); i++) {
            System.out.println("Click!");
            Clicker.onClick();
        }
    }

    @Override
    public void onClick() throws IOException {
        int currentMoney = Main.getMoney();
        if (currentMoney >= getPrice().getPrice()) {
            Clicker.setNumClicks(currentMoney - getPrice().getPrice());

            // Update the price after the purchase
            getPrice().updatePrice();
            setAmountUsed(getAmountUsed()+1);
            updateLabels();
            updateMoneyLabel();
        } else {
            Main.displayWarning("You do not have enough money for this", "images/tobadsosad.png");
        }
    }

    @Override
    public String toString() {
        return "AutoClicker{" +
                "price=" + getPrice() +
                ", upgradeName='" + getUpgradeName() + '\'' +
                ", description='" + getDescription() + '\'' +
                '}';
    }

    private void updateLabels() {
        getPriceLabel().setText("Price: " + getPrice().getPrice());
        cpsLabel.setText(delay + "s: $" + Clicker.getMoneyPerClick() * getAmountUsed());
        getAmountUsedLabel().setText("You own " + getAmountUsed() + " of these.");
    }
}
