public class Shield {

    private String name;
    private int defense;

    public Shield (String name, int defense) {
        this.name = name;
        this.defense = defense;
    }
    public Shield(Shield source) {
        this.name = source.name;
        this.defense = source.defense;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
    public String toString(){
        return "Pajzs neve: " + this.name + ".\n" 
        + "Vedelem: " + this.defense + ".\n";
    }    
}
