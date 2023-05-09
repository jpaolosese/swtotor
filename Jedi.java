import java.util.*; // Need for Random class for .roll() method

public class Jedi implements Powers {
  
  private int health;
  private int forcePool;
  private String name;

  // Default constructor full points
  private int fullHealth = 250;
  private int fullForcePool = 250;

  // Parametrized constructor
  // JediGuardian health = 600, forcePool = 400, name = "Jedi Guardian"
  // JediSentinel health = forcePool = 500, name = "Jedi Sentinel"
  // JediConsular health = 400, forcePool = 600, name = "Jedi Consular"
  public Jedi (int health, int forcePool, String name) {
    this.health = health;
    this.forcePool = forcePool;
    this.name = name;
  }

  // Default constructor
  // Enemy class overrides name with "Enemy"
  public Jedi() {
    this.health = 250;
    this.forcePool = 250;
    this.name = "Jedi";
  }

  // Getters and setters
  public int getHealth() {
    return health;
  }
  public void setHealth(int health) {
    this.health = health;
  }

  public int getForcePool() {
    return forcePool;
  }
  public void setForcePool(int force) {
    this.forcePool = force;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  // Getters and setters for full class points
  public int getFullHealth() {
    return fullHealth;
  }

  public int getFullForcePool() {
    return fullForcePool;
  }

  // Setters not needed for full class points but added for completeness
  public void setFullHealth(int health) {
    this.fullHealth = health;
  }

  public void setFullForcePool(int force) {
    this.fullForcePool = force;
  }

  public String toString() {
    return name 
      + ". Current health: " + health
      + ". Current Force pool: " + forcePool + ".";
  }

  // Booleans
  public boolean isAlive() {
    return this.health > 0;
  }
  
  public boolean canUseStrongForcePowers() {
    return this.forcePool >= 45;
  }

  public boolean canUseModerateForcePowers() {
    return this.forcePool >= 30;
  }
  
  public boolean canUseForcePowers() {
    return this.forcePool >= 15;
  }

  // .roll() uses java.util.Random
  // Combat roll (critical hit >= 19, bound == 21)
  // 20% chance to heal (bound = 5)
  public int roll(int bound) {
    Random rng = new Random();
    return rng.nextInt(bound);
  }
  
  // Damage hierarchy strongest to weakest
  
  // forceJump:       JediGuardian -> JediSentinel -> JediConsular
  // throwLightsaber: JediGuardian -> JediConsular -> JediSentinel
  // forcePush:       JediSentinel -> JediGuardian -> JediConsular
  // forcePoison:     JediSentinel -> JediConsular -> JediGuardian
  // forceChoke:      JediConsular -> JediSentinel -> JediGuardian
  // forceLightning:  JediConsular -> JediGuardian -> JediSentinel

  // Strongest attacks: "Mustering their whole strength..."
  // Moderate attacks: "Gathering their strength..."
  // Default weak attacks "__ uses the Force...", overridden by stronger attacks

  // Weak damage = 20, weak critical = 40
  // Weak forcePool() -= 15
  // Moderate damage = 30, moderate critical = 60
  // Moderate forcePool() -= 30
  // Strongest damage = 40, strongest critical = 80
  // Strongest forcePool() -= 45
  public void calculateDamage(Jedi jedi, int level) {
    // Level determines strength of attack, 1 weakest -> 3 strongest
    int weakDamage = 20;
    int moderateDamage = 30;
    int strongDamage = 40;

    // 1d20, 20 (19) Critical hit
    if (this.roll(20) >= 19) {
      weakDamage *= 2;
      moderateDamage *= 2;
      strongDamage *= 2;
      System.out.print("Critical hit! ");
    }

    switch(level) {
      case 1: 
        jedi.setHealth(jedi.getHealth() - weakDamage);
        System.out.print(weakDamage + " damage inflicted.\n\n");
        break;
      case 2:
        jedi.setHealth(jedi.getHealth() - moderateDamage);
        System.out.print(moderateDamage + " damage inflicted.\n\n");
        break;
      case 3:
        jedi.setHealth(jedi.getHealth() - strongDamage);
        System.out.print(strongDamage + " damage inflicted.\n\n");
        break;
    }
  }

  public void calculateForcePool(int level) {
    int spent = 15;
    switch (level) {
      case 1:
        this.forcePool -= spent;
        System.out.print(spent + " Force points spent. ");
        break;
      case 2:
        spent *= 2;
        this.forcePool -= spent;
        System.out.print(spent + " Force points spent. ");
        break;
      case 3:
        spent *= 3;
        this.forcePool -= spent;
        System.out.print(spent + " Force points spent. ");
        break;
    }
  }
  
  // Force powers and attacks
  // Default weak attacks
  public void attack(Jedi jedi) {  
    System.out.println(this.name + " strikes at their opponent.");
    this.calculateDamage(jedi, 1);
  }

  public void forceJump(Jedi jedi) {
    if (!this.canUseForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    
    System.out.println(this.getName() + " uses the Force to launch themself into the opponent");
    this.calculateForcePool(1);
    this.calculateDamage(jedi, 1);
  }

  public void forcePoison(Jedi jedi) {
    if (!this.canUseForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    
    System.out.println(this.getName() + " uses the Force to manipulate the opponent's mind as if they were poisoned.");
    this.calculateForcePool(1);
    this.calculateDamage(jedi, 1);
  }

  public void forcePush(Jedi jedi) {
    if (!this.canUseForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    
    System.out.println(this.getName() + " uses the Force to stagger their opponent.");
    this.calculateForcePool(1);
    this.calculateDamage(jedi, 1);
  }

  public void forceChoke(Jedi jedi) {
    if (!this.canUseForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    
    System.out.println(this.getName() + " uses the Force to choke their opponent.");
    this.calculateForcePool(1);
    this.calculateDamage(jedi, 1);
  }

  public void throwLightsaber(Jedi jedi) {
    if (!this.canUseForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    
    System.out.println(this.getName() + " uses the Force to throw their lightsaber at the opponent.");
    this.calculateForcePool(1);
    this.calculateDamage(jedi, 1);
  }

  public void forceLightning(Jedi jedi) {
    if (!this.canUseForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    
    System.out.println(this.getName() + " uses the Force to shock their opponent.");
    this.calculateForcePool(1);
    this.calculateDamage(jedi, 1);
  }

}