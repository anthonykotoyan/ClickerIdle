import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PowerUp extends Upgrade {
    private int length;

    private boolean active = false;

    public PowerUp(JPanel panel, int _length, String label,
                   int x, int y, int width, int height, Price _price, String _description,
                   String imgPath) {
        super(label, x, y, width, height, _price, _description, imgPath);

        length = _length;

        panel.add(this);
        panel.add(getPriceLabel());
        panel.add(getAmountUsedLabel());

        updateLabels(active);
    }

    @Override
    public void onClick() throws IOException {
        if (active){
            Main.displayWarning("You can't have 2 of the same power ups active at the same time", "images/nuhuh.jpg");
            return;
        }
        int currentMoney = Main.getMoney();
        if (currentMoney >= getPrice().getPrice()) {
            Clicker.setNumClicks(currentMoney - getPrice().getPrice());

            // Update the price after the purchase
            getPrice().updatePrice();
            setAmountUsed(getAmountUsed()+1);
            updateMoneyLabel();

            startPowerUp();
        } else {
            Main.displayWarning("You do not have enough money for this", "images/tobadsosad.png");
        }
    }

    public void startPowerUp(){
        active = true;
        updateLabels(active);
        Timer timer = new Timer(length * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                active = false;
                stopPowerUp();
                updateLabels(active);
            }
        });

        logic();

        timer.start();
    }

    //Override
    public void logic(){
        System.out.println("Power Up Started");
    }


    //Override
    public void stopPowerUp(){
        System.out.println("Power Up Over");
    }

    private void updateLabels(boolean bool) {
        getPriceLabel().setText("Price: " + getPrice().getPrice());
        if (bool){
            getAmountUsedLabel().setText("Active");
        }
        else {
            getAmountUsedLabel().setText("Not Active");
        }
    }
}
