
class WeaponFactory{
	
	public static Weapon getWeapon(String weaponName) {
		Weapon weapon=null;
		if(weaponName.equals("knife")) {
			weapon=new Knife();
		}
		if(weaponName.equals("revolver")) {
			weapon=new Revolver();
		}
		if(weaponName.equals("Plasma Gun")) {
			weapon=new PlasmaGun();
		}
		return weapon;
		
	}
}


public class Player {
	  private Weapon weapon;
	  private String name;
	  public Player(String name, Weapon weapon) {
	    this.name = name;
	    this.weapon = weapon;
	  }
	  public void setWeapon(Weapon weapon) {
	    this.weapon = weapon;
	  }

	 public static void main(String args[]) {
		 
		 WeaponFactory wf= new WeaponFactory();
		 Weapon weapon = wf.getWeapon("revolver");
		 weapon.action(); 	 
	 }
	}