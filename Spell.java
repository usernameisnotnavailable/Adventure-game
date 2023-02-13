public class Spell {
    private String name;
    private int damage;
    private int manaCost;


    public Spell (String name, int damage, int manaCost){
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    public Spell(Spell source) {
        this.name = source.name;
        this.damage = source.damage;
        this.manaCost = source.manaCost;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getManaCost() {
        return this.manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public String toString() {
        return "Neve: " + this.name + ". \nSebzese: " + this.damage + " .\nmana: " + this.manaCost;
    }

}
