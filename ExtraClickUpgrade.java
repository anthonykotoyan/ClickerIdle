import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExtraClickUpgrade extends Upgrade {
    private int extraClicks;




    // Constructor for an upgrade with an image
    public ExtraClickUpgrade(JPanel panel, int _extraClicks, String label, int x, int y, int width, int height,
                             int _price, String _description, String imgPath) {
        super(label, x, y, width, height, _price, _description, imgPath);

        extraClicks = _extraClicks;

        panel.add(this);
    }

    //Basic onCLick (Override in subclasses)
    public void onClick(){
        int currentMoney = Main.getMoney();
        if (currentMoney>=getPrice()){
            Clicker.addMoneyPerClick(extraClicks);
            Clicker.setNumClicks(currentMoney-getPrice());

        } else{
            System.out.println("You do not have enough money for the " + getUpgradeName() + " Upgrade!");
        }
    }

    @Override
    public String toString() {
        return "Upgrade{" +
                "price=" + getPrice() +
                ", upgradeName='" + getUpgradeName() + '\'' +
                ", description='" + getDescription()+ '\'' +
                '}';
    }
}
