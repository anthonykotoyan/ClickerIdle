import javax.swing.*;

public class MultiplyPowerUp extends PowerUp{

    private int multiplier;

    public MultiplyPowerUp(JPanel panel, int _length, int _multiplier, String label, int x, int y, int width, int height, Price _price, String _description, String imgPath) {
        super(panel, _length, label, x, y, width, height, _price, _description, imgPath);
        multiplier = _multiplier;
    }

    @Override
    public void logic(){
        Clicker.setMoneyPerClick(Clicker.getMoneyPerClick() * multiplier);
    }

    @Override
    public void stopPowerUp(){
        Clicker.setMoneyPerClick(Clicker.getMoneyPerClick() / multiplier);
    }
}
