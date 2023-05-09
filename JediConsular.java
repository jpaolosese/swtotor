public class JediConsular extends Jedi {

  private int fullHealth = 400;
  private int fullForcePool = 600;
   
  // Player constructor
  public JediConsular(String name) {
    super(400, 600, name);
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

  

  // Strongest attacks: forceLightning, forceChoke
  public void forceLightning(Jedi jedi) {
    if (!this.canUseStrongForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    
    System.out.println("Mustering their whole strength in the Force, " 
                      + super.getName()
                      + " unleashes a powerful bolt of lightning on the opponent.");
    super.calculateForcePool(3);
    super.calculateDamage(jedi, 3);
  }

  public void forceChoke(Jedi jedi) {
    if (!this.canUseStrongForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    
    System.out.println("Mustering their whole strength in the Force, " 
                      + super.getName() 
                      + " utterly suffocates their opponent.");
    super.calculateForcePool(3);
    super.calculateDamage(jedi, 3);
  }

  // Moderate attacks: forcePush, throwLightsaber
  public void forcePush(Jedi jedi) {
    if (!this.canUseModerateForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    
    System.out.println("Gathering their strength in the Force, "
                      + super.getName()
                      + " knocks their opponent to the ground.");
    super.calculateForcePool(2);
    super.calculateDamage(jedi, 2);
  }

  public void throwLightsaber(Jedi jedi) {
    if (!this.canUseModerateForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    
    System.out.println("Gathering their strength, " 
                      + super.getName()
                      + " throws their lightsaber at the opponent.");
    super.calculateForcePool(2);
    super.calculateDamage(jedi, 2);
  }

  // Description for .main()
  // Description pulled straight from Star Wars: KotOR
  public static void classDescription() {
    System.out.println("\n- Jedi Consulars seek to bring balance to the universe. (Higher Force points, lower health)");
  }

  // .toString() just so I know object was casted correctly
  public String toString() {
    return "Jedi Consular: " + super.toString();
  }
}