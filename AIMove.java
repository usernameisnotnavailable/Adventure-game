import java.util.Random;

public class AIMove {
    static Random random = new Random();

    private static void AIActualMove(int moveDirection, AI mover){
        int y = mover.getPositionY();
        int x = mover.getPositionX();

        switch (moveDirection) {
            case 1: mover.setPositionY(--y);
                break;
            case 2: mover.setPositionX(++x);
                break;
            case 3: mover.setPositionY(++y);
                break;
            case 4: mover.setPositionX(--x);
                break;
        }
    }

    private static boolean aiFreeToMove(int moveDirection, AI mover){
        int y = mover.getPositionY();
        int x = mover.getPositionX();

        return switch (moveDirection) {
            case 1 -> GameMap.locations[(y - 1)][x] != 1;
            case 2 -> GameMap.locations[y][(x + 1)] != 1;
            case 3 -> GameMap.locations[(y + 1)][x] != 1;
            case 4 -> GameMap.locations[y][(x - 1)] != 1;
            default -> false;
        };
    }

    public static void aiMove(AI mover){
        int direction = mover.getDirection();
        if (!mover.located() && random.nextInt(0,10) > 6) {
            direction = changeDirection(direction);
            mover.setDirection(direction);
        }

        while(!aiFreeToMove(direction, mover)){
                direction = changeDirection(direction);
            }
        AIActualMove(direction, mover);
    }

    /*
directions:
1 - up
2 - right
3 - down
4 - left
 */

    public static int changeDirection(int headingDirection){
        int randomNumber = random.nextInt(0,10);

        if (headingDirection == 1 || headingDirection == 3){
            if (randomNumber >= 5){
                headingDirection = 4;
            } else {
                headingDirection = 2;
            }
        } else {
            if (randomNumber >= 5){
                headingDirection = 3;
            } else{
                headingDirection = 1;
            }
        }

        return headingDirection;

    }
}
