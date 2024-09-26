import javax.swing.*;

public class Main {
    private static int money;
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Custom Button Example");
        int width = 1200;
        int height = 800;

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with null layout for absolute positioning
        JPanel panel = new JPanel();

        // Add custom buttons with specific positions
        ExtraClickUpgrade nashUpgrade = new ExtraClickUpgrade(panel, 1,"Nash", 0, 0, 100, 100, 10, "Our Beautiful Principle", "nash.jpg");
        Clicker guillaumeClicker = new Clicker(panel, width/2 - 50, height/2 - 50, 100,100, "guilliame.jpg");




        frame.add(panel);
        frame.setVisible(true);


    }
    public static void setMoney(int numClicks){

        money = numClicks;
        System.out.println(money);
    }
    public static int getMoney(){

        return money;
    }
}
