public class JediGuardian extends Jedi {

  private int fullHealth = 600;
  private int fullForcePool = 400;
  
  // Player constructor
  public JediGuardian(String name) {
    super(600, 400, name);
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

  

  // Strongest attacks: forceJump, throwLightsaber
  public void forceJump(Jedi jedi) {
    if (!this.canUseStrongForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    System.out.println("Mustering their whole strength in the Force, " 
                      + super.getName()
                      + " launches themself into the opponent.");
    super.calculateForcePool(3);
    super.calculateDamage(jedi, 3);
  }

  public void throwLightsaber(Jedi jedi) {
    if (!this.canUseStrongForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    System.out.println("Mustering their whole strength in the Force, " 
                       + super.getName() 
                       + " hurls their lightsaber at the opponent.");
    super.calculateForcePool(3);
    super.calculateDamage(jedi, 3);
  }

  // Moderate attacks: forcePoison, forceLightning
  public void forcePoison(Jedi jedi) {
    if (!this.canUseModerateForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    
    System.out.println("Gathering their strength in the Force, "
                       + super.getName()
                       + " manipulates the opponent's mind as if they were poisoned.");
    super.calculateForcePool(2);
    super.calculateDamage(jedi, 2);
  }

  public void forceLightning(Jedi jedi) {
    if (!this.canUseModerateForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    
    System.out.println("Gathering their strength in the Force, "
                       + super.getName() 
                       + " casts a bolt of lightning at their opponent.");
    super.calculateForcePool(2);
    super.calculateDamage(jedi, 2);
  }

  // Description for .main()
  // Description pulled straight from Star Wars: KotOR
  public static void classDescription() {
    System.out.println("\n- Jedi Guardians battle against the forces of evil and the dark side. (Higher health, lower Force points)");
  }

  public String toString() {
    return "Jedi Guardian: " + super.toString();
  }
}