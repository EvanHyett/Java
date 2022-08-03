package zoo_keeper;

public class Bat extends Mammal {
	
//	Constructor
	public Bat() {
		super();
		this.energyLevel = 300;
	}
	
//	Methods
	public int fly() {
		this.energyLevel -= 50;
		System.out.println("Whoooosh.");
		return energyLevel;
	}
	
	public int eatHumans() {
		this.energyLevel += 25;
		return energyLevel;
	}
	
	public int attackTown() {
		this.energyLevel -= 100;
		System.out.println("OH NO, THE TOWN IS ON FIRE");
		return energyLevel;
	}

}
