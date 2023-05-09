import java.util.*;

// Created Game class
// Adding more methods under Main got clunky
public class Game {

  // Main game method
  public void campaign(Jedi jedi) {
    // Scanner object created for user input
    Scanner sc = new Scanner(System.in);
    
    System.out.println("\nYou have infiltrated the poor guy's program. Get ready to fight!");  
    System.out.println(jedi.toString());  // Print user stats
    ArrayList<Enemy> enemyList = this.generateEnemyList();


    int enemiesKilled = 0;  // Keep count of enemies killed
    int attackOption = 1;   // Attack option, default = 1 - standard attack
    // Superfluous, enemyList.size() = 15
    int totalEnemies = enemyList.size();

    // Traverse ArrayList enemyList with for-each loop
    for (Enemy currentEnemy : enemyList) {
      System.out.println("\nAlert! A " + currentEnemy.getName() + " attacks!");
      System.out.println(currentEnemy.toString());
      while (currentEnemy.isAlive()) {
        // Display attack options, let user decide which attack
        displayAttackOptions();
        
        try {
          attackOption = sc.nextInt();
        } 
        catch (Exception e) {
          // If user inputs a char, for example
          // Default to standard attack
          // Without exception handling
          // Game loops infinitely until user dies
          // Or miraculously defeats all enemies
          sc.next();
          attackOption = 1;
        }
        
        // Break if user wants to quit prematurely
        if (attackOption == 8) 
          break;

        // User's turn to attack with selected option
        System.out.println();
        selectAttack(attackOption, jedi, currentEnemy);

        // Enemy's turn to attack with randomly selected option
        int enemyOption = currentEnemy.roll(8);
        selectAttack(enemyOption, currentEnemy, jedi);

        // 16.67% chance to heal
        if (jedi.roll(6) >= 5) {
          System.out.println("As you attack this enemy, you fully heal yourself with the Force.");
          // Fully heal
          System.out.println("+" + (jedi.getFullHealth() - jedi.getHealth()) + " to health\n");
          jedi.setHealth(jedi.getFullHealth());
          System.out.println(jedi.toString());
        }
        
        // 12.5% chance to recharge Force Points
        if (jedi.roll(8) >= 7) {
          System.out.println("As you attack this enemy, your connection to the Force is fully rejuvenated");
          // Recharge forcePool
          System.out.println("+" + (jedi.getFullForcePool() - jedi.getForcePool()) + " to Force pool");
          jedi.setForcePool(jedi.getFullForcePool());
          System.out.println(jedi.toString());
          System.out.println();
        }

        // Display both user's and currentEnemy's stats with .toString()
        System.out.println(jedi.toString());
        System.out.println(currentEnemy.toString());
        
          // Game over if user is dead after enemy attack
        if (!jedi.isAlive()) {
          break;
        }
      }
      
      // Upon quitting game or !jedi.isAlive()
      if (attackOption == 8 || !jedi.isAlive())  
        break;

      // Upon currentEnemy death
      System.out.print("\n" + currentEnemy.getName() + " killed. ");
      enemiesKilled++;
      System.out.println(enemiesKilled + "/" + totalEnemies + " enemies killed. ");
    }

    // Post-game debrief
    if (!jedi.isAlive()) { // Upon user death
      System.out.println("\nYou have died. The Sith are victorious and the poor sap's program is irreparably destroyed. Game over.\n");
    } else if (enemiesKilled >= 15) { // Upon win
      System.out.println("\nYou are victorious. The Sith have been eliminated from the poor sap's program.\n");
    }

    // Close game
    System.out.println(enemiesKilled + "/" + totalEnemies + " enemies killed.");
    System.out.println("Thank you for playing!");
    sc.close(); 
  }
  // End main game method

  
  // Method that creates and populates ArrayList with class Enemy
  public ArrayList<Enemy> generateEnemyList() {
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    // Populate list
    for (int i = 0; i < 15; i++) {
      int rand = (int)((Math.random() * 5 ));
      Enemy enemy = new Enemy();

      // 1 in 5 chance Enemy object has more health and forcePool
      // On average enemyList should contain about 3 stronger enemies
      if (rand >= 4) {
        Enemy darkJediMaster = new Enemy(350, 300, "Dark Jedi Master");
        enemies.add(darkJediMaster);
        continue;
      }

      enemies.add(enemy);
    }
    return enemies;
  }

  // Welcomes user in iconic Star Wars fashion
  public static void openingCrawl() {
    System.out.println("\n\n\nA long time ago, in a server far, far away...");
    System.out.println("(Press \"enter\" to continue) ");
    promptEnterKey();
    System.out.println("\nSTAR WARS: TEXT OF THE OLD REPUBLIC\t(\"enter\" to continue)");
    promptEnterKey();
    System.out.println("\nThe Jedi are victorious. Peace reigns throughout the Republic. The remaining Sith have been driven back to the far edges of the galaxy, beyond the sight of the Jedi.\t(\"enter\" to continue)");
    promptEnterKey();
    System.out.println("\nBut the Sith are not so easily wiped out. Although few in number, there, in the dark corners of the galaxy, the Sith plot their revenge against the Republic.\t(\"enter\" to continue) ");
    promptEnterKey();
    System.out.println("\nA contingent of Dark Jedi have infiltrated some poor sap's program. The poor sap requests aid in completing his program and the Jedi Council has enlisted you, a Jedi, to infiltrate and fight the Sith within...");
    System.out.println("\n(\"enter\" to continue) ");
    promptEnterKey();
  }

  public void selectAttack(int attackOption, Jedi attacker, Jedi victim) {
    switch (attackOption) {
      case 2:
        attacker.forceJump(victim);
        break;
      case 3:
        attacker.throwLightsaber(victim);
        break;
      case 4:
        attacker.forcePush(victim);
        break;
      case 5:
        attacker.forcePoison(victim);
        break;
      case 6:
        attacker.forceChoke(victim);
        break;
      case 7:
        attacker.forceLightning(victim);
        break;
      default:
        attacker.attack(victim);
        break;
    }
  }

  public static void promptEnterKey() {
    Scanner sc = new Scanner(System.in);
    try {
      sc.nextLine();
    } catch (Exception e) {
    }
  }

  public static void displayAttackOptions() {
    System.out.println("\nSelect an attack:");
    System.out.println("1: Standard attack\t2: Force Jump\t3: Throw Lightsaber");
    System.out.println("4: Force Push\t5: Force Poison\t6: Force Choke");
    System.out.println("7: Force Lightning\t8: Quit game");
  }
}