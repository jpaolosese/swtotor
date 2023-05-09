public class Enemy extends Jedi {

  public Enemy() {
    super();
    this.setName("Dark Jedi");
  }

  // Invokes inherited constructor
  public Enemy(int health, int forcePool, String name) {
    super(health, forcePool, name);
  }

  public String toString() {
    return "Enemy: " + super.toString();
  }

  // All Enemy objects will do moderate damage
  public void forcePush(Jedi jedi) {
    if (!this.canUseModerateForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    System.out.println("Gathering their strength in the Force, the " 
                       + super.getName() 
                       + " knocks you to the ground.");
    super.calculateForcePool(2);
    super.calculateDamage(jedi, 2);
  }

  public void throwLightsaber(Jedi jedi) {
    if (!this.canUseModerateForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    System.out.println("Gathering their strength, the " 
                       + super.getName() 
                       + " throws their lightsaber at you.");
    super.calculateForcePool(2);
    super.calculateDamage(jedi, 2);
  }

  public void forcePoison(Jedi jedi) {
    if (!this.canUseModerateForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    System.out.println("Gathering their strength in the Force, the " 
                       + super.getName()
                       + " manipulates your mind as if you were poisoned.");
    super.calculateForcePool(2);
    super.calculateDamage(jedi, 2);
  }

  public void forceLightning(Jedi jedi) {
    if (!this.canUseModerateForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    System.out.println("Gathering their strength in the Force, the " 
                       + super.getName() 
                       + " casts a bolt of lightning at you.");
    super.calculateForcePool(2);
    super.calculateDamage(jedi, 2);
  }

  public void forceJump(Jedi jedi) {
    if (!this.canUseModerateForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    System.out.println("Gathering their strength in the Force, the " 
                 + super.getName() 
                 + " launches themself at you.");
    super.calculateForcePool(2);
    super.calculateDamage(jedi, 2);
  }

  public void forceChoke(Jedi jedi) {
    if (!this.canUseModerateForcePowers()) {
      System.out.println("Force points too low! Switching to standard attack.");
      this.attack(jedi);
      return;
    }
    System.out.println("Gathering their strength in the Force, the " 
                       + super.getName() 
                       + " suffocates you.");
    super.calculateForcePool(2);
    super.calculateDamage(jedi, 2);
  }

}