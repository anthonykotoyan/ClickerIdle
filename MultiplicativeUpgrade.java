import javax.swing.*;
import java.io.IOException;

public class MultiplicativeUpgrade extends Upgrade implements Subscriber{

    private int numClicks;
    private int clicks;
    private int mult;

    public MultiplicativeUpgrade(JPanel panel, String label, int _clicks, int _mult, int x, int y, int width, int height, Price _price, String _description, String _imgPath) {
        super(label, x, y, width, height, _price, _description, _imgPath);
        clicks = _clicks;
        mult = _mult;

        panel.add(this);
        panel.add(getPriceLabel());
        panel.add(getAmountUsedLabel());

        Clicker.subscribe(this);
    }

    @Override
    public void onClick() throws IOException {
        int currentMoney = Main.getMoney();
        if (currentMoney >= getPrice().getPrice()) {
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
        getAmountUsedLabel().setText("You own " + getAmountUsed() + " of these.");
    }

    @Override
    public void ping() {
        numClicks += 1;

        if (numClicks == clicks) {
            changePerc();
        }
    }

    public void changePerc(){
        System.out.println(Clicker.getMoneyPerClick());
        Clicker.setMoneyPerClick((int) (Clicker.getMoneyPerClick() * mult));
        System.out.println(Clicker.getMoneyPerClick());
        numClicks = 0;
    }
}
