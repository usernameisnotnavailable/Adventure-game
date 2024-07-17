
public class Boss implements AI {

    private String name;
    private int hp;
    private Weapon bossWeapon;
    private Shield bossShield;
    private int positionX;
    private int positionY;
    private int direction;
    private boolean located;
    private actions action;
    public enum actions {
        CASTING,
        ATTACKING,
        DEFENDING,
        CHASING,
        WANDERING
    }

    public actions getAction(){
        return action;
    }

    public void setAction(actions action){
        this.action = action;
    }


    public Boss(){
        this.name = "alma";
        this.hp = 10;
        this.action = actions.WANDERING;
        spawn();
    }

    public boolean located() {
        return located;
    }

    public void setLocated(boolean located) {
        if (located) action = actions.CASTING;
        if(!located) action = actions.WANDERING;
        this.located = located;
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

    public void spawn() {
        boolean spawned = false;
        while (!spawned) {
            int randomX = (int) (Math.random() * GameMap.mapWidth);
            int randomY = (int) (Math.random() * GameMap.mapHeight);
            if (GameMap.locations[randomY][randomX] == 0) {
                this.positionX = randomX;
                this.positionY = randomY;
                spawned = true;
            }
        }
    }

    @Override
    public void setPositionX(int positionX) {
        if(action == actions.CASTING){
            return;
        }
        this.positionX = positionX;
    }

    @Override
    public void setPositionY(int positionY) {
        if(action == actions.CASTING){
            return;
        }
        this.positionY = positionY;
    }

    @Override
    public int getPositionY() {
        return positionY;
    }

    @Override
    public int getPositionX() {
        return positionX;
    }

    @Override
    public int getDirection() {
        return direction;
    }

    @Override
    public void setDirection(int direction) {
        this.direction = direction;
    }


}