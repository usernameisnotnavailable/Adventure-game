/*
directions:
1 - up
2 - right
3 - down
4 - left
 */

public class Locator {

    private final Player player;
    public Locator(Player player) {
        this.player = player;
    }

    protected void located(AI ai){
        int pX = player.getPositionX();
        int pY = player.getPositionY();
        int aY = ai.getPositionY();
        int aX = ai.getPositionX();

        if (aY == pY && Math.abs(pX - aX) <= 5 || aX == pX && Math.abs(pY - aY) <= 5){
           int direction = checkDirection(aX, aY, pX, pY);
            if (direction != 0) {
                ai.setDirection(direction);
                ai.setLocated(true);
            } else {
                ai.setLocated(false);
            }
        } else {
            ai.setLocated(false);
        }
    }

    private int checkDirection(int aX, int aY, int pX, int pY){

        int xDiff = aX - pX;
        int yDiff = aY - pY;

        // jatekos jobbra van a geptol
        if (xDiff < 0){
            for (int i = 1; i <= Math.abs(xDiff); i++) {
                if (GameMap.locations[aY][aX + i] == 1) {
                    break;
                }
                if (aY == pY && aX + i == pX) {
                    System.out.println("Spotted: 2 - right");
                    return 2;
                }
            }
        }
        // jatekos balra van a geptol
        if (xDiff > 0){
            for (int i = 1; i <= xDiff; i++) {
                if (GameMap.locations[aY][aX - i] == 1) {
                    break;
                }
                if (aY == pY && aX - i == pX) {
                    System.out.println("Spotted: 4 - left");
                    return 4;
                }
            }
        }
        // jatekos a gep alatt
        if (yDiff < 0){
            for (int i = 1; i <= Math.abs(yDiff); i++) {
                if (GameMap.locations[aY + i][aX] == 1) {
                    break;
                }
                if (aY + i == pY && aX == pX) {
                    System.out.println("Spotted: 3 - down");
                    return 3;
                }
            }
        }
        // jatekos a gep felett
        if (yDiff > 0){
            for (int i = 1; i <= yDiff; i++) {
                if (GameMap.locations[aY - i][aX] == 1) {
                    break;
                }
                if (aY - i == pY && aX == pX) {
                    System.out.println("Spotted: 1 - up");
                    return 1;
                }
            }
        }
        return 0;
    }
}
