import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Upgrade extends JButton {

    private int price;
    private String name;
    private String description;

    // Constructor for the button class
    public Upgrade(String label, int x, int y, int width, int height, int _price, String _description) {
        super(label);

        name = label;
        price = _price;
        description = _description;



        // Set the position and size of the button
        this.setBounds(x, y, width, height);
        // Add an action listener for button events
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
    }

    public void onClick(){
        System.out.println(name + " clicked!");
    }
}
