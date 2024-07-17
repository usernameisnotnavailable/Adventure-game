import javax.swing.*;
import java.awt.*;

public class Battlefield extends JComponent {
    private final JButton attack;

    public Battlefield() {
        int WIDTH = 1450;
        int HEIGHT = 750;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));


        attack = new JButton("Attack");
        attack.setBounds(50,50,100,30);
        add(attack);

        setVisible(true);
    }
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

    }

}
