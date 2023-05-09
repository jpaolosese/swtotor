// Star Wars: Knights of the Old Republic-inspired program
// User enters name and chooses a class:
// JediGuardian, JediSentinel, or JediConsular
// Object is created
// User traverses through ArrayList of type Enemy
// Fights currentEnemy until
// Program ends if !jedi.isAlive() <= 0
// Or if ArrayList<Enemy> has been fully traversed

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Game game = new Game();  // Game class contains game mechanics
    // Welcome user in iconic Star Wars fashion
    Game.openingCrawl();
    System.out.println("--Welcome to Star Wars: Text of the Old Republic!--");
    System.out.println("(\"enter\" to continue)\n");
    Game.promptEnterKey();
    
    // Ask username
    System.out.print("Enter name: ");

    String name = "";
    
    try {
      name = sc.nextLine();
    } catch (Exception e) {
    }
    
    if (name.equals("")) {
        name = "Force Adept";
    }
    
    // Ask user desired child class of Jedi 
    System.out.println("\nJedi classes: ");
    JediGuardian.classDescription();
    JediSentinel.classDescription();
    JediConsular.classDescription();

    System.out.print("\nSelect: \n1 - Jedi Guardian, ");
    System.out.print("2 - Jedi Sentinel, ");
    System.out.print("3 - Jedi Consular\n");
    System.out.println("(Any other option defaults to Jedi Guardian)");

    // Choose Jedi child classes
    int option = 1;
    try {
      option = sc.nextInt();
    } catch (Exception e) {
      // Don't do anything since selected class defaults to JediGuardian
    }

    // Select and create child class object, pass object into game.campaign()
    switch (option) {
      case 2:
        System.out.println("Jedi Sentinel selected.");
        JediSentinel js = new JediSentinel(name);
        game.campaign(js);
        break;
      case 3:
        System.out.println("Jedi Consular selected.");
        JediConsular jc = new JediConsular(name);
        game.campaign(jc);
        break;
      default:
        System.out.println("Jedi Guardian selected.");
        JediGuardian jg = new JediGuardian(name);
        game.campaign(jg);
        break;
    }
    
    sc.close();
  } 
}