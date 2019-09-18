public interface Weapon {
void action();
}

class Knife implements Weapon{

	@Override
	public void action() {
		System.out.println("Perform knife attack");
	}
	}

class Revolver implements Weapon{

	@Override
	public void action() {
		System.out.println("Perform revolver attack");
		
	}
	}
class PlasmaGun implements Weapon{

	@Override
	public void action() {
		System.out.println("Perform plasma gun attack");
		
	}
	}