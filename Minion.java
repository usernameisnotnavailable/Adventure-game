public class Minion {

    private final String name;
    private int hp;
    private Weapon minionWeapon;
    private Shield minionShield;

    public Minion(String name, int hp, Weapon minionWeapon, Shield minionShield){
        this.name = name;
        this.hp = hp;
        this.minionWeapon = minionWeapon;
        this.minionShield = minionShield;
    }

    public Minion(Minion source){
        this.name = source.name;
        this.hp = source.hp;
        /*ellenőrinzni kell a másolhatóságot */
    }

    public String getMinionName(){
        return this.name;
    }

    public void setMinionHp(int minionHp){
        this.hp = minionHp;
    }
    public int getMinionHp(){
        return this.hp;
    }

    public Weapon getWeapon() {
        return this.minionWeapon;
    }

    public void setWeapon(Weapon weapon) {
        this.minionWeapon = weapon;
    }

    public Shield getShield() {
        return this.minionShield;
    }

    public void setShield(Shield shield) {
        this.minionShield = shield;
    }
    
}
