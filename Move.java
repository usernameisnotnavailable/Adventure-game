public class Move {

    public static void move(int moveDirection, Player mover){
        int y = mover.getPositionY();
        int x = mover.getPositionX();
        if (playerFreeToMove(moveDirection, x, y)) playerActualMove(moveDirection, mover);
    }
    private static void playerActualMove(int moveDirection, Player mover){
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
    private static boolean playerFreeToMove(int moveDirection, int x, int y){

        return switch (moveDirection) {
            case 1 -> GameMap.locations[(y - 1)][x] != 1;
            case 2 -> GameMap.locations[y][(x + 1)] != 1;
            case 3 -> GameMap.locations[(y + 1)][x] != 1;
            case 4 -> GameMap.locations[y][(x - 1)] != 1;
            default -> false;
        };
    }


}
