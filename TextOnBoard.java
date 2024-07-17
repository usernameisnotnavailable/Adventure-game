import javax.swing.*;
import java.awt.*;

public class TextOnBoard extends JComponent {

    private String rightSideText = "";
    private final int xPosition = 1220;
    private final int yPosition = 20;
    private Player jatekos;


    public TextOnBoard(Player jatekos){
        this.jatekos = jatekos;
    }
    public TextOnBoard(){

    }
    public void setRightSideText(String text){
        rightSideText = text;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

 /*       textHandler(graphics, "Name: " + jatekos.getName(), xPosition, yPosition);
        textHandler(graphics, "Health: " + jatekos.getHp(), xPosition, yPosition*2);
        textHandler(graphics, "Mana : " + jatekos.getMana(), xPosition, yPosition*3);*/
/*        textHandler(graphics, "Items.Weapon : " + jatekos.getWeapon().getWeaponName(), xPosition, yPosition*4);
        textHandler(graphics, "Items.Weapon damage : " + jatekos.getWeapon().getWeaponDamage(), xPosition, yPosition*5);
        textHandler(graphics, "Items.Armor : " + jatekos.getShield().getName(), xPosition, yPosition*6);
        textHandler(graphics, "Items.Armor defense : " + jatekos.getShield().getDefense(), xPosition, yPosition*7);
        textHandler(graphics, "Spells.Spell name : " + jatekos.getSpell().getName(), xPosition, yPosition*8);
        textHandler(graphics, "Spells.Spell damage : " + jatekos.getSpell().getDamage(), xPosition, yPosition*9);
        textHandler(graphics, "Gold : " + jatekos.getGold(), xPosition, yPosition*10);
        textHandler(graphics, "Health potion : " + jatekos.getHealtPotionNumber(), xPosition, yPosition*11);
        textHandler(graphics, "Mana potion : " + jatekos.getManaPotionNumber(), xPosition, yPosition*12);*/
        textHandler(graphics, rightSideText, xPosition, 375);
        // xPosition y pedig 375
    }
    public void textHandler(Graphics graphics, String rightSideText, int xPosition, int yPosition){
        graphics.setColor(Color.BLACK);
        graphics.drawString(rightSideText, xPosition, yPosition);
    }
}
