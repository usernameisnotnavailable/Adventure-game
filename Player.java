public class Player{

    private String name;
    private int hp;
    private int mana;
    private int gold;
    private Spell spell;
    private Weapon playerWeapon;
    private Shield playerShield;
    private int positionX;
    private int positionY;
    private int direction;

    public Player(String name, int hp, int mana, int gold, Weapon playerWeapon, Shield playerShield, Spell spell) {
        this.name = name;
        this.hp = hp;
        this.gold = gold;
        this.spell = spell;
        this.playerWeapon = playerWeapon;
        this.playerShield = playerShield;
        this.positionX = 10;
        this.positionY = 10;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getHp(){
        return hp;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public int getMana(){
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getGold(){
        return gold;
    }
    public void setGold(int gold){
        this.gold = gold;
    }


    public int getPositionX() {
        return positionX;
    }


    public int getDirection() {
        return direction;
    }


    public void setDirection(int direction) {
        this.direction = direction;
    }


    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public Spell getSpell(){
        return this.spell;
    }
    public void setSpell(Spell spell) {
        this.spell = spell;
    }
    public Weapon getWeapon() {
        return this.playerWeapon;
    }
    public void setWeapon(Weapon weapon){
        this.playerWeapon = weapon;
    }
    public Shield getShield() {
        return this.playerShield;
    }
    public void setShield(Shield shield){
        this.playerShield = shield;
    }

    public String toString(){
        return "Jatekos neve: " + this.name + ".\n" 
        + "Jatekos eletero: " + this.hp + ".\n"
        + "Jatekos aranya: " + this.gold + ".\n"
        + "Jatekos mana: " + this.mana + ".\n"
        + "Jatekos felszereles: \n" 
        + this.playerWeapon
        + this.playerShield
        + spell;
    }
}