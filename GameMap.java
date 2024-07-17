

public class GameMap {
    public static final int mapWidth = 40;
    public static final int mapHeight = 25;
    public static int[][] locations;
    public static int[][] playerMap;
    public GameMap(){
        locations = new int[mapHeight][mapWidth];
        playerMap = new int[mapHeight][mapWidth];
    }
    public void randomMapGenerator(int chanceForWall){

        for (int i = 0; i < mapWidth; i++){
            for (int j = 0; j < mapHeight; j++){
                locations[0][i] = 1;
                locations[j][0] = 1;
                locations[mapHeight-1][i] = 1;
                locations[j][mapWidth-1] = 1;
                if (i > 1 && j > 1 && i < mapWidth-1 && j < mapHeight -1){
                    locations[1][i] = randomNumber01(chanceForWall);
                    locations[j][1] = randomNumber01(chanceForWall);
                }
            }
        }
        for (int i = 2; i < mapHeight-2; i++){
            for (int j = 2; j < mapWidth-2; j++){

                if (locations[i-1][j] == 0 && locations[i-1][j+1] !=0 || locations[i-1][j-1] == 0 && locations[i][j-1] != 0 || locations[i][j-1] == 0 && locations[i+1][j-1] !=0) {
                    locations[i][j] = 0;
                } else if (locations[i+1][j-1] == 0 && locations[i][j-1] == 0 && locations[i-1][j-1] == 0 && locations[i-1][j] == 0 && locations[i-1][j+1] == 0){
                    locations[i][j] = 1;
                } else {
                    locations[i][j] = randomNumber01(chanceForWall);
                }
            }
        }
        for (int i = 1; i < mapHeight-1; i++) {
            locations[mapHeight-2][i] = randomNumber01(chanceForWall);
            locations[i][mapWidth-2] = randomNumber01(chanceForWall);
        }
        //Spawn létrehozás
        setSpawn();
        //Lényekkel feltöltés
        fillCreatures();
        /*Játékos ködös térkép készítés*/
        playerMapInitializer(playerMap, mapHeight, mapWidth);
    }

    public void randomMapGenerator() {
        int chanceForWall = 4;
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                locations[0][i] = 1;
                locations[j][0] = 1;
                locations[mapHeight - 1][i] = 1;
                locations[j][mapWidth - 1] = 1;
                if (i > 1 && j > 1 && i < mapWidth - 1 && j < mapHeight - 1) {
                    locations[1][i] = randomNumber01(chanceForWall);
                    locations[j][1] = randomNumber01(chanceForWall);
                }
            }
        }
        for (int i = 2; i < mapHeight - 2; i++) {
            for (int j = 2; j < mapWidth - 2; j++) {
                if (locations[i - 1][j] == 0 && locations[i - 1][j + 1] != 0 || locations[i - 1][j - 1] == 0 && locations[i][j - 1] != 0 || (locations[i][j - 1] == 0 && locations[i + 1][j - 1] != 0)) {
                    locations[i][j] = 0;
                } else if (locations[i + 1][j - 1] == 0 && locations[i][j - 1] == 0 && locations[i - 1][j - 1] == 0 && locations[i - 1][j] == 0 && locations[i - 1][j + 1] == 0) {
                    locations[i][j] = 1;
                } else {
                    locations[i][j] = randomNumber01(chanceForWall);
                }
            }
        }

        for (int i = 0; i < mapWidth; i++){
            locations[23][i] = 1;
        }
        //Spawn létrehozás
        //setSpawn();
        /*Játékos ködös térkép készítés*/
        //playerMapInitializer(playerMap, mapHeight, mapWidth);
    }
    public static int randomNumber01(int chanceForWall){                                                     /*random number térkép készítéshez */
        double randomNumber = Math.random()*10;
        if (randomNumber > chanceForWall) {
            return 1;
        }
        return 0;
    }
    public void playerMapInitializer(int[][] playerMap, int mapHeight, int mapWidth){
        for (int i = 0; i < mapHeight; i++){
            for (int j = 0; j < mapWidth; j++){
                playerMap[i][j] = 9;
            }
        }
        playerMap[10][10] = 8;
    }
    public void setSpawn(){
        locations[10][10] = 0;
        locations[10][11] = 0;
        locations[9][10] = 0;
        locations[11][10] = 0;
        locations[10][9] = 0;
    }


    public void fillCreatures(){
        int random;
        int shopPlacement = 1;
        int minionPlacement = randomNumber510();
        int bossPlacement = randomNumber510();
        int giftPlacement = randomNumber510();
        int trapPlacement = randomNumber510();
        int sum = shopPlacement+minionPlacement+bossPlacement+giftPlacement+trapPlacement;
        while (sum > 0){
            int i = randomNumberHeight(mapHeight);
            int j = randomNumberWidth(mapWidth);
            sum = shopPlacement+minionPlacement+bossPlacement+giftPlacement+trapPlacement;
            if(locations[i][j] == 0){
                random = randomNumber06();
                switch(random){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2: if(trapPlacement>0){
                        locations[i][j] = 2;    /* csapda */
                        trapPlacement -= 1;
                    }
                        break;
                    case 3: if(minionPlacement>0){
                        locations[i][j] = 3;    /* minion */
                        minionPlacement -= 1;
                    }
                        break;
                    case 4: if(bossPlacement>0){
                        locations[i][j] = 4;    /* boss */

                        bossPlacement -= 1;
                    }
                        break;
                    case 5: if(giftPlacement>0){
                        locations[i][j] = 5;    /* ajándék */
                        giftPlacement -= 1;
                    }
                        break;
                    case 6: if(shopPlacement>0){
                        locations[i][j] = 6;    /* bolt */
                        shopPlacement -= 1;
                    }
                        break;
                }
            }
        }
    }
    public static int randomNumberHeight(int mapHeight){                                                                /*diceroll */
        double roll = Math.random() * mapHeight;
        return (int)roll;
    }
    public static int randomNumberWidth(int mapWidth){                                                                /*diceroll */
        double roll = Math.random()*mapWidth;
        return (int)roll;
    }

    public static int randomNumber510(){
        double roll = Math.random()*6+5;
        return (int)roll;
    }
    public static int randomNumber06(){
        double roll = Math.random()*7;
        return (int)roll;
    }
}
