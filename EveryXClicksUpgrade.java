import javax.swing.*;
import java.io.IOException;

public class EveryXClicksUpgrade extends Upgrade implements Subscriber{

    private int clicks;
    private int moneyMult;
    private int numClicks;

    public EveryXClicksUpgrade(JPanel panel, String label, int _clicks, int _moneyMult, int x, int y, int width, int height, Price _price, String _description, String _imgPath) {
        super(label, x, y, width, height, _price, _description, _imgPath);

        clicks = _clicks;
        moneyMult = _moneyMult;


//        javax.swing.Timer timer = new Timer(1, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                onTimerComplete();
//            }
//        });
//        timer.start();

        panel.add(this);
        panel.add(getPriceLabel());
        panel.add(getAmountUsedLabel());

        Clicker.subscribe(this);
    }

    //This function runs when it's supposed to, but doesn't do anything under the print statement...
    private synchronized void everyX() {
        System.out.println("Run");
        Main.setMoney(Main.getMoney() + (moneyMult * getAmountUsed()));
        numClicks = 0;
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
            everyX();
        }
    }
}
