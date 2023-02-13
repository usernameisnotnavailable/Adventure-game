public class Boss {

    private String name;
    private int hp;
    private Weapon bossWeapon;
    private Shield bossShield;

    public Boss(String name, int hp, Weapon bossWeapon, Shield bossShield){
        this.name = name;
        this.hp = hp;
        this.bossWeapon = bossWeapon;
        this.bossShield = bossShield;
    }

    public Boss(Boss source) {
        this.name = source.name;
        this.hp = source.hp;
        /*Ellenőrizni a másolhatóságot */
    }


    public int getBossHp() {
        return this.hp;
    }

    public void setBossHp(int hp) {
        this.hp = hp;
    }
    public String getBossName(){
        return this.name;
    }
    public void setBossName(String name){
        this.name = name;
    }

    public Weapon getBossWeapon() {
        return this.bossWeapon;
    }
    public void setBossWeapon(Weapon weapon){
        this.bossWeapon = weapon;
    }
    
    public Shield getBossShield(){
        return this.bossShield;
    }
    public void setBossShield(Shield shield) {
        this.bossShield= shield;
    }

}