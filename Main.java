import java.util.Scanner;
import java.util.Arrays;
public class Main {
    



public static void main(String[] args) {

    /***********************************************************Inicializó rész*************************************************************/
    Scanner scan = new Scanner(System.in);
    int playerWeaponInt = 0;
    int playerShieldInt = 0;
    int minionWeaponInt = 0;
    int minionShieldInt = 0;
    int bossWeaponInt = 0;
    int bossShieldInt = 0;
    int spellLevel = 0;
    int healthPotionNumber = 2;
    int manaPotionNumber = 0;
    int userChoice = 0;
    int positionHorizontal = 10;
    int positionVertical = 10;
    String[] giftHpText = new String[] {"Radborult valami edes illatu folyadek ","A hold szerencses szogben esik az arcodra ","Kellemes melodiat hallasz ami feltoltodessel hat ","Veletlenul hozzaertel egy selymes kendohoz ","Megkostoltal egy elhagyatott fiolaban talalhato italt ","Atleptel egy vizesesen ","Egyutt allnak a csillagok "};
    Weapon[] playerWeapon = new Weapon[] {
        new Weapon("kis tor", 5),
        new Weapon("vas kard", 10),
        new Weapon("szeletelo szablya", 15),
        new Weapon("legendas landzsa", 20),
        new Weapon("zuzo buzogany", 25)
    };
    Shield[] playerShield = new Shield[] {
        new Shield("fa pajzs", 5),
        new Shield("bronz pajzs", 10),
        new Shield("vas pajzs", 15),
        new Shield("gyemant pajzs", 20),
        new Shield("tolgypajzsos szorin fatorzse", 25)
    };
    Weapon[] minionWeapon = new Weapon[] {
        new Weapon("csontkar", 3),
        new Weapon("fa lapat", 7),
        new Weapon("rozsdas lanc", 12),
        new Weapon("fertozo fejsze", 15),
        new Weapon("tuskes buzogany", 20)
    };
    Shield[] minionShield = new Shield[] {
        new Shield("korhadt fa", 3),
        new Shield("kuka fedel", 7),
        new Shield("rozsdas vaslap", 12),
        new Shield("acel lemez", 15),
        new Shield("titan pajzs", 20)
    };
    Weapon[] bossWeapon = new Weapon[] {
        new Weapon("hosszu kar", 5),
        new Weapon("rez szablya", 12),
        new Weapon("vas lancok", 18),
        new Weapon("acel fejsze", 23),
        new Weapon("a halal buzoganya", 30)
    };
    Shield[] bossShield = new Shield[] {
        new Shield("fa pajzs", 5),
        new Shield("polirozott bronz pajzs", 12),
        new Shield("rozsdas vas pajzs", 18),
        new Shield("veres gyemant pajzs", 23),
        new Shield("a diadal pajzsa", 30)
    };
    String[] minionNames = new String[] {
        new String("troll"),
        new String("mumia"),
        new String("vampir"),
        new String("csontváz"),
        new String("zombi"),
        new String("vérfarkas")
    };   
    String[] bossNames = new String[] {
        new String("ordog"),
        new String("Demona"),
        new String("Hades"),
        new String("Zordon"),
        new String("Turbo"),
        new String("Jafar"),
    };    
    Spell[] spell = new Spell[]{
        new Spell("kis tuskek",1,1),
        new Spell("tuzgolyo", 3, 2),
        new Spell("villam", 5, 3)
    };

    
    /***********************************************************Random térkép készítés*************************************************************/
   
    int[][] locations = new int[20][20];

    for (int i = 0; i < locations.length; i++){
        locations[0][i] = 1;
        locations[i][0] = 1;
        locations[19][i] = 1;
        locations[i][19] = 1;
        locations[1][i] = randomNumber01();
        locations[i][1] = randomNumber01();
    }
    for (int i = 2; i < locations.length - 1; i++){
        for (int j = 2; j < locations.length - 1; j++){

                if (locations[i-1][j] == 0 && locations[i-1][j+1] !=0) {
                    locations[i][j] = 0;
                }else if (locations[i-1][j-1] == 0 && locations[i][j-1] != 0){
                    locations[i][j] = 0;
                } else if (locations[i][j-1] == 0 && locations[i+1][j-1] !=0){
                    locations[i][j] = 0;
                } else if (locations[i+1][j-1] == 0 && locations[i][j-1] == 0 && locations[i-1][j-1] == 0 && locations[i-1][j] == 0 && locations[i-1][j+1] == 0){
                    locations[i][j] = 1;
                } else {
                    locations[i][j] = randomNumber01();
                } 
            }
        }
        for (int i = 1; i < 19; i++) {
            locations[18][i] = randomNumber01();
            locations[i][18] = randomNumber01();
        }

        /*Printing map*/
        /*for (int i = 0; i <locations.length; i++){
            System.out.print("\n");
            for (int j = 0; j < locations.length; j++){
            System.out.print(locations[i][j]);
            }
        }
        */
    /***********************************************************Térkép feltöltése lényekkel és cuccokkal*************************************/
    
    int random;
    int shopPlacement = 1;
    int minionPlacement = randomNumber510();
    int bossPlacement = randomNumber510();
    int giftPlacement = randomNumber510();
    int trapPlacement = randomNumber510();
    int sum = shopPlacement+minionPlacement+bossPlacement+giftPlacement+trapPlacement;

    while (sum > 0){
        int i = randomNumber119();
        int j = randomNumber119();
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
        /***************************************************SPAWN pozíció*****************************************************************/
            locations[10][10] = 0;
            locations[10][11] = 0;
            locations[10][12] = 0;
            locations[9][10] = 0;
            locations[8][10] = 0;
            locations[11][10] = 0;
            locations[12][10] = 0;
            locations[10][9] = 0;
            locations[10][8] = 0;
    /***********************************************************Játékos térkép*************************************************************/

    int[] playerMoveChoice = new int[2];    
    String[] wallOrPath = new String[4];

    String[][] playerMap = new String[20][20];
        for (int i = 0; i < playerMap.length; i++){
            for (int j = 0; j < playerMap.length; j++){
                playerMap[i][j] = "X";
            }
        }
        playerMap[10][10] = "O";

    /***********************************************************Inicializó rész vége*************************************************************/
     /***********************************************************Inicializó rész vége*************************************************************/
      /***********************************************************Inicializó rész vége*************************************************************/
       /***********************************************************Inicializó rész vége*************************************************************/
        /***********************************************************Inicializó rész vége*************************************************************/
    Player jatekos = new Player("name", 50, 10, playerWeapon[playerWeaponInt], playerShield[playerShieldInt], spell[spellLevel]);

    locations[10][10] = 0;
    locations[10][11] = 5;
    locations[10][12] = 5;
    locations[9][10] = 5;
    locations[8][10] = 5;
    locations[11][10] = 5;
    locations[12][10] = 5;
    locations[10][9] = 5;
    locations[10][8] = 5;

    
    for (int i = 0; i <locations.length; i++){
        System.out.print("\n");
        for (int j = 0; j < locations.length; j++){
        System.out.print(locations[i][j]);
        }
    }

        /* Kezdeti térkép frissítés */
    wallOrPath = returnWallOrPath(positionHorizontal, positionVertical, locations);
    playerMap = updatePlayerMap(wallOrPath, playerMap, positionVertical, positionHorizontal);
    /* Kezdeti térkép frissítés vége */
    
    /* System.out.println("Udvozollek dicso harcos, a legendak barlangjaban.");
    System.out.print("Add meg hogyan szolithatlak: ");
    jatekos.setName(scan.next()); 
    */

    /*  Maga a játék */
    while (jatekos.getHp() > 0){
        /* Random generál lényt ellenőrizni majd, hogy milyen lesz */
        int tempMinionHp = minionHp();  
        String tempMinionName = minionNames[minionWeaponInt]; 
        Minion minion = new Minion(tempMinionName, tempMinionHp, minionWeapon[minionWeaponInt], minionShield[minionShieldInt]);         
    
        int tempBossHp = bossHp();
        String tempBossName = bossNames[bossWeaponInt];
        Boss boss = new Boss(tempBossName, tempBossHp, bossWeapon[bossWeaponInt], bossShield[bossShieldInt]); 

        /* Kis térkép megjelenítése */
        showMiniMap(playerMap); 
        

        System.out.println("\nmerre mesz?");
        /* Lehetőségek megmutatása */
        showMoveOptions(positionHorizontal, positionVertical, locations);

        /* Kell térkép nagyban, statok mutatása */

        /* Felhasználó döntés */
        userChoice = scan.nextInt();
        /* Ellenőrzi a lépéseket és visszaadja a az új pozíciót */
        playerMoveChoice = playerMove(positionHorizontal, positionVertical, locations, userChoice, playerMap, jatekos);
        positionVertical = playerMoveChoice[0];
        positionHorizontal = playerMoveChoice[1];
        /* ellenőrzi, hogy fal van e az újpozícioónál és visszaadja a karaktereket */
        wallOrPath = returnWallOrPath(positionHorizontal, positionVertical, locations);
        /*Itt hívja meg az eseményt */
        switch (locations[positionVertical][positionHorizontal]) {
            case 2: randomTrap(jatekos, minionWeapon, minionShield, bossWeapon, bossShield);
                    locations[positionVertical][positionHorizontal] = 0;
                    break;
            case 3: minionFight(jatekos, minion, playerWeaponInt, playerShieldInt, spellLevel, minionWeaponInt, minionShieldInt, healthPotionNumber, manaPotionNumber);
                    locations[positionVertical][positionHorizontal] = 0;
                    break;
            case 4: bossFight(jatekos, boss, playerWeaponInt, playerShieldInt, bossWeaponInt, bossShieldInt, spellLevel, healthPotionNumber, manaPotionNumber);
                    locations[positionVertical][positionHorizontal] = 0;
                    break;
            case 5: randomGift(jatekos, playerWeapon, playerShield);
                    locations[positionVertical][positionHorizontal] = 0;
                    break;
            case 6: /* Shop */
                    break;
        
        }
        /*Játékos térkép frissítése */
        playerMap = updatePlayerMap(wallOrPath, playerMap, positionVertical, positionHorizontal);

    }

    
                                  /***************** Ez kerül majd az ajándék vagy a bolt szekcióhoz **************************/ 
                    /*
                       switch (diceRoll()) {
                                case 1: System.out.println("Uj eletero potit kaptal");
                                        healthPotionNumber += 1;
                                        break;
                                case 2: System.out.println("Uj pajzsot kaptal");
                                        playerShieldInt += 1;
                                        jatekos.setShield(playerShieldInt, playerShield[playerShieldInt]);
                                        break;
                                case 3: System.out.println("Uj fegyvert kaptal");;
                                        playerWeaponInt += 1;
                                        jatekos.setWeapon(playerWeaponInt, playerWeapon[playerWeaponInt]);
                                        break;
                                case 4: System.out.println("Uj eletero potit kaptal");
                                        healthPotionNumber += 1;
                                        break;
                                case 5: System.out.println("Uj mana potit kaptal");
                                        manaPotionNumber += 1;
                                        break;
                                case 6: System.out.println("Uj eletero-, mana- potit és varazslatot kaptal");
                                        spellLevel += 1;
                                        jatekos.setSpell(spell[spellLevel]);
                                        break;
                                default: System.out.println("Ennek nem igy kell lennie");
                                        break;

     } */

    scan.close();
    }   
/***********************************************************Funkciók*************************************************************/
/***********************************************************Funkciók*************************************************************/
/***********************************************************Funkciók*************************************************************/
/***********************************************************Funkciók*************************************************************/
    public static int randomNumber06(){
        double roll = Math.random()*7;
        return (int)roll;
    }
    public static int randomNumber14(){
        double roll = Math.random()*4+1;
        return (int)roll;
    }
    public static int randomNumber510(){
        double roll = Math.random()*6+5;
        return (int)roll;
    }
    public static int randomNumber119(){                                                                /*diceroll */
        double roll = Math.random()*20;
        return (int)roll;
    }
    public static int randomNumber01(){                                                     /*random number térkép készítéshez */
        double randomNumber = Math.random()*10;
        if (randomNumber > 4) {
            return 1;
        }
        return 0;
    }
    public static int diceRoll(){                                                                /*diceroll */
        double roll = Math.random()*6+1;
        return (int)roll;
    }
    public static int minionHp() {                                                              /*minion hp */
        double roll = Math.random() * 40 + 10;
        return (int) roll; 
    }
    public static int bossHp() {                                                              /*boss hp */
        double roll = Math.random() * 60 + 40;
        return (int) roll; 
    }
    public static void checkDeath(Player jatekos){                              /* Ellenőrzi hogy meghalt-e a játékos */
        if (jatekos.getHp() <= 0){
            System.out.println("Sajnos meghaltal");
            System.exit(0);
        }
    }
    public static void useHealthPotion(Player jatekos, int healthPotionNumber){
    if (healthPotionNumber <=0) {
        System.out.println("Nincs eletero potid");
        } else {
        healthPotionNumber -=1;
        jatekos.setHp(jatekos.getHp() + 20);
        System.out.println("Elhasznaltal egy eletero potit. 20-al novelted az eleterod");
        }
    }
    public static void useManaPotion(Player jatekos, int manaPotionNumber) {
        if (manaPotionNumber <=0) {
            System.out.println("Nincs mana potid");
            } else {
            manaPotionNumber -= 1;
            jatekos.setMana(jatekos.getMana() + 10);
            System.out.println("Elhasznaltal egy mana potit. 10 -el novelted a manad");
        }
    }

    public static void playerWeaponDamageUpgrade(Weapon[] playerWeapon) {                          /*játékos Fegyver felfejlesztés */
        for (int i = 0; i < playerWeapon.length; i++) {
            playerWeapon[i].setWeaponDamage(playerWeapon[i].getWeaponDamage() + 5);
        }
    }
    public static void playerShieldDefenseUpgrade(Shield[] playerShield) {                        /*játékos Pajzs felfejlesztés */
        for (int i = 0; i < playerShield.length; i++){
            playerShield[i].setDefense(playerShield[i].getDefense() + 5);
        }
    }

    public static void minionWeaponDamageUpgrade(Weapon[] minionWeapon) {                           /*minion fegyver felfejlesztés */
        for (int i = 0; i < minionWeapon.length; i++) {
            minionWeapon[i].setWeaponDamage(minionWeapon[i].getWeaponDamage() + 4);
        }
    }
    public static void minionShieldDefenseUpgrade(Shield[] minionShield) {                /*minion pajzs fejlesztés */           
        for (int i = 0; i < minionShield.length; i++) {
            minionShield[i].setDefense(minionShield[i].getDefense() + 2);
        }
    }

    public static void bossWeaponDamageUpgrade(Weapon[] bossWeapon) {               /* boss fegyver fejlesztés */
        for (int i = 0; i < bossWeapon.length; i++) {
            bossWeapon[i].setWeaponDamage(bossWeapon[i].getWeaponDamage() + 5);
        }
    }
    public static void bossShieldDefenseUpgrade(Shield[] bossShield) {              /*boss shield fejlesztés */
        for (int i = 0; i < bossShield.length; i++) {
            bossShield[i].setDefense(bossShield[i].getDefense() + 3);
        }
    }

/***********************************************************Térkép funkciók*************************************************************/

public static void showMap(String[][] playerMap) {
    
    
    for (int i = 0; i < playerMap.length; i++){
        System.out.print("\n\n");
        for (int j = 0; j < playerMap.length; j++){
            System.out.print(playerMap[i][j]);
            System.out.print("\t");
        }
    }
}
public static void showMiniMap(String[][] playerMap) {
    
    
    for (int i = 0; i < playerMap.length; i++){
        System.out.print("\n");
        for (int j = 0; j < playerMap.length; j++){
            System.out.print(playerMap[i][j]);
           }
    }
}

public static String[][] updatePlayerMap(String[] wallOrPath, String[][] playerMap, int positionVertical, int positionHorizontal){
    String up = wallOrPath[0];
    String right = wallOrPath[1];
    String left = wallOrPath[2];
    String down = wallOrPath[3];

    playerMap[positionVertical][positionHorizontal] = "O";
    playerMap[(positionVertical-1)][positionHorizontal] = up;
    playerMap[positionVertical][(positionHorizontal+1)] = right;
    playerMap[(positionVertical+1)][positionHorizontal] = down;
    playerMap[positionVertical][(positionHorizontal-1)] = left;


    return Arrays.copyOf(playerMap, playerMap.length);

}

public static String[] returnWallOrPath(int positionHorizontal, int positionVertical, int[][] locations){
    String tempUpdate[] = new String[4];

    if(locations[(positionVertical - 1)][positionHorizontal] == 1){       /* FEL */
        tempUpdate[0] = "/";
    }  else if (locations[(positionVertical - 1)][positionHorizontal] == 3){
        tempUpdate[0] = "M";
    }  else if (locations[(positionVertical - 1)][positionHorizontal] == 4){
        tempUpdate[0] = "B";
    }  else if (locations[(positionVertical - 1)][positionHorizontal] == 6){
        tempUpdate[0] = "$";
    }  else if (locations[(positionVertical - 1)][positionHorizontal] != 1){
        tempUpdate[0] = " ";
    }
    if(locations[positionVertical][(positionHorizontal + 1)] == 1){       /* JOBBRA */
        tempUpdate[1] = "/";
    }  else if (locations[positionVertical][(positionHorizontal + 1)] == 3){
        tempUpdate[1] = "M";
    }  else if (locations[positionVertical][(positionHorizontal + 1)] == 4){
        tempUpdate[1] = "B";
    }   else if (locations[positionVertical][(positionHorizontal + 1)] == 6){
        tempUpdate[1] = "$";
    }   else if (locations[positionVertical][(positionHorizontal + 1)] != 1){
        tempUpdate[1] = " ";
    }
    if(locations[positionVertical][(positionHorizontal - 1)] == 1){       /* BALRA */
        tempUpdate[2] = "/";
    }   else if (locations[positionVertical][(positionHorizontal - 1)] == 3){
        tempUpdate[2] = "M";
    }   else if (locations[positionVertical][(positionHorizontal - 1)] == 4){
        tempUpdate[2] = "B";
    }   else if (locations[positionVertical][(positionHorizontal - 1)] == 6){
        tempUpdate[2] = "$";
    }   else if (locations[positionVertical][(positionHorizontal - 1)] != 1){
        tempUpdate[2] = " ";
    }
    if(locations[(positionVertical + 1)][positionHorizontal] == 1){       /* LE */
        tempUpdate[3] = "/";
    }   else if (locations[(positionVertical + 1)][positionHorizontal] == 3){
        tempUpdate[3] = "M";
    }   else if (locations[(positionVertical + 1)][positionHorizontal] == 4){
        tempUpdate[3] = "B";
    }   else if (locations[(positionVertical + 1)][positionHorizontal] == 6){
        tempUpdate[3] = "$";
    }   else if (locations[(positionVertical + 1)][positionHorizontal] != 1){
        tempUpdate[3] = " ";
    }

    return Arrays.copyOf(tempUpdate, tempUpdate.length);
}

public static void showMoveOptions(int positionHorizontal, int positionVertical, int[][] locations){


    if(locations[(positionVertical-1)][positionHorizontal] != 1 ){
        System.out.print("\t\t1. Fel\n");
    }
    if(locations[positionVertical][(positionHorizontal-1)] != 1){
        System.out.print("4. Balra");
    }
    if(locations[positionVertical][(positionHorizontal+1)] != 1){
        System.out.print("\t\t\t2. Jobbra");
    }
    if(locations[(positionVertical+1)][positionHorizontal] != 1){
        System.out.print("\n\t\t3. Le");
    }

    System.out.println("\n\n5. Terkep megtekintese nagyban");
    System.out.println("\n6. Statok mutatasa");
}

public static int[] playerMove(int positionHorizontal, int positionVertical, int[][] locations, int userChoice, String[][] playerMap, Player jatekos){
 
    int[] positions = new int[2];
    positions[0] = positionVertical;
    positions[1] = positionHorizontal;

    switch (userChoice){

        case 1: 
        if (locations[(positionVertical - 1)][positionHorizontal] != 1){
            positions[0] = (positionVertical - 1);
            positions[1] = positionHorizontal;
            return Arrays.copyOf(positions, positions.length);
            } else {
            break;
            }

        case 2:
        if (locations[positionVertical][(positionHorizontal + 1)] != 1){
            positions[0] = positionVertical;
            positions[1] = positionHorizontal + 1;
            return Arrays.copyOf(positions, positions.length);
            } else {
            break;
            }
        
        case 3:
        if (locations[(positionVertical + 1)][positionHorizontal] != 1){
            positions[0] = positionVertical + 1;
            positions[1] = positionHorizontal;
            return Arrays.copyOf(positions, positions.length);
            } else {
            break;
            }
        
        case 4:
        if (locations[positionVertical][(positionHorizontal - 1)] != 1){
            positions[0] = positionVertical;
            positions[1] = positionHorizontal - 1;
            return Arrays.copyOf(positions, positions.length);
            } else {
            break;
            }
        case 5: showMap(playerMap);
        return Arrays.copyOf(positions, positions.length);
        case 6: System.out.println(jatekos);
        return Arrays.copyOf(positions, positions.length);
       }
       System.out.println("Arra fal van, valassz masik iranyt.");
       return Arrays.copyOf(positions, positions.length);
       
}


/**************************************************************Esemény funkciók***********************************************************/
public static void randomTrap(Player jatekos, Weapon[] minionWeapon, Shield[] minionShield, Weapon[] bossWeapon, Shield[] bossShield){                                  /* randomtrap kell még a player szint a damage számításhoz! */
    int temp = diceRoll();
    switch (randomNumber14()) {
        case 1: minionWeaponDamageUpgrade(minionWeapon);
                minionShieldDefenseUpgrade(minionShield);
                break;
        case 2: bossWeaponDamageUpgrade(bossWeapon);
                bossShieldDefenseUpgrade(bossShield);
                break;
        case 3: jatekos.setHp(jatekos.getHp() - temp);
                System.out.println("Sajnos csapdaba leptel mely " + temp + " sebzest okozott neked");
                checkDeath(jatekos);
                break;
        case 4: jatekos.setMana(jatekos.getMana() - temp);
                System.out.println("Sajnos magikus gyengeseg jarja at a csonjatid " + temp + " manat veszitettel");
                break;
    }

}
public static void randomGift(Player jatekos, Weapon[] playerWeapon, Shield[] playerShield){
    switch (randomNumber14()) {
        case 1: playerWeaponDamageUpgrade(playerWeapon); break;
        case 2: playerShieldDefenseUpgrade(playerShield); break;
        case 3: jatekos.setHp(jatekos.getHp() + 20); break;
        case 4: jatekos.setMana(jatekos.getMana() + 10); break;
        
    }
}

/***********************************************************Harc*************************************************************/
/***********************************************************Harc*************************************************************/
/***********************************************************Harc*************************************************************/

    public static void minionFight(Player jatekos, Minion minion, int playerWeaponInt, int playerShieldInt, int spellLevel, int minionWeaponInt, int minionShieldInt, int healthPotionNumber, int manaPotionNumber) {
            Scanner scanner = new Scanner(System.in);
            int jatekosSebzes = jatekos.getWeapon().getWeaponDamage();
            jatekosSebzes = (int)(jatekosSebzes * 0.8);
            int jatekosVedelem = jatekos.getShield().getDefense();
            jatekosVedelem = (int)(jatekosVedelem *0.8);
            int minionSebzes = minion.getWeapon().getWeaponDamage();
            minionSebzes = (int)(minionSebzes *0.8);
            int minionVedelem = minion.getShield().getDefense();
            minionVedelem = (int)(minionVedelem *0.8);
            System.out.println("Eled kerult: " + minion.getMinionName());

            while (jatekos.getHp() > 0 && minion.getMinionHp() > 0) {
                    int userChoice3 = 0;
                    System.out.println(
                    "\n1. tamadas fegyverekkel\n" +
                    "2. varazslatot hasznalsz\n" +
                    "3. elet poti\n" +
                    "4. mana poti\n" );
                    System.out.print("Most mi tevo leszel? Valassz: ");
                    userChoice3 = scanner.nextInt();
                    
                
                switch (userChoice3){

                    case 1:
                            int tempRoll = diceRoll();
                            int damage = tempRoll + jatekosSebzes - minionVedelem;
                            if (damage < 0) {damage = 0; };
                            minion.setMinionHp(minion.getMinionHp()-damage);
                            if (minion.getMinionHp() <= 0){
                                System.out.println("\n" + damage + " sebzest vittel be. ");
                                System.out.println("Sikeresen legyozted");
                                break;
                                }

                            System.out.println(damage + " sebzest vittel be. " + minion.getMinionHp() + " elete maradt.");
                            tempRoll = diceRoll();
                            damage = tempRoll + minionSebzes - jatekosVedelem;
                            if (damage < 0) {damage = 0;};
                            jatekos.setHp(jatekos.getHp() - damage);
                            checkDeath(jatekos);
                            System.out.println(damage + " sebzest vitt be neked. " + jatekos.getHp() + " eleted maradt.");
                            break;

                        case 2:
                        if (spellLevel < 0) {
                            System.out.println("Nincs varazslatod");
                            break;
                        }
                        if (jatekos.getMana()-jatekos.getSpell().getManaCost() < 0) {
                            System.out.println("Nincs eleg manad a varazslashoz");
                            break;
                        }
                        minion.setMinionHp(minion.getMinionHp() - jatekos.getSpell().getDamage());
                        jatekos.setMana(jatekos.getMana() - jatekos.getSpell().getManaCost());
                        System.out.println("Elhasznaltal: " + jatekos.getSpell().getManaCost() + " manat.");
                        System.out.println("Kilottel egy: " + jatekos.getSpell().getName() + " varazslatot amely eltalata: " + minion.getMinionName() + ". " + jatekos.getSpell().getDamage() + 
                        " sebzest okozva " + minion.getMinionHp() + " elete maradt." );
                        if (minion.getMinionHp() <= 0) {
                            System.out.println("A varazslatod telibetalalta es meghalt");
                        }
                        break;

                        case 3:
                        useHealthPotion(jatekos, healthPotionNumber);
                        break;
                        case 4:
                        useManaPotion(jatekos, manaPotionNumber);
                        break;
                        default: System.out.println("Ervenytelen valasztas.");
                }
            }
            
            
    }

    public static void bossFight(Player jatekos, Boss boss, int playerWeaponInt, int playerShieldInt, int bossWeaponInt, int bossShieldInt, int 
    spellLevel, int healthPotionNumber, int manaPotionNumber) {
            Scanner scanner2 = new Scanner(System.in);
            int jatekosSebzes = jatekos.getWeapon().getWeaponDamage();
            jatekosSebzes = (int)(jatekosSebzes * 0.8);
            int jatekosVedelem = jatekos.getShield().getDefense();
            jatekosVedelem = (int)(jatekosVedelem *0.8);
            int bossSebzes = boss.getBossWeapon().getWeaponDamage();
            bossSebzes = (int)(bossSebzes *0.8);
            int bossVedelem = boss.getBossShield().getDefense();
            bossVedelem = (int)(bossVedelem *0.8);
            System.out.println("Eled kerult: " + boss.getBossName());

            while (jatekos.getHp() > 0 && boss.getBossHp() > 0) {
                    int userChoice4 = 0;
                    System.out.println(
                    "\n1. tamadas fegyverekkel\n" +
                    "2. varazslatot hasznalsz\n" +
                    "3. elet poti\n" +
                    "4. mana poti\n" );
                    System.out.print("Most mi tevo leszel? Valassz: ");
                    userChoice4 = scanner2.nextInt();
                
                switch (userChoice4){

                    case 1:
                            int tempRoll = diceRoll();
                            int damage = tempRoll + jatekosSebzes - bossVedelem;
                            if (damage < 0) {damage = 0; };
                            boss.setBossHp(boss.getBossHp()-damage);
                            if (boss.getBossHp() <= 0){
                                System.out.println("\n" + damage + " sebzest vittel be. ");
                                System.out.println("Sikeresen legyozted");
                                break;
                                }

                            System.out.println(damage + " sebzest vittel be. " + boss.getBossHp() + " elete maradt.");
                            tempRoll = diceRoll();
                            damage = tempRoll + bossSebzes - jatekosVedelem;
                            if (damage < 0) {damage = 0;};
                            jatekos.setHp(jatekos.getHp() - damage);
                            if (jatekos.getHp() <= 0) {
                                System.out.println(damage + " sebzest vitt be neked.");
                                checkDeath(jatekos);
                            }
                            System.out.println(damage + " sebzest vitt be neked. " + jatekos.getHp() + " eleted maradt.");
                            break;

                        case 2:
                        if ( spellLevel < 0) {
                            System.out.println("Nincs varazslatod");
                            break;
                        }
                        if (jatekos.getMana()-jatekos.getSpell().getManaCost() < 0) {
                            System.out.println("Nincs eleg manad a varazslashoz");
                            break;
                        }
                        boss.setBossHp(boss.getBossHp() - jatekos.getSpell().getDamage());
                        jatekos.setMana(jatekos.getMana() - jatekos.getSpell().getManaCost());
                        System.out.println("Elhasznaltal: " + jatekos.getSpell().getManaCost() + " manat.");
                        System.out.println("Kilottel egy: " + jatekos.getSpell().getName() + " varazslatot amely eltalata: " + boss.getBossName() + ". " + jatekos.getSpell().getDamage() + 
                        " sebzest okozva " + boss.getBossHp() + " elete maradt." );
                        if (boss.getBossHp() <= 0) {
                            System.out.println("A varazslatod telibetalalta es meghalt");
                        }
                        break;
                        case 3:
                        useHealthPotion(jatekos, healthPotionNumber);
                        break;
                        case 4:
                        useManaPotion(jatekos, manaPotionNumber);
                        break;
                        default: System.out.println("Ervenytelen valasztas.");
                }
            }
    }
/***********************************************************Harc vége*************************************************************/

}