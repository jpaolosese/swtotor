public class JediSentinel extends Jedi {

  private int fullHealth = 500;
  private int fullForcePool = 500;

  // Player constructor
  public JediSentinel(String name) {
    super(500, 500, name);
  }
  
  // Getters and setters for full class points
  public int getFullHealth() {
    return fullHealth;
  }

  public int getFullForcePool() {
    return fullForcePool;
  }

  // Setters not needed but added for completeness
  public void setFullHealth(int health) {
    this.fullHealth = health;
  }

  public void setFullForcePool(int force) {
    this.fullForcePool = force;
  }


  // Strongest attacks: forcePush, forcePoison
  public void forcePush(Jedi jedi) {
    if (!this.canUseStrongForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    System.out.println("Mustering their whole strength in the Force, " 
                      + super.getName()
                      + " launches their opponent at the wall.");
    super.calculateForcePool(3);
    super.calculateDamage(jedi, 3);
  }

  public void forcePoison(Jedi jedi) {
    if (!this.canUseStrongForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    System.out.println("Mustering their whole strength in the Force, " 
                       + super.getName()
                       + " manipulates the opponent's mind as if they were poisoned.");
    super.calculateForcePool(3);
    super.calculateDamage(jedi, 3);
  }

  // Moderate attacks: forceJump, forceChoke
  public void forceJump(Jedi jedi) {
    if (!this.canUseModerateForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    
    System.out.println("Gathering their strength in the Force, "
                       + super.getName()
                       + " launches themself at their opponent");
    super.calculateForcePool(2);
    super.calculateDamage(jedi, 2);
  }

  public void forceChoke(Jedi jedi) {
    if (!this.canUseModerateForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    
    System.out.println("Gathering their strength in the Force, "
                      + super.getName() 
                      + " suffocates their opponent.");
    super.calculateForcePool(2);
    super.calculateDamage(jedi, 2);
  }

  // Description for .main()
  // Description pulled straight from Star Wars: KotOR
  public static void classDescription() {
    System.out.println("\n- Jedi Sentinels ferret out deceit and injustice, bringing them to light. (Equal Force points and health)");
  }

  public String toString() {
    return "Jedi Sentinel: " + super.toString();
  }
}