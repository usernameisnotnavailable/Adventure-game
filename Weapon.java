public class Weapon {

    private final String name;
    private int damage;

    public Weapon (String name, int damage){
        this.name = name;
        this.damage = damage;
    }

    public Weapon (Weapon source) {
        this.name = source.name;
        this.damage = source.damage;
    }
    public String getWeaponName(){
        return name;
    }
    public int getWeaponDamage(){
        return damage;
    }
    public void setWeaponDamage(int damage){
        this.damage = damage;
    }

    public String toString(){
        return 
        "Fegyver neve: " + this.name + ".\n" 
        + "Sebzes: " + this.damage + ".\n";
    }

    
}